package kitty.scalper.trader.binance.response.listener;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OrderUpdate extends Update {
    private final String symbol;
    private final String clientOrderID;
    private final String side;
    private final String orderType;
    private final String timeInForce;
    private final double orderQuantity;
    private final double orderPrice;
    private final double stopPrice;
    private final double icebergQuantity;
    private final long orderListID;
    private final String originalClientOrderID;
    private final ExecutionType currentExecutionType;
    private final String currentOrderStatus;
    private final String orderRejectReason;
    private final long orderID;
    private final double lastExecutedQuantity;
    private final double cumulativeFilledQuantity;
    private final double lastExecutedPrice;
    private final double commissionAmount;
    private final String commissionAsset;
    private final long transactionTime;
    private final long tradeID;
    private final long preventedMatchID;
    private final boolean isOrderOnBook;
    private final boolean isTradeMakerSide;
    private final long orderCreationTime;
    private final double cumulativeQuoteAssetTransactedQuantity;
    private final double lastQuoteTransactedQuantity;
    private final double quoteOrderQuantity;
    private final long workingTime;
    private final String selfTradePreventionMode;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public OrderUpdate(@JsonProperty("E") long eventTime,
                       @JsonProperty("s") String symbol,
                       @JsonProperty("c") String clientOrderID,
                       @JsonProperty("S") String side,
                       @JsonProperty("o") String orderType,
                       @JsonProperty("f") String timeInForce,
                       @JsonProperty("q") double orderQuantity,
                       @JsonProperty("p") double orderPrice,
                       @JsonProperty("P") double stopPrice,
                       @JsonProperty("F") double icebergQuantity,
                       @JsonProperty("g") long orderListID,
                       @JsonProperty("C") String originalClientOrderID,
                       @JsonProperty("x") ExecutionType currentExecutionType,
                       @JsonProperty("X") String currentOrderStatus,
                       @JsonProperty("r") String orderRejectReason,
                       @JsonProperty("i") long orderID,
                       @JsonProperty("l") double lastExecutedQuantity,
                       @JsonProperty("z") double cumulativeFilledQuantity,
                       @JsonProperty("L") double lastExecutedPrice,
                       @JsonProperty("n") double commissionAmount,
                       @JsonProperty("N") String commissionAsset,
                       @JsonProperty("T") long transactionTime,
                       @JsonProperty("t") long tradeID,
                       @JsonProperty("v") long preventedMatchID,
                       @JsonProperty("w") boolean isOrderOnBook,
                       @JsonProperty("m") boolean isTradeMakerSide,
                       @JsonProperty("O") long orderCreationTime,
                       @JsonProperty("Z") double cumulativeQuoteAssetTransactedQuantity,
                       @JsonProperty("Y") double lastQuoteTransactedQuantity,
                       @JsonProperty("Q") double quoteOrderQuantity,
                       @JsonProperty("W") long workingTime,
                       @JsonProperty("V") String selfTradePreventionMode) {
        super("executionReport", eventTime);
        this.symbol = symbol;
        this.clientOrderID = clientOrderID;
        this.side = side;
        this.orderType = orderType;
        this.timeInForce = timeInForce;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
        this.stopPrice = stopPrice;
        this.icebergQuantity = icebergQuantity;
        this.orderListID = orderListID;
        this.originalClientOrderID = originalClientOrderID;
        this.currentExecutionType = currentExecutionType;
        this.currentOrderStatus = currentOrderStatus;
        this.orderRejectReason = orderRejectReason;
        this.orderID = orderID;
        this.lastExecutedQuantity = lastExecutedQuantity;
        this.cumulativeFilledQuantity = cumulativeFilledQuantity;
        this.lastExecutedPrice = lastExecutedPrice;
        this.commissionAmount = commissionAmount;
        this.commissionAsset = commissionAsset;
        this.transactionTime = transactionTime;
        this.tradeID = tradeID;
        this.preventedMatchID = preventedMatchID;
        this.isOrderOnBook = isOrderOnBook;
        this.isTradeMakerSide = isTradeMakerSide;
        this.orderCreationTime = orderCreationTime;
        this.cumulativeQuoteAssetTransactedQuantity = cumulativeQuoteAssetTransactedQuantity;
        this.lastQuoteTransactedQuantity = lastQuoteTransactedQuantity;
        this.quoteOrderQuantity = quoteOrderQuantity;
        this.workingTime = workingTime;
        this.selfTradePreventionMode = selfTradePreventionMode;
    }

    @Getter
    public enum ExecutionType {
        NEW("The order has been accepted into the engine."),
        CANCELED("The order has been canceled by the user."),
        REPLACED("(currently unused)"),
        REJECTED("The order has been rejected and was not processed."),
        TRADE("Part of the order or all of the order's quantity has filled."),
        EXPIRED("The order was canceled according to the order type's rules."),
        TRADE_PREVENTION("The order has expired due to STP.");

        private final String description;

        ExecutionType(String description) {
            this.description = description;
        }
    }
}
