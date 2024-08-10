package kitty.scalper.provider.binance.response.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class NotionalFilter extends Filter {
    private final double minNotional;
    private final boolean applyMinToMarket;
    private final double maxNotional;
    private final boolean applyMaxToMarket;
    private final int averagePriceMinimums;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public NotionalFilter(@JsonProperty("minNotional") double minNotional,
                          @JsonProperty("applyMinToMarket") boolean applyMinToMarket,
                          @JsonProperty("maxNotional") double maxNotional,
                          @JsonProperty("applyMaxToMarket") boolean applyMaxToMarket,
                          @JsonProperty("avgPriceMins") int averagePriceMinimums) {
        super(FilterType.NOTIONAL);
        this.minNotional = minNotional;
        this.applyMinToMarket = applyMinToMarket;
        this.maxNotional = maxNotional;
        this.applyMaxToMarket = applyMaxToMarket;
        this.averagePriceMinimums = averagePriceMinimums;
    }
}
