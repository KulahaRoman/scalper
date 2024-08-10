package kitty.scalper.provider.binance.response.exchange.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ExchangeMaxNumberIcebergOrdersFilter extends Filter {
    private final int maxNumberIcebergOrders;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ExchangeMaxNumberIcebergOrdersFilter(@JsonProperty("maxNumIcebergOrders") int maxNumberIcebergOrders) {
        super(FilterType.EXCHANGE_MAX_NUM_ICEBERG_ORDERS);
        this.maxNumberIcebergOrders = maxNumberIcebergOrders;
    }
}
