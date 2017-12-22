package pl.annaczeczek.millionaires.external.cryptowatch.dto;

import java.util.List;

public class Exchanges {

    public List<Exchange> result;
    public Allowance allowance;


    public static class Exchange {
        public String symbol;
        public String name;
        public String route;
        public boolean active;

        @Override
        public String toString() {
            return "Exchange{" +
                    "symbol='" + symbol + '\'' +
                    ", name='" + name + '\'' +
                    ", route='" + route + '\'' +
                    ", active=" + active +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "Exchanges{" +
                "result=" + result +
                ", allowance=" + allowance +
                '}';
    }
}


