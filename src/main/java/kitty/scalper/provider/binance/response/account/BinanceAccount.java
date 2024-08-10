package kitty.scalper.provider.binance.response.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class BinanceAccount {
    @JsonProperty("makerCommission")
    private final int makerCommission;
    @JsonProperty("takerCommission")
    private final int takerCommission;
    @JsonProperty("buyerCommission")
    private final int buyerCommission;
    @JsonProperty("sellerCommission")
    private final int sellerCommission;
    @JsonProperty("commissionRates")
    private final CommissionRates commissionRates;
    @JsonProperty("canTrade")
    private final boolean canTrade;
    @JsonProperty("canWithdraw")
    private final boolean canWithdraw;
    @JsonProperty("canDeposit")
    private final boolean canDeposit;
    @JsonProperty("brokered")
    private final boolean brokered;
    @JsonProperty("requireSelfTradePrevention")
    private final boolean requireSelfTradePrevention;
    @JsonProperty("preventSor")
    private final boolean preventSor;
    @JsonProperty("updateTime")
    private final long updateTime;
    @JsonProperty("accountType")
    private final String accountType;
    @JsonProperty("balances")
    private final List<Balance> balances;
    @JsonProperty("permissions")
    private final List<String> permissions;
    @JsonProperty("uid")
    private final long userID;

    @Getter
    @RequiredArgsConstructor
    public class CommissionRates {
        @JsonProperty("maker")
        private final double maker;
        @JsonProperty("taker")
        private final double taker;
        @JsonProperty("buyer")
        private final double buyer;
        @JsonProperty("seller")
        private final double seller;
    }

    @Getter
    @RequiredArgsConstructor
    public class Balance {
        @JsonProperty("asset")
        private final String asset;
        @JsonProperty("free")
        private final double free;
        @JsonProperty("locked")
        private final double locked;
    }
}
