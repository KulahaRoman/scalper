package kitty.scalper.provider.binance.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class SOR {
    @JsonProperty("baseAsset")
    private final String baseAsset;
    @JsonProperty("symbols")
    private final List<String> symbols;

    public List<String> getSymbols() {
        return Collections.unmodifiableList(symbols);
    }
}
