package pl.annaczeczek.millionaires.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.annaczeczek.millionaires.external.bitbay.BitBayPrivateApi;
import pl.annaczeczek.millionaires.external.bitbay.BitBayPublicApi;
import pl.annaczeczek.millionaires.external.bitmarket.BitMarketCurrency;
import pl.annaczeczek.millionaires.external.bitmarket.BitMarketPublicApi;

@Component
public class Scheduler {

    @Autowired
    private BitBayPrivateApi bitBayPrivateApi;

    @Autowired
    private BitBayPublicApi bitBayPublicApi;

    @Autowired
    private BitMarketPublicApi bitMarketPublicApi;

    @Scheduled(fixedRate = 5000L)
    public void get() {
        for (BitMarketCurrency c : BitMarketCurrency.values()) {
            System.out.println(bitMarketPublicApi.getOrderBook(c));
            System.out.println(bitMarketPublicApi.getTrades(c));
        }
    }
}
