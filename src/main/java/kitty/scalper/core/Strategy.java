package kitty.scalper.core;

import java.util.Optional;

public interface Strategy {
    Optional<Decision> getDecision(Candle candle);
}
