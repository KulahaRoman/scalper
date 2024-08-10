package kitty.scalper.provider.binance.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RateLimit {
    @JsonProperty("rateLimitType")
    private final String rateLimitType;
    @JsonProperty("interval")
    private final String interval;
    @JsonProperty("intervalNum")
    private final int intervalNumber;
    @JsonProperty("limit")
    private final int limit;
}
