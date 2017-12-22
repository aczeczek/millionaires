package pl.annaczeczek.millionaires.external.cryptowatch.dto;

import java.util.List;

public class OrderBook {

    public Result result;
    public Allowance allowance;


    public class Result {

        public List<List<Double>> asks;
        public List<List<Double>> bids;

    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "result=" + result +
                ", allowance=" + allowance +
                '}';
    }
}
