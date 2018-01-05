package pl.annaczeczek.millionaires.domain.exchange;

import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ExchangeRateService {

    private static final Logger logger = LoggerFactory.getLogger(ExchangeRateService.class);

    @Autowired
    private InfluxDB influxDB;

    public void save(ExchangeRate exchangeRate) {
        Point point = Point.measurement("exchangeRates")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("exchange", exchangeRate.getExchange())
                .tag("cryptoCurrency", exchangeRate.getCryptoCurrency())
                .tag("currency", exchangeRate.getCurrency())
                .addField("exchangeRate", exchangeRate.getExchangeRate())
                .build();
        logger.info("Saving exchange rate : " + exchangeRate);
        influxDB.write(point);
    }

}
