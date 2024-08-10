package kitty.scalper;

import kitty.scalper.core.Scalper;
import kitty.scalper.core.Strategy;
import kitty.scalper.core.Trader;
import kitty.scalper.provider.CandleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class BaseScalper implements Scalper {
    private final CandleProvider candleProvider;
    private final Strategy strategy;
    private final Trader trader;

    private final AtomicBoolean running = new AtomicBoolean(false);

    @Autowired
    public BaseScalper(CandleProvider candleProvider, Strategy strategy, Trader trader) {
        this.candleProvider = candleProvider;
        this.strategy = strategy;
        this.trader = trader;
    }

    @Override
    public void run() throws Exception {
        running.set(true);

        while (running.get()) {
            var candle = candleProvider.getCandle();
            strategy.getDecision(candle).ifPresent(decision -> {
                switch (decision) {
                    case BUY -> trader.adviceToBuy(candle.getClosePrice());
                    case SELL -> trader.adviceToSell(candle.getClosePrice());
                }
            });
        }
    }

    @Override
    public void stop() throws Exception {
        running.set(false);
    }
}
