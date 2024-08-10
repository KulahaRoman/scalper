package kitty.scalper.core;

public interface CandleSource {
    Candle acquire() throws Exception;
}
