package pl.annaczeczek.millionaires.infrastructure;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Pong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class InfluxDBConfig {

    private static final Logger logger = LoggerFactory.getLogger(InfluxDBConfig.class);

    @Value("${influx.url}")
    private String url;
    @Value("${influx.username}")
    private String username;
    @Value("${influx.password}")
    private String password;

    @Bean
    public InfluxDB influxDB() {

        InfluxDB influxDB = InfluxDBFactory.connect(url, username, password);
        Pong ping = influxDB.ping();
//        influxDB.deleteDatabase("millionaires");
        influxDB.createDatabase("millionaires");
        influxDB.setDatabase("millionaires");
        logger.info("Influx connection: " + ping);
        influxDB.enableBatch(100, 1000, TimeUnit.MILLISECONDS);
        return influxDB;
    }

}