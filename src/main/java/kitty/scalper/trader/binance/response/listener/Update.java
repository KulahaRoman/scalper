package kitty.scalper.trader.binance.response.listener;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "eventType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AccountUpdate.class, name = "outboundAccountPosition"),
        @JsonSubTypes.Type(value = BalanceUpdate.class, name = "balanceUpdate"),
        @JsonSubTypes.Type(value = OrderUpdate.class, name = "executionReport")
})
public abstract class Update {
    @JsonProperty("e")
    private final String eventType;
    @JsonProperty("E")
    private final long eventTime;
}
