package kitty.scalper.provider.binance.response.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MinimalNotionalFilter extends Filter {
    private final double minNotional;
    private final boolean applyToMarket;
    private final int averagePriceMinimums;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MinimalNotionalFilter(@JsonProperty("minNotional") double minNotional,
                                 @JsonProperty("applyToMarket") boolean applyToMarket,
                                 @JsonProperty("avgPriceMins") int averagePriceMinimums) {
        super(FilterType.MIN_NOTIONAL);
        this.minNotional = minNotional;
        this.applyToMarket = applyToMarket;
        this.averagePriceMinimums = averagePriceMinimums;
    }
}
