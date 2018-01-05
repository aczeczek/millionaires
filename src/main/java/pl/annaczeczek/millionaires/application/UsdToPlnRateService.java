package pl.annaczeczek.millionaires.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.annaczeczek.millionaires.external.fixer.FixerPublicApi;

import java.util.concurrent.atomic.AtomicReference;

@Component
public class UsdToPlnRateService {

    @Autowired
    private FixerPublicApi fixerPublicApi;

    private static AtomicReference<Double> rate = new AtomicReference<>(0.0);

    @Scheduled(fixedRate = 60000L)
    private void get() {
        double r = fixerPublicApi.getUsdToPlnRate();
        System.out.println(r);
        rate.set(r);
    }

    public double getRate() {
        double r = rate.get();
        if (r == 0.0) {
            get();
        }
        return r;
    }
}
