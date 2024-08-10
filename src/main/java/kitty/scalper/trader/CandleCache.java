package kitty.scalper.trader;

import kitty.scalper.core.Candle;

public interface CandleCache {
    void update(Candle candle);
    Candle retrieve();
}
