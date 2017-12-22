package pl.annaczeczek.millionaires.external.bitmarket.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.annaczeczek.millionaires.external.bitmarket.BitMarketCurrency;

import java.util.List;

public class OrderBookDto {
    @JsonIgnore
    private BitMarketCurrency currency;
    private List<List<Double>> bids;
    private List<List<Double>> asks;

    public BitMarketCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(BitMarketCurrency currency) {
        this.currency = currency;
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

    @Override
    public String toString() {
        return "OrderBookDto{" +
                "currency=" + currency +
                ", bids=" + bids +
                ", asks=" + asks +
                '}';
    }
}
