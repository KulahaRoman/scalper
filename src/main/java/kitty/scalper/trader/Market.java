package kitty.scalper.trader;

import kitty.scalper.trader.entity.Order;

public interface Market {
    void placeOrder(Order order);
}
