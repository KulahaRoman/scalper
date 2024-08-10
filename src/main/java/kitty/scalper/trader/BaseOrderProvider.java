package kitty.scalper.trader;

import kitty.scalper.trader.entity.Balance;
import kitty.scalper.trader.entity.Order;
import kitty.scalper.trader.entity.Quotation;
import org.springframework.stereotype.Component;

@Component
public class BaseOrderProvider implements OrderProvider {
    @Override
    public Order getBuyOrder(Quotation quotation, Balance balance, double price) {
        var order = new Order();
        order.setQuotation(quotation);
        order.setType(Order.OrderType.BUY);
        order.setPrice(price);
        order.setAmount(Math.max(quotation.getMinQuantity(), balance.getAmount()));

        return order;
    }

    @Override
    public Order getSellOrder(Quotation quotation, Balance balance, double price) {
        var order = new Order();
        order.setQuotation(quotation);
        order.setType(Order.OrderType.SELL);
        order.setPrice(price);
        order.setAmount(Math.max(quotation.getMinQuantity(), balance.getAmount()));

        return order;
    }
}
