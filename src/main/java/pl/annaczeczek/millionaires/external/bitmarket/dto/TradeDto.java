package pl.annaczeczek.millionaires.external.bitmarket.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.annaczeczek.millionaires.external.bitmarket.BitMarketCurrency;

public class TradeDto {

    @JsonIgnore
    private BitMarketCurrency currency;
    public Double amount;
    public Double price;
    public Integer date;
    public Integer tid;
    public String type;

    public BitMarketCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(BitMarketCurrency currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
