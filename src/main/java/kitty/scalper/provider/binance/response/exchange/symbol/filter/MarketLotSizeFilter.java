package kitty.scalper.provider.binance.response.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MarketLotSizeFilter extends Filter {
    private final double minQuantity;
    private final double maxQuantity;
    private final double stepSize;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MarketLotSizeFilter(@JsonProperty("minQty") double minQuantity,
                               @JsonProperty("maxQty") double maxQuantity,
                               @JsonProperty("stepSize") double stepSize) {
        super(FilterType.MARKET_LOT_SIZE);
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
        this.stepSize = stepSize;
    }
}
