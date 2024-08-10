package kitty.scalper.provider.binance.response.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MaxNumberOrdersFilter extends Filter {
    private final int maxNumberOrders;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MaxNumberOrdersFilter(@JsonProperty("maxNumOrders") int maxNumberOrders) {
        super(FilterType.MAX_NUM_ORDERS);
        this.maxNumberOrders = maxNumberOrders;
    }
}
