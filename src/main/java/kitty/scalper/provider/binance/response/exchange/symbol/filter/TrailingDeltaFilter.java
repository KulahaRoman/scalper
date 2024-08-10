package kitty.scalper.provider.binance.response.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TrailingDeltaFilter extends Filter {
    private final double minTrailingAboveDelta;
    private final double maxTrailingAboveDelta;
    private final double minTrailingBelowDelta;
    private final double maxTrailingBelowDelta;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public TrailingDeltaFilter(@JsonProperty("minTrailingAboveDelta") double minTrailingAboveDelta,
                               @JsonProperty("maxTrailingAboveDelta") double maxTrailingAboveDelta,
                               @JsonProperty("minTrailingBelowDelta") double minTrailingBelowDelta,
                               @JsonProperty("maxTrailingBelowDelta") double maxTrailingBelowDelta) {
        super(FilterType.TRAILING_DELTA);
        this.minTrailingAboveDelta = minTrailingAboveDelta;
        this.maxTrailingAboveDelta = maxTrailingAboveDelta;
        this.minTrailingBelowDelta = minTrailingBelowDelta;
        this.maxTrailingBelowDelta = maxTrailingBelowDelta;
    }
}
