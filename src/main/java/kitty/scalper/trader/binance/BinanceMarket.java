package kitty.scalper.trader.binance;

import com.binance.connector.client.SpotClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import kitty.scalper.trader.Market;
import kitty.scalper.trader.entity.Order;
import kitty.scalper.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class BinanceMarket implements Market {
    private final SpotClient client;
    private final BinanceStorage storage;

    @Autowired
    public BinanceMarket(SpotClient client, BinanceStorage storage) {
        this.client = client;
        this.storage = storage;
    }

    @Override
    public void placeOrder(Order order) {
        switch (order.getType()) {
            case BUY -> placeBuyOrder(order);
            case SELL -> placeSellOrder(order);
        }
    }

    private void placeBuyOrder(Order order) {
        var symbol = (order.getQuotation().getBaseAsset()
                + order.getQuotation().getQuoteAsset()).toUpperCase();

        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", symbol);
        parameters.put("side", "BUY");
        parameters.put("type", "STOP_LOSS");
        parameters.put("quantity", order.getAmount());
        parameters.put("stopPrice", order.getPrice());

        var response = client.createTrade().testNewOrder(parameters);
        try {
            storage.save(JSON.readObject(response, kitty.scalper.trader.binance.response.Order.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse response.", e);
        }
    }

    private void placeSellOrder(Order order) {
        var symbol = (order.getQuotation().getBaseAsset()
                + order.getQuotation().getQuoteAsset()).toUpperCase();

        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", symbol);
        parameters.put("side", "SELL");
        parameters.put("type", "MARKET");
        parameters.put("quantity", order.getAmount());

        client.createTrade().testNewOrder(parameters);
        storage.clear();
    }
}
