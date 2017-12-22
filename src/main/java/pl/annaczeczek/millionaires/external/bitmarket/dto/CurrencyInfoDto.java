package pl.annaczeczek.millionaires.external.bitmarket.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.annaczeczek.millionaires.external.bitmarket.BitMarketCurrency;

public class CurrencyInfoDto {

    @JsonIgnore
    public BitMarketCurrency currency;
    public double ask;
    public double bid;
    public double last;
    public double low;
    public double high;
    public double vwap;
    public double volume;

    @Override
    public String toString() {
        return "CurrencyInfoDto{" +
                "currency=" + currency +
                ", ask=" + ask +
                ", bid=" + bid +
                ", last=" + last +
                ", low=" + low +
                ", high=" + high +
                ", vwap=" + vwap +
                ", volume=" + volume +
                '}';
    }
}
