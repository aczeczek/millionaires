package pl.annaczeczek.millionaires.external.bitmarket.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.annaczeczek.millionaires.external.bitmarket.BitMarketCurrency;

public class TradeDto {
    @JsonIgnore
    public BitMarketCurrency currency;
    public Double amount;
    public Double price;
    public Integer date;
    public Integer tid;
    public String type;


    @Override
    public String toString() {
        return "TradeDto{" +
                "currency=" + currency +
                ", amount=" + amount +
                ", price=" + price +
                ", date=" + date +
                ", tid=" + tid +
                ", type='" + type + '\'' +
                '}';
    }
}
