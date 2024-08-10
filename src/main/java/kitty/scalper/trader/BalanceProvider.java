package kitty.scalper.trader;

import kitty.scalper.trader.entity.Balance;

public interface BalanceProvider {
    Balance getBalance(String currency);
}
