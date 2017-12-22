package pl.annaczeczek.millionaires.external.bitmarket.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.annaczeczek.millionaires.external.bitmarket.BitMarketCurrency;

import java.util.List;

public class OrderBookDto {
    @JsonIgnore
    public BitMarketCurrency currency;
    public List<List<Double>> bids;
    public List<List<Double>> asks;


    @Override
    public String toString() {
        return "OrderBookDto{" +
                "currency=" + currency +
                ", bids=" + bids +
                ", asks=" + asks +
                '}';
    }
}
