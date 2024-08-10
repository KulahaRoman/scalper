package kitty.scalper;

import kitty.scalper.core.CandleSource;
import kitty.scalper.core.Scalper;
import kitty.scalper.core.Strategy;
import kitty.scalper.core.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class BaseScalper implements Scalper {
    private final CandleSource candleSource;
    private final Strategy strategy;
    private final Trader trader;

    private final AtomicBoolean running = new AtomicBoolean(false);

    @Autowired
    public BaseScalper(CandleSource candleSource, Strategy strategy, Trader trader) {
        this.candleSource = candleSource;
        this.strategy = strategy;
        this.trader = trader;
    }

    @Override
    public void run() throws Exception {
        running.set(true);

        while (running.get()) {
            var candle = candleSource.acquire();
            strategy.getDecision(candle).ifPresent(decision -> {
                switch (decision) {
                    case BUY -> trader.adviceToBuy();
                    case SELL -> trader.adviceToSell();
                }
            });
        }
    }

    @Override
    public void stop() throws Exception {
        running.set(false);
    }
}
