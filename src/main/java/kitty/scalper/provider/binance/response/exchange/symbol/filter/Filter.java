package kitty.scalper.provider.binance.response.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "filterType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = IcebergPartsFilter.class, name = "ICEBERG_PARTS"),
        @JsonSubTypes.Type(value = LotSizeFilter.class, name = "LOT_SIZE"),
        @JsonSubTypes.Type(value = MarketLotSizeFilter.class, name = "MARKET_LOT_SIZE"),
        @JsonSubTypes.Type(value = MaxNumberAlgoOrdersFilter.class, name = "MAX_NUM_ALGO_ORDERS"),
        @JsonSubTypes.Type(value = MaxNumberIcebergOrdersFilter.class, name = "MAX_NUM_ICEBERG_ORDERS"),
        @JsonSubTypes.Type(value = MaxNumberOrdersFilter.class, name = "MAX_NUM_ORDERS"),
        @JsonSubTypes.Type(value = MaxPositionFilter.class, name = "MAX_POSITION"),
        @JsonSubTypes.Type(value = MinimalNotionalFilter.class, name = "MIN_NOTIONAL"),
        @JsonSubTypes.Type(value = NotionalFilter.class, name = "NOTIONAL"),
        @JsonSubTypes.Type(value = PercentPriceBySideFilter.class, name = "PERCENT_PRICE_BY_SIDE"),
        @JsonSubTypes.Type(value = PercentPriceFilter.class, name = "PERCENT_PRICE"),
        @JsonSubTypes.Type(value = PriceFilter.class, name = "PRICE_FILTER"),
        @JsonSubTypes.Type(value = TrailingDeltaFilter.class, name = "TRAILING_DELTA")
})
public abstract class Filter {
    @JsonProperty("filterType")
    private final FilterType filterType;
}
