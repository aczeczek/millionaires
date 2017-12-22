package pl.annaczeczek.millionaires.external.cryptowatch;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.annaczeczek.millionaires.external.cryptowatch.dto.*;

@Component
public class CryptoWatchPublicApi {

    private RestTemplate restTemplate;
    private static final String BASE_URL = "https://api.cryptowat.ch/";

    public CryptoWatchPublicApi() {
        restTemplate = new RestTemplate();
    }

    public Exchanges getExchanges() {
        return restTemplate.getForEntity(BASE_URL + "exchanges", Exchanges.class).getBody();
    }

    public Markets getMargets(String exchangeName) {
        return restTemplate.getForEntity(BASE_URL + "markets", Markets.class).getBody();
    }

    public OrderBook getMarketOrderBook(String exchangeName, String currencyPair) {
        return restTemplate.getForEntity(BASE_URL + "markets/" + exchangeName + "/" + currencyPair + "/orderbook", OrderBook.class).getBody();
    }

    public Trades getMarketTrades(String exchangeName, String currencyPair) {
        return restTemplate.getForEntity(BASE_URL + "markets/" + exchangeName + "/" + currencyPair + "/trades", Trades.class).getBody();
    }

    public Summary getMarketSummary(String exchangeName, String currencyPair) {
        return restTemplate.getForEntity(BASE_URL + "markets/" + exchangeName + "/" + currencyPair + "/summary", Summary.class).getBody();
    }
}
