package kitty.scalper.provider.binance.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import kitty.scalper.provider.binance.response.exchange.filter.Filter;
import kitty.scalper.provider.binance.response.exchange.symbol.Symbol;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class BinanceExchange {
    @JsonProperty("timezone")
    private final String timezone;
    @JsonProperty("serverTime")
    private final long serverTime;
    @JsonProperty("rateLimits")
    private final List<RateLimit> rateLimits;
    @JsonProperty("exchangeFilters")
    private final List<Filter> exchangeFilters;
    @JsonProperty("symbols")
    private final List<Symbol> symbols;
    @JsonProperty("sors")
    private final List<SOR> sors;

    @Getter
    @RequiredArgsConstructor
    public static class RateLimit {
        @JsonProperty("rateLimitType")
        private final String rateLimitType;
        @JsonProperty("interval")
        private final String interval;
        @JsonProperty("intervalNum")
        private final int intervalNumber;
        @JsonProperty("limit")
        private final int limit;
    }

    @Getter
    @RequiredArgsConstructor
    public static class SOR {
        @JsonProperty("baseAsset")
        private final String baseAsset;
        @JsonProperty("symbols")
        private final List<String> symbols;

        public List<String> getSymbols() {
            return Collections.unmodifiableList(symbols);
        }
    }

    public List<RateLimit> getRateLimits() {
        return Collections.unmodifiableList(rateLimits);
    }

    public List<Filter> getExchangeFilters() {
        return Collections.unmodifiableList(exchangeFilters);
    }

    public List<Symbol> getSymbols() {
        return Collections.unmodifiableList(symbols);
    }

    public List<SOR> getSors() {
        return Collections.unmodifiableList(sors);
    }
}
