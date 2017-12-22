package pl.annaczeczek.millionaires.external.bitmarket;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.annaczeczek.millionaires.external.bitmarket.dto.OrderBookDto;
import pl.annaczeczek.millionaires.external.bitmarket.dto.TradeDto;

import java.util.Arrays;
import java.util.List;

@Component
public class BitMarketPublicApi {


    private RestTemplate restTemplate;
    private static final String BASE_URL = "https://www.bitmarket.pl/json/";

    public BitMarketPublicApi() {
        restTemplate = new RestTemplate();
    }

    public List<TradeDto> getTrades(BitMarketCurrency bitBayCurrency) {
        TradeDto[] trades = restTemplate.getForEntity(BASE_URL + bitBayCurrency + "/trades.json", TradeDto[].class).getBody();
        for (TradeDto trade : trades) {
            trade.setCurrency(bitBayCurrency);
        }
        return Arrays.asList(trades);
    }

    public OrderBookDto getOrderBook(BitMarketCurrency bitBayCurrency) {
        OrderBookDto orderBookDto = restTemplate.getForEntity(BASE_URL + bitBayCurrency + "/orderbook.json", OrderBookDto.class).getBody();
        orderBookDto.setCurrency(bitBayCurrency);
        return orderBookDto;
    }

}
