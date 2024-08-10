package kitty.scalper.provider;

import kitty.scalper.core.Candle;

public interface RealtimeProvider extends AutoCloseable {
    Candle getCandle();
}
