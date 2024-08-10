package kitty.scalper.config;

import com.binance.connector.client.SpotClient;
import com.binance.connector.client.WebSocketApiClient;
import com.binance.connector.client.WebSocketStreamClient;
import com.binance.connector.client.impl.SpotClientImpl;
import com.binance.connector.client.impl.WebSocketApiClientImpl;
import com.binance.connector.client.impl.WebSocketStreamClientImpl;
import com.binance.connector.client.impl.websocketapi.WebSocketApiUserDataStream;
import com.binance.connector.client.utils.signaturegenerator.HmacSignatureGenerator;
import com.binance.connector.client.utils.websocketapi.WebSocketApiRequestHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "kitty.scalper")
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:client.properties"),
        @PropertySource("classpath:scalper.properties")
})
public class Beans {
    @Bean
    public SpotClient spotClient(@Value("${kitty.binance.client.api_key}") String apiKey,
                                 @Value("${kitty.binance.client.secret_key}") String secretKey) {
        return new SpotClientImpl(apiKey, secretKey);
    }

    @Bean
    public WebSocketStreamClient webSocketStreamClient() {
        return new WebSocketStreamClientImpl();
    }

    @Bean
    public WebSocketApiClient webSocketApiClient(@Value("${kitty.binance.client.api_key}") String apiKey,
                                                 @Value("${kitty.binance.client.secret_key}") String secretKey) {
        var signatureGenerator = new HmacSignatureGenerator(secretKey);
        return new WebSocketApiClientImpl(apiKey, signatureGenerator);
    }
}
