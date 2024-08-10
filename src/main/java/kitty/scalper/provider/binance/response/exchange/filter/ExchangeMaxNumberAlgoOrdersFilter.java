package kitty.scalper.provider.binance.response.exchange.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ExchangeMaxNumberAlgoOrdersFilter extends Filter {
    private final int maxNumberAlgoOrders;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ExchangeMaxNumberAlgoOrdersFilter(@JsonProperty("maxNumAlgoOrders") int maxNumberAlgoOrders) {
        super(FilterType.EXCHANGE_MAX_NUM_ALGO_ORDERS);
        this.maxNumberAlgoOrders = maxNumberAlgoOrders;
    }
}
