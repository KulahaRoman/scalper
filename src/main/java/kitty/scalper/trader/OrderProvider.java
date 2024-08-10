package kitty.scalper.trader;

import kitty.scalper.trader.entity.Balance;
import kitty.scalper.trader.entity.Order;
import kitty.scalper.trader.entity.Quotation;

public interface OrderProvider {
    Order getBuyOrder(Quotation quotation, Balance balance);

    Order getSellOrder(Quotation quotation, Balance balance);
}
