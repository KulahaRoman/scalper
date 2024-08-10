package kitty.scalper.provider.binance.response.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class IcebergPartsFilter extends Filter {
    private final int limit;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public IcebergPartsFilter(@JsonProperty("limit") int limit) {
        super(FilterType.ICEBERG_PARTS);
        this.limit = limit;
    }
}
