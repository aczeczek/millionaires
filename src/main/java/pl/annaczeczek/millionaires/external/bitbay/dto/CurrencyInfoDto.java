package pl.annaczeczek.millionaires.external.bitbay.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.annaczeczek.millionaires.external.bitbay.BitBayCurrency;

import java.util.List;


// max jest kursem transakcji, która miała największą wartość
// min jest kursem transakcji, która miała najmniejszą wartość
// bid jest najkorzystniejszym kursem aktualnych ofert kupna
// ask jest najkorzystniejszym kursem aktualnych ofert sprzedaży
// vwap jestśrednią ważoną z ostatnich 24 godzin
// average jest średnią ceną liczoną z 3 najlepszych ofert sprzedaży
public class CurrencyInfoDto {

    @JsonIgnore
    private BitBayCurrency currency;
    private double max;
    private double min;
    private double last;
    private double bid;
    private double ask;
    private double vwap;
    private double average;
    private double volume;
    private List<List<Double>> bids;
    private List<List<Double>> asks;
    private List<TransactionDto> transactions;

    public BitBayCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(BitBayCurrency currency) {
        this.currency = currency;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getLast() {
        return last;
    }

    public void setLast(double last) {
        this.last = last;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double getVwap() {
        return vwap;
    }

    public void setVwap(double vwap) {
        this.vwap = vwap;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public List<List<Double>> getBids() {
        return bids;
    }

    public void setBids(List<List<Double>> bids) {
        this.bids = bids;
    }

    public List<List<Double>> getAsks() {
        return asks;
    }

    public void setAsks(List<List<Double>> asks) {
        this.asks = asks;
    }

    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDto> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "CurrencyInfoDto{" +
                "currency=" + currency +
                ", max=" + max +
                ", min=" + min +
                ", last=" + last +
                ", bid=" + bid +
                ", ask=" + ask +
                ", vwap=" + vwap +
                ", average=" + average +
                ", volume=" + volume +
                ", bids=" + bids +
                ", asks=" + asks +
                ", transactions=" + transactions +
                '}';
    }
}
