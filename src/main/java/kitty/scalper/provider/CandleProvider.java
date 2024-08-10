package kitty.scalper.provider;

import kitty.scalper.core.Candle;

public interface CandleProvider extends AutoCloseable {
    Candle getCandle();
}
