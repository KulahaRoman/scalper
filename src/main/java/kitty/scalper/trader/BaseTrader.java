package kitty.scalper.trader;

import kitty.scalper.core.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class BaseTrader implements Trader {
    private final BalanceProvider balanceProvider;
    private final QuotationProvider quotationProvider;
    private final OrderProvider orderProvider;
    private final OrderProcessor orderProcessor;
    private final TradeHandler openTradeHandler;
    private final TradeHandler closeTradeHandler;
    private final TraderState traderState;

    @Autowired
    public BaseTrader(BalanceProvider balanceProvider, QuotationProvider quotationProvider,
                      OrderProvider orderProvider, OrderProcessor orderProcessor,
                      TradeHandler openTradeHandler, TradeHandler closeTradeHandler, TraderState traderState) {
        this.balanceProvider = balanceProvider;
        this.quotationProvider = quotationProvider;
        this.orderProvider = orderProvider;
        this.orderProcessor = orderProcessor;
        this.openTradeHandler = openTradeHandler;
        this.closeTradeHandler = closeTradeHandler;
        this.traderState = traderState;
    }

    @Override
    public void adviceToBuy(double price) {
        if (!traderState.hasActiveTrade()) {
            var quotation = quotationProvider.getQuotation();
            var balance = balanceProvider.getBalance(quotation.getQuoteAsset());

            var order = orderProvider.getBuyOrder(quotation, balance, price);
            orderProcessor.processOrder(order);

            var trade = new Trade();
            trade.setOpenTime(ZonedDateTime.now());
            trade.setOpenPrice(price);

            traderState.setActiveTrade(trade);

            openTradeHandler.handle(trade);
        }
    }

    @Override
    public void adviceToSell(double price) {
        if (traderState.hasActiveTrade()) {
            var quotation = quotationProvider.getQuotation();
            var balance = balanceProvider.getBalance(quotation.getBaseAsset());

            var order = orderProvider.getSellOrder(quotation, balance, price);
            orderProcessor.processOrder(order);

            traderState.setActiveTrade(null);

            var trade = traderState.getActiveTrade();
            trade.setCloseTime(ZonedDateTime.now());
            trade.setClosePrice(price);

            closeTradeHandler.handle(trade);
        }
    }
}
