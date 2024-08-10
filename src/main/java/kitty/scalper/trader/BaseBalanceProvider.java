package kitty.scalper.trader;

import kitty.scalper.provider.AccountProvider;
import kitty.scalper.provider.binance.response.account.BinanceAccount;
import kitty.scalper.trader.entity.Balance;
import org.springframework.stereotype.Component;

@Component
public class BaseBalanceProvider implements BalanceProvider {
    private final AccountProvider<BinanceAccount> accountProvider;

    public BaseBalanceProvider(AccountProvider<BinanceAccount> accountProvider) {
        this.accountProvider = accountProvider;
    }

    @Override
    public Balance getBalance(String currency) {
        var account = accountProvider.getAccount();

        var balance = account.getBalances()
                .stream()
                .filter(b -> b.getAsset().equals(currency.toUpperCase()))
                .findFirst().orElseThrow(() ->
                        new RuntimeException("Failed to find balance of currency "
                                + currency.toUpperCase()));

        return new Balance(balance.getAsset(), balance.getFree());
    }
}
