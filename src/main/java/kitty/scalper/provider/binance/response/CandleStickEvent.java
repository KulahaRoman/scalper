package kitty.scalper.provider.binance.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CandleStickEvent {
    @JsonProperty("e")
    private final String eventType;
    @JsonProperty("E")
    private final long eventTime;
    @JsonProperty("s")
    private final String symbol;
    @JsonProperty("k")
    private final CandleStick candleStick;
}
