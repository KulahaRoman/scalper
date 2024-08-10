package kitty.scalper.trader.binance;

import kitty.scalper.trader.binance.response.Order;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Component
public class BinanceStorage {
    private final Map<String, Order> orders = new HashMap<>();

    void save(Order order) {
        orders.put(order.getClientOrderID(), order);
    }

    boolean hasOrder(String clientOrderID) {
        return orders.containsKey(clientOrderID);
    }

    boolean hasOrder(Order order) {
        return orders.containsKey(order.getClientOrderID());
    }

    void remove(String clientOrderID) {
        orders.remove(clientOrderID);
    }

    void remove(Order order) {
        orders.remove(order.getClientOrderID());
    }

    void clear() {
        orders.clear();
    }
}
