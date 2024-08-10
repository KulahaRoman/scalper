package kitty.scalper.provider.binance.response.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class PriceFilter extends Filter {
    private final double minPrice;
    private final double maxPrice;
    private final double tickSize;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PriceFilter(@JsonProperty("minPrice") double minPrice,
                       @JsonProperty("maxPrice") double maxPrice,
                       @JsonProperty("tickSize") double tickSize) {
        super(FilterType.PRICE_FILTER);
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.tickSize = tickSize;
    }
}
