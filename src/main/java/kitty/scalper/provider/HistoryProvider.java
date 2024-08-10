package kitty.scalper.provider;

import kitty.scalper.core.Candle;

import java.util.List;

public interface HistoryProvider {
    List<Candle> getCandleHistory(long size);
}
