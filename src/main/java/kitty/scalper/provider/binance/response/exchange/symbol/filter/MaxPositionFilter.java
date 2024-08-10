package kitty.scalper.provider.binance.response.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MaxPositionFilter extends Filter {
    private final double maxPosition;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MaxPositionFilter(@JsonProperty("maxPosition") double maxPosition) {
        super(FilterType.MAX_POSITION);
        this.maxPosition = maxPosition;
    }
}
