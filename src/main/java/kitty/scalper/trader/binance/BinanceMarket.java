package kitty.scalper.trader.binance;

import com.binance.connector.client.SpotClient;
import kitty.scalper.trader.Market;
import kitty.scalper.trader.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class BinanceMarket implements Market {
    private final SpotClient client;

    @Autowired
    public BinanceMarket(SpotClient client) {
        this.client = client;
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

        client.createTrade().testNewOrder(parameters);
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
    }
}
