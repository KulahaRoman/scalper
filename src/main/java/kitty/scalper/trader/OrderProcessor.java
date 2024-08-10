package kitty.scalper.trader;

import kitty.scalper.trader.entity.Order;

public interface OrderProcessor {
    void processOrder(Order order);
}
