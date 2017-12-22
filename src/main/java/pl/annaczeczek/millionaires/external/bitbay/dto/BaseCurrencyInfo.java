package pl.annaczeczek.millionaires.external.bitbay.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.annaczeczek.millionaires.external.bitbay.BitBayCurrency;

public class BaseCurrencyInfo {

    @JsonIgnore
    public BitBayCurrency currency;
    public double max;
    public double min;
    public double last;
    public double bid;
    public double ask;
    public double vwap;
    public double average;
    public double volume;

    @Override
    public String toString() {
        return "BaseCurrencyInfo{" +
                "currency=" + currency +
                ", max=" + max +
                ", min=" + min +
                ", last=" + last +
                ", bid=" + bid +
                ", ask=" + ask +
                ", vwap=" + vwap +
                ", average=" + average +
                ", volume=" + volume +
                '}';
    }
}
