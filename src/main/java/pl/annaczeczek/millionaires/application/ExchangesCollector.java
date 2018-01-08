package pl.annaczeczek.millionaires.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.annaczeczek.millionaires.domain.exchange.ExchangeRate;
import pl.annaczeczek.millionaires.domain.exchange.ExchangeRateService;
import pl.annaczeczek.millionaires.external.bitbay.BitBayCurrency;
import pl.annaczeczek.millionaires.external.bitbay.BitBayPrivateApi;
import pl.annaczeczek.millionaires.external.bitbay.BitBayPublicApi;
import pl.annaczeczek.millionaires.external.bitbay.dto.BaseCurrencyInfo;
import pl.annaczeczek.millionaires.external.bitmarket.BitMarketCurrency;
import pl.annaczeczek.millionaires.external.bitmarket.BitMarketPublicApi;
import pl.annaczeczek.millionaires.external.bitmarket.dto.CurrencyInfoDto;
import pl.annaczeczek.millionaires.external.cryptowatch.CryptoWatchPublicApi;
import pl.annaczeczek.millionaires.external.cryptowatch.dto.Summary;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExchangesCollector {

    @Autowired
    private BitBayPrivateApi bitBayPrivateApi;

    @Autowired
    private BitBayPublicApi bitBayPublicApi;

    @Autowired
    private BitMarketPublicApi bitMarketPublicApi;

    @Autowired
    private CryptoWatchPublicApi cryptoWatchPublicApi;

    @Autowired
    private UsdToPlnRateService usdToPlnRateService;

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Scheduled(cron = "0 0/5 * * * *") //every 5 minutes
    public void get() {
        List<ExchangeRate> exchangeRates = new ArrayList<>(20);
        exchangeRates.addAll(getForBitcoin());
        exchangeRates.addAll(getForBitcoinCash());
        exchangeRates.addAll(getForLitecoin());
        exchangeRates.forEach(exchangeRateService::save);
    }

    private List<ExchangeRate> getForBitcoin() {
        double usdPlnRate = usdToPlnRateService.getRate();
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        BaseCurrencyInfo bb = bitBayPublicApi.getCurrencyInfoForCurrency(BitBayCurrency.BTCPLN);
        exchangeRates.add(new ExchangeRate("BitBay", "BTC", "PLN", bb.last));
        exchangeRates.add(new ExchangeRate("BitBay", "BTC", "USD", bb.last / usdPlnRate));
        CurrencyInfoDto bm = bitMarketPublicApi.getCurrencyInfoDto(BitMarketCurrency.BTCPLN);
        exchangeRates.add(new ExchangeRate("BitMarket", "BTC", "PLN", bm.last));
        exchangeRates.add(new ExchangeRate("BitMarket", "BTC", "USD", bm.last / usdPlnRate));
        Summary gdax = cryptoWatchPublicApi.getMarketSummary("gdax", "btcusd");
        exchangeRates.add(new ExchangeRate("GDAX", "BTC", "PLN", gdax.result.price.last * usdPlnRate));
        exchangeRates.add(new ExchangeRate("GDAX", "BTC", "USD", gdax.result.price.last));
        Summary bitfinex = cryptoWatchPublicApi.getMarketSummary("bitfinex", "btcusd");
        exchangeRates.add(new ExchangeRate("BitFinex", "BTC", "PLN", bitfinex.result.price.last * usdPlnRate));
        exchangeRates.add(new ExchangeRate("BitFinex", "BTC", "USD", bitfinex.result.price.last));
        return exchangeRates;
    }

    private List<ExchangeRate> getForLitecoin() {
        double usdPlnRate = usdToPlnRateService.getRate();
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        BaseCurrencyInfo bb = bitBayPublicApi.getCurrencyInfoForCurrency(BitBayCurrency.LTCPLN);
        exchangeRates.add(new ExchangeRate("BitBay", "LTC", "PLN", bb.last));
        exchangeRates.add(new ExchangeRate("BitBay", "LTC", "USD", bb.last / usdPlnRate));
        CurrencyInfoDto bm = bitMarketPublicApi.getCurrencyInfoDto(BitMarketCurrency.LTCPLN);
        exchangeRates.add(new ExchangeRate("BitMarket", "LTC", "PLN", bm.last));
        exchangeRates.add(new ExchangeRate("BitMarket", "LTC", "USD", bm.last / usdPlnRate));
        Summary gdax = cryptoWatchPublicApi.getMarketSummary("gdax", "ltcusd");
        exchangeRates.add(new ExchangeRate("GDAX", "LTC", "PLN", gdax.result.price.last * usdPlnRate));
        exchangeRates.add(new ExchangeRate("GDAX", "LTC", "USD", gdax.result.price.last));
        Summary bitfinex = cryptoWatchPublicApi.getMarketSummary("bitfinex", "ltcusd");
        exchangeRates.add(new ExchangeRate("BitFinex", "LTC", "PLN", bitfinex.result.price.last * usdPlnRate));
        exchangeRates.add(new ExchangeRate("BitFinex", "LTC", "USD", bitfinex.result.price.last));
        return exchangeRates;
    }

    private List<ExchangeRate> getForBitcoinCash() {
        double usdPlnRate = usdToPlnRateService.getRate();
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        BaseCurrencyInfo bb = bitBayPublicApi.getCurrencyInfoForCurrency(BitBayCurrency.BCCPLN);
        exchangeRates.add(new ExchangeRate("BitBay", "BCC", "PLN", bb.last));
        exchangeRates.add(new ExchangeRate("BitBay", "BCC", "USD", bb.last / usdPlnRate));
        CurrencyInfoDto bm = bitMarketPublicApi.getCurrencyInfoDto(BitMarketCurrency.BCCPLN);
        exchangeRates.add(new ExchangeRate("BitMarket", "BCC", "PLN", bm.last));
        exchangeRates.add(new ExchangeRate("BitMarket", "BCC", "USD", bm.last / usdPlnRate));
        Summary gdax = cryptoWatchPublicApi.getMarketSummary("gdax", "bchusd");
        exchangeRates.add(new ExchangeRate("GDAX", "BCC", "PLN", gdax.result.price.last * usdPlnRate));
        exchangeRates.add(new ExchangeRate("GDAX", "BCC", "USD", gdax.result.price.last));
        Summary bitfinex = cryptoWatchPublicApi.getMarketSummary("bitfinex", "bchusd");
        exchangeRates.add(new ExchangeRate("BitFinex", "BCC", "PLN", bitfinex.result.price.last * usdPlnRate));
        exchangeRates.add(new ExchangeRate("BitFinex", "BCC", "USD", bitfinex.result.price.last));
        return exchangeRates;
    }
}
