package kitty.scalper.provider.binance;

import com.binance.connector.client.WebSocketStreamClient;
import com.binance.connector.client.utils.websocketcallback.WebSocketMessageCallback;
import com.fasterxml.jackson.core.JsonProcessingException;
import kitty.scalper.adapter.CandleBar;
import kitty.scalper.config.ScalperConfiguration;
import kitty.scalper.core.Candle;
import kitty.scalper.provider.CandleProvider;
import kitty.scalper.provider.binance.response.CandleStickEvent;
import kitty.scalper.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class BinanceCandleProvider implements CandleProvider {
    private final WebSocketStreamClient client;
    private Candle temporaryCandle;

    @Autowired
    public BinanceCandleProvider(WebSocketStreamClient client, ScalperConfiguration configuration) {
        this.client = client;

        WebSocketMessageCallback messageCallback = (data) -> {
            try {
                var event = JSON.readObject(data, CandleStickEvent.class);
                var candle = event.getCandleStick();

                temporaryCandle = new CandleBar(Duration.ofSeconds(1),
                        ZonedDateTime.ofInstant(Instant.ofEpochMilli(candle.getCloseTime()),
                                ZoneId.of("UTC")),
                        candle.getOpenPrice(), candle.getHighPrice(),
                        candle.getLowPrice(), candle.getClosePrice(),
                        candle.getVolume(), candle.getTrades()).toCandle();

                synchronized (this) {
                    notify();
                }
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        };

        var quotation = configuration.getScalpingQuotation();
        var period = configuration.getScalpingPeriod().toLowerCase();

        var symbol = (quotation.getBaseAsset()
                + quotation.getQuoteAsset()).toUpperCase();

        client.klineStream(symbol, period, messageCallback);
    }

    @Override
    public Candle getCandle() {
        synchronized (this) {
            try {
                while (temporaryCandle == null) {
                    this.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        var candle = temporaryCandle;
        temporaryCandle = null;

        return candle;
    }

    @Override
    public void close() throws Exception {
        client.closeAllConnections();
    }
}
