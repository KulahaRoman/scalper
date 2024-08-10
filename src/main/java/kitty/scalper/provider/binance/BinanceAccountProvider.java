package kitty.scalper.provider.binance;

import com.binance.connector.client.SpotClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import kitty.scalper.provider.AccountProvider;
import kitty.scalper.provider.binance.response.account.BinanceAccount;
import kitty.scalper.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashMap;

@Component
public class BinanceAccountProvider implements AccountProvider<BinanceAccount> {
    private final SpotClient spotClient;

    @Autowired
    public BinanceAccountProvider(SpotClient spotClient) {
        this.spotClient = spotClient;
    }

    @Override
    public BinanceAccount getAccount() {
        var parameters = new HashMap<String, Object>();
        parameters.put("timestamp", Instant.now().toEpochMilli());

        var response = spotClient.createTrade().account(parameters);
        try {
            return JSON.readObject(response, BinanceAccount.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
