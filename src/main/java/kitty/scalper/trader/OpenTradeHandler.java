package kitty.scalper.trader;

import org.springframework.stereotype.Component;

@Component
public class OpenTradeHandler implements TradeHandler {
    @Override
    public void handle(Trade trade) {
        System.out.println("Opened a trade at price " + trade.getOpenPrice());
    }
}
