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

    @Scheduled(cron = "0 0 * * * *") //every hour
    private double get() {
        double r = fixerPublicApi.getUsdToPlnRate();
        rate.set(r);
        return r;
    }

    public double getRate() {
        double r = rate.get();
        if (r == 0.0) {
            return get();
        }
        return r;
    }
}
