package kitty.scalper.provider.binance.response.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MaxNumberIcebergOrdersFilter extends Filter {
    private final int maxNumberIcebergOrders;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MaxNumberIcebergOrdersFilter(@JsonProperty("maxNumIcebergOrders") int maxNumberIcebergOrders) {
        super(FilterType.MAX_NUM_ICEBERG_ORDERS);
        this.maxNumberIcebergOrders = maxNumberIcebergOrders;
    }
}
