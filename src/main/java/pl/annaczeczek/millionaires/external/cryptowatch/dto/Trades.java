package pl.annaczeczek.millionaires.external.cryptowatch.dto;

import java.util.List;

public class Trades {

    public List<List<Double>> result;
    public Allowance allowance;

    @Override
    public String toString() {
        return "Trades{" +
                "result=" + result +
                ", allowance=" + allowance +
                '}';
    }
}
