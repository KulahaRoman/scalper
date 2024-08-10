package kitty.scalper.trader;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class TraderState {
    @Getter(onMethod_ = {@Synchronized})
    @Setter(onMethod_ = {@Synchronized})
    private Trade activeTrade;

    @Synchronized
    public boolean hasActiveTrade() {
        return activeTrade != null;
    }
}
