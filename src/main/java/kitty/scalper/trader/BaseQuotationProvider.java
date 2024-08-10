package kitty.scalper.trader;

import kitty.scalper.config.ScalperConfiguration;
import kitty.scalper.trader.entity.Quotation;
import org.springframework.stereotype.Component;

@Component
public class BaseQuotationProvider implements QuotationProvider {
    private final ScalperConfiguration configuration;

    public BaseQuotationProvider(ScalperConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Quotation getQuotation() {
        // check availabilty of quotation!!!!!!!!!!!!!
        return configuration.getScalpingQuotation();
    }
}
