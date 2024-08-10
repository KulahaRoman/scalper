package kitty.scalper.provider.binance.response.exchange.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ExchangeMaxNumberOrdersFilter extends Filter {
    private final int maxNumberOrders;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ExchangeMaxNumberOrdersFilter(@JsonProperty("maxNumOrders") int maxNumberOrders) {
        super(FilterType.EXCHANGE_MAX_NUM_ORDERS);
        this.maxNumberOrders = maxNumberOrders;
    }
}
