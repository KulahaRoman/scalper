package kitty.scalper.trader.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    public enum OrderType {
        BUY, SELL
    }

    private OrderType type;
    private Quotation quotation;
    private double amount;
}
