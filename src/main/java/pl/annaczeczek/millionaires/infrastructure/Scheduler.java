package pl.annaczeczek.millionaires.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.annaczeczek.millionaires.external.bitbay.BitBayCurrency;
import pl.annaczeczek.millionaires.external.bitbay.BitBayPrivateApi;
import pl.annaczeczek.millionaires.external.bitbay.BitBayPublicApi;
import pl.annaczeczek.millionaires.external.bitbay.dto.BaseCurrencyInfo;
import pl.annaczeczek.millionaires.external.bitmarket.BitMarketCurrency;
import pl.annaczeczek.millionaires.external.bitmarket.BitMarketPublicApi;
import pl.annaczeczek.millionaires.external.bitmarket.dto.CurrencyInfoDto;
import pl.annaczeczek.millionaires.external.cryptowatch.CryptoWatchPublicApi;

@Component
public class Scheduler {

    @Autowired
    private BitBayPrivateApi bitBayPrivateApi;

    @Autowired
    private BitBayPublicApi bitBayPublicApi;

    @Autowired
    private BitMarketPublicApi bitMarketPublicApi;

    @Autowired
    private CryptoWatchPublicApi cryptoWatchPublicApi;

    @Scheduled(fixedRate = 5000L)
    public void get() {
        BaseCurrencyInfo bb = bitBayPublicApi.getCurrencyInfoForCurrency(BitBayCurrency.BTCPLN);
        CurrencyInfoDto bm = bitMarketPublicApi.getCurrencyInfoDto(BitMarketCurrency.BTCPLN);
        System.out.println("BB - BM difference: " + (bb.last - bm.last));
    }
}
