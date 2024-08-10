package kitty.scalper.strategy;

import kitty.scalper.adapter.CandleBar;
import kitty.scalper.core.Candle;
import kitty.scalper.core.Decision;
import kitty.scalper.core.Strategy;
import kitty.scalper.provider.HistoryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ta4j.core.Bar;
import org.ta4j.core.BaseBarSeries;
import org.ta4j.core.BaseStrategy;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;
import org.ta4j.core.rules.IsFallingRule;
import org.ta4j.core.rules.IsRisingRule;

import java.util.Optional;

@Component
public class RiseFallStrategy implements Strategy {
    private static final int BAR_SERIES_WINDOW = 500;
    private final BaseBarSeries barSeries;
    private final BaseStrategy strategy;

    @Autowired
    public RiseFallStrategy(HistoryProvider historyProvider) {
        var history = historyProvider.getCandleHistory(BAR_SERIES_WINDOW);
        var bars = history.stream()
                .map(candle -> (Bar) new CandleBar(candle))
                .limit(history.size() - 1)
                .toList();

        this.barSeries = new BaseBarSeries(bars);
        this.barSeries.setMaximumBarCount(BAR_SERIES_WINDOW);

        var closePrice = new ClosePriceIndicator(barSeries);
        var smoothed = new SMAIndicator(closePrice, 2);

        var entryRule = new IsRisingRule(smoothed, 2);
        var exitRule = new IsFallingRule(smoothed, 2);

        this.strategy = new BaseStrategy(entryRule, exitRule);
    }

    @Override
    public Optional<Decision> getDecision(Candle candle) {
        var bar = new CandleBar(candle);
        barSeries.addBar(bar);

        var index = barSeries.getEndIndex();
        if (strategy.shouldEnter(index)) {
            return Optional.of(Decision.BUY);
        } else if (strategy.shouldExit(index)) {
            return Optional.of(Decision.SELL);
        } else {
            return Optional.empty();
        }
    }
}
