package pl.annaczeczek.millionaires.external.fixer;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.annaczeczek.millionaires.external.fixer.dto.FixerResponse;

@Component
public class FixerPublicApi {

    private RestTemplate restTemplate;
    private static final String URL = "http://api.fixer.io/latest?base=USD";

    public FixerPublicApi() {
        restTemplate = new RestTemplate();
    }

    private FixerResponse getRates() {
        return restTemplate.getForEntity(URL, FixerResponse.class).getBody();
    }

    public double getUsdToPlnRate() {
        FixerResponse rates = getRates();
        return rates.getRates().getPLN();
    }


}
