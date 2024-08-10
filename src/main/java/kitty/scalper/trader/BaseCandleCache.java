package kitty.scalper.trader;

import kitty.scalper.core.Candle;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class BaseCandleCache implements CandleCache {
    private Candle candle;

    @Override
    public void update(Candle candle) {
        this.candle = candle;
    }

    @Override
    public Candle retrieve() {
        return candle;
    }
}
