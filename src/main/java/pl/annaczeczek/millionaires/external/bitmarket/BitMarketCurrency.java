package pl.annaczeczek.millionaires.external.bitmarket;

public enum  BitMarketCurrency {

    BTCPLN("Bitcoin"),
    LTCPLN("Litecoin");

    public final String name;


    BitMarketCurrency(String name) {
        this.name = name;
    }

}
