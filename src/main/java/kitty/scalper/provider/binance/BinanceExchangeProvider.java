package kitty.scalper.provider.binance;

import com.binance.connector.client.SpotClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import kitty.scalper.provider.ExchangeProvider;
import kitty.scalper.provider.binance.response.exchange.Exchange;
import kitty.scalper.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class BinanceExchangeProvider implements ExchangeProvider<Exchange> {
    private final SpotClient spotClient;

    @Autowired
    public BinanceExchangeProvider(SpotClient spotClient) {
        this.spotClient = spotClient;
    }

    @Override
    public Exchange getExchange() {
        var response = spotClient.createMarket().exchangeInfo(Collections.emptyMap());
        try {
            return JSON.readObject(response, Exchange.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
