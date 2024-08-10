package kitty.scalper.trader.binance.response.listener;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
public class AccountUpdate extends Update {
    private final long lastTimeUpdate;
    private final List<Balance> balances;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public AccountUpdate(@JsonProperty("E") long eventTime,
                         @JsonProperty("u") long lastTimeUpdate,
                         @JsonProperty("B") List<Balance> balances) {
        super("outboundAccountPosition", eventTime);
        this.lastTimeUpdate = lastTimeUpdate;
        this.balances = balances;
    }

    @Getter
    @RequiredArgsConstructor
    public static class Balance {
        @JsonProperty("a")
        private final String asset;
        @JsonProperty("f")
        private final double free;
        @JsonProperty("l")
        private final double locked;
    }
}
