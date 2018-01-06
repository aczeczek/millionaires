package pl.annaczeczek.millionaires.external.bitbay.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.annaczeczek.millionaires.external.bitbay.BitBayCurrency;

import java.util.List;


// max jest kursem transakcji, która miała największą wartość
// min jest kursem transakcji, która miała najmniejszą wartość
// bid jest najkorzystniejszym kursem aktualnych ofert kupna
// ask jest najkorzystniejszym kursem aktualnych ofert sprzedaży
// vwap jest średnią ważoną z ostatnich 24 godzin
// average jest średnią ceną liczoną z 3 najlepszych ofert sprzedaży
public class AdvancedCurrencyInfoDto extends BaseCurrencyInfo {

    public List<List<Double>> bids;
    public List<List<Double>> asks;
    public List<TransactionDto> transactions;


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
