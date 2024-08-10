package kitty.scalper.provider.binance;

import com.binance.connector.client.SpotClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import kitty.scalper.adapter.CandleBar;
import kitty.scalper.core.Candle;
import kitty.scalper.provider.HistoryProvider;
import kitty.scalper.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class BinanceHistoryProvider implements HistoryProvider {
    private final SpotClient client;

    @Autowired
    public BinanceHistoryProvider(SpotClient client) {
        this.client = client;
    }

    @Override
    public List<Candle> getCandleHistory(long size) {
        var parameters = new HashMap<String, Object>();
        parameters.put("symbol", "BTCUSDT");
        parameters.put("interval", "1s");

        var response = client.createMarket().klines(parameters);
        try {
            var responseJson = JSON.readObject(response, new TypeReference<ArrayList<ArrayList<Object>>>() {
            });
            return responseJson
                    .stream()
                    .map(values ->
                            new CandleBar(Duration.ofSeconds(1),
                                    ZonedDateTime.ofInstant(Instant.ofEpochMilli((long) values.get(6)),
                                            ZoneId.of("UTC")),
                                    Double.parseDouble((String) values.get(1)),
                                    Double.parseDouble((String) values.get(2)),
                                    Double.parseDouble((String) values.get(3)),
                                    Double.parseDouble((String) values.get(4)),
                                    Double.parseDouble((String) values.get(5))).toCandle())
                    .toList();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
