package kitty.scalper.config;

import kitty.scalper.trader.entity.Quotation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@Component
public class ScalperConfiguration {
    private Quotation scalpingQuotation;
    private String scalpingPeriod;
}
