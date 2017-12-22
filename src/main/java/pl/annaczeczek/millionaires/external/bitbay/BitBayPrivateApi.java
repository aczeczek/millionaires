package pl.annaczeczek.millionaires.external.bitbay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.annaczeczek.millionaires.external.bitbay.dto.HistoryDto;
import pl.annaczeczek.millionaires.external.bitbay.dto.InfoDto;

import java.time.Instant;
import java.util.Collections;

@Component
public class BitBayPrivateApi {

    private RestTemplate restTemplate;
    private static final String BASE_URL = "https://bitbay.net/API/Trading/tradingApi.php";

    @Autowired
    public BitBayPrivateApi(@Value("${bitbay.privateKey}") String privateKey, @Value("${bitbay.publicKey}") String publicKey) {
        restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new BitBayPrivateRequestInterceptor(privateKey, publicKey)));
    }

    public InfoDto info() {
        return post("method=info", InfoDto.class);
    }

    public HistoryDto[] history(String currency, int limit) {
        return post("method=history&currency=" + currency + "&limit=" + limit, HistoryDto[].class);
    }


    private <T> T post(String request, Class<T> responseType) {
        String moment = "&moment=" + (Instant.now().getEpochSecond() - 4);
        return restTemplate.postForEntity(BASE_URL, request + moment, responseType).getBody();
    }
}
