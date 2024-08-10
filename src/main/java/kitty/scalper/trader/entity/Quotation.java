package kitty.scalper.trader.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quotation {
    private String baseAsset;
    private String quoteAsset;
    private double minQuantity;
    private double maxQuantity;
}
