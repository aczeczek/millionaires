package pl.annaczeczek.millionaires.external.bitbay;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.annaczeczek.millionaires.external.bitbay.dto.CurrencyInfoDto;

@Component
public class BitBayPublicApi {

    private RestTemplate restTemplate;
    private static final String BASE_URL = "https://bitbay.net/API/Public/";

    public BitBayPublicApi() {
        restTemplate = new RestTemplate();
    }

    public CurrencyInfoDto getMarketInfoForCurrency(BitBayCurrency bitBayCurrency) {
        CurrencyInfoDto currencyInfoDto = restTemplate.getForEntity(BASE_URL + bitBayCurrency + "/all.json", CurrencyInfoDto.class).getBody();
        currencyInfoDto.setCurrency(bitBayCurrency);
        return currencyInfoDto;
    }

}
