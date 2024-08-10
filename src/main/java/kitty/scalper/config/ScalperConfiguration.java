package kitty.scalper.config;

import kitty.scalper.trader.entity.Quotation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ScalperConfiguration {
    private Quotation scalpingQuotation;
    private String scalpingPeriod;

    public ScalperConfiguration(@Value("${kitty.scalper.binance.asset.base}") String baseAsset,
                                @Value("${kitty.scalper.binance.asset.quote}") String quoteAsset,
                                @Value("${kitty.scalper.binance.period}") String period) {
        this.scalpingQuotation = new Quotation(baseAsset, quoteAsset, 0.0, 0.0);
        this.scalpingPeriod = period;
    }
}
