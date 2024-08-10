package kitty.scalper.trader.binance;

import com.binance.connector.client.SpotClient;
import com.binance.connector.client.WebSocketStreamClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import kitty.scalper.trader.binance.response.listener.Update;
import kitty.scalper.util.JSON;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinanceListener implements AutoCloseable {
    private final WebSocketStreamClient webSocketStreamClient;
    private final SpotClient spotClient;
    private final BinanceStorage binanceStorage;

    @Autowired
    public BinanceListener(WebSocketStreamClient webSocketStreamClient,
                           SpotClient spotClient, BinanceStorage binanceStorage) {
        this.webSocketStreamClient = webSocketStreamClient;
        this.spotClient = spotClient;
        this.binanceStorage = binanceStorage;

        JSONObject obj = new JSONObject(spotClient.createUserData().createListenKey());
        String listenKey = obj.getString("listenKey");

        webSocketStreamClient.listenUserStream(listenKey, ((event) -> {
            try {
                var update = JSON.readObject(event, Update.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }));
    }

    @Override
    public void close() throws Exception {
        webSocketStreamClient.closeAllConnections();
    }
}
