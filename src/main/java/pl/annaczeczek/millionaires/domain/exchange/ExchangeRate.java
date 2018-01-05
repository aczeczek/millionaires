package pl.annaczeczek.millionaires.domain.exchange;

public class ExchangeRate {

    private String exchange;
    private String cryptoCurrency;
    private String currency;
    private double exchangeRate;

    public ExchangeRate(String exchange, String cryptoCurrency, String currency, double exchangeRate) {
        this.exchange = exchange;
        this.cryptoCurrency = cryptoCurrency;
        this.currency = currency;
        this.exchangeRate = exchangeRate;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getCryptoCurrency() {
        return cryptoCurrency;
    }

    public void setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
