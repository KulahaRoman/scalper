package kitty.scalper.provider.binance.response.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MaxNumberAlgoOrdersFilter extends Filter {
    private final double maxNumberAlgoOrders;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MaxNumberAlgoOrdersFilter(@JsonProperty("maxNumAlgoOrders") double maxNumberAlgoOrders) {
        super(FilterType.MAX_NUM_ALGO_ORDERS);
        this.maxNumberAlgoOrders = maxNumberAlgoOrders;
    }
}
