package kitty.scalper.trader;

import org.springframework.stereotype.Component;

@Component
public class CloseTradeHandler implements TradeHandler {
    @Override
    public void handle(Trade trade) {
        System.out.println("Closed the trade at price " + trade.getClosePrice());
    }
}
