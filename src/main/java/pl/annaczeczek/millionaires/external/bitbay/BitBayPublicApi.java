package pl.annaczeczek.millionaires.external.bitbay;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.annaczeczek.millionaires.external.bitbay.dto.AdvancedCurrencyInfoDto;
import pl.annaczeczek.millionaires.external.bitbay.dto.BaseCurrencyInfo;

@Component
public class BitBayPublicApi {

    private RestTemplate restTemplate;
    private static final String BASE_URL = "https://bitbay.net/API/Public/";

    public BitBayPublicApi() {
        restTemplate = new RestTemplate();
    }

    public BaseCurrencyInfo getCurrencyInfoForCurrency(BitBayCurrency bitBayCurrency) {
        BaseCurrencyInfo baseCurrencyInfo = restTemplate.getForEntity(BASE_URL + bitBayCurrency + "/all.json", BaseCurrencyInfo.class).getBody();
        baseCurrencyInfo.currency = bitBayCurrency;
        return baseCurrencyInfo;
    }

    public AdvancedCurrencyInfoDto getAdvancedCurrencyInfoForCurrency(BitBayCurrency bitBayCurrency) {
        AdvancedCurrencyInfoDto advancedCurrencyInfoDto = restTemplate.getForEntity(BASE_URL + bitBayCurrency + "/all.json", AdvancedCurrencyInfoDto.class).getBody();
        advancedCurrencyInfoDto.currency = bitBayCurrency;
        return advancedCurrencyInfoDto;
    }

}
