package kitty.scalper.provider.binance;

import com.binance.connector.client.SpotClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import kitty.scalper.provider.ExchangeProvider;
import kitty.scalper.provider.binance.response.exchange.BinanceExchange;
import kitty.scalper.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class BinanceExchangeProvider implements ExchangeProvider<BinanceExchange> {
    private final SpotClient spotClient;

    private BinanceExchange cached = null;

    @Autowired
    public BinanceExchangeProvider(SpotClient spotClient) {
        this.spotClient = spotClient;
    }

    @Override
    public BinanceExchange getExchange() {
        if (cached != null) {
            return cached;
        }

        var response = spotClient.createMarket().exchangeInfo(Collections.emptyMap());
        try {
            cached = JSON.readObject(response, BinanceExchange.class);
            return cached;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
