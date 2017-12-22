package pl.annaczeczek.millionaires.external.bitbay;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class BitBayPrivateRequestInterceptor implements ClientHttpRequestInterceptor {

    private String privateKey;
    private String publicKey;

    public BitBayPrivateRequestInterceptor(String privateKey, String publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        try {
            HttpHeaders headers = request.getHeaders();
            headers.add("API-Key", publicKey);
            String hashedQuery = buildHmacSignature(body);
            headers.add("API-Hash", hashedQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return execution.execute(request, body);
    }


    private String buildHmacSignature(byte[] value) {
        String result;
        try {
            Mac hmacSHA512 = Mac.getInstance("HmacSHA512");
            SecretKeySpec secretKeySpec = new SecretKeySpec(privateKey.getBytes(), "HmacSHA512");
            hmacSHA512.init(secretKeySpec);
            byte[] digest = hmacSHA512.doFinal(value);
            BigInteger hash = new BigInteger(1, digest);
            result = hash.toString(16);
            if ((result.length() % 2) != 0) {
                result = "0" + result;
            }
        } catch (IllegalStateException | InvalidKeyException | NoSuchAlgorithmException ex) {
            throw new RuntimeException("Problem while calculating HMAC", ex);
        }
        return result;
    }
}
