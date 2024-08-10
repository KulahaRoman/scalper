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
public class Exchange {
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
