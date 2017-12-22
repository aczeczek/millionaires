package pl.annaczeczek.millionaires.external.cryptowatch.dto;

import java.util.List;

public class Markets {

    public List<Markets.Market> result;
    public Allowance allowance;


    public static class Market {
        public String exchange;
        public String pair;
        public boolean active;
        public String route;
    }

    @Override
    public String toString() {
        return "Exchanges{" +
                "result=" + result +
                ", allowance=" + allowance +
                '}';
    }
}
