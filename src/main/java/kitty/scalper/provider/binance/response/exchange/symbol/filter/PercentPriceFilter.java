package kitty.scalper.provider.binance.response.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PercentPriceFilter extends Filter {
    private final double multiplierUp;
    private final double multiplierDown;
    private final int averagePriceMinimums;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PercentPriceFilter(@JsonProperty("multiplierUp") double multiplierUp,
                              @JsonProperty("multiplierDown") double multiplierDown,
                              @JsonProperty("avgPriceMins") int averagePriceMinimums) {
        super(FilterType.PERCENT_PRICE);
        this.multiplierUp = multiplierUp;
        this.multiplierDown = multiplierDown;
        this.averagePriceMinimums = averagePriceMinimums;
    }
}
