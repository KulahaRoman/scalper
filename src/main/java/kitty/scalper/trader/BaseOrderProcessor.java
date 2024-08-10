package kitty.scalper.trader;

import kitty.scalper.trader.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class BaseOrderProcessor implements OrderProcessor {
    private final Market market;

    public BaseOrderProcessor(Market market) {
        this.market = market;
    }

    @Override
    public void processOrder(Order order) {
        market.placeOrder(order);
    }
}
