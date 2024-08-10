package kitty.scalper.trader;

import kitty.scalper.trader.entity.Balance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trade {
    private ZonedDateTime openTime;
    private ZonedDateTime closeTime;
    private Balance openBalance;
    private Balance closeBalance;
}
