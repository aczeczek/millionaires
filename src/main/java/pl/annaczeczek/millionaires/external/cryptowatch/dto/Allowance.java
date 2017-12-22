package pl.annaczeczek.millionaires.external.cryptowatch.dto;

public class Allowance {
    public int cost;
    public long remaining;

    @Override
    public String toString() {
        return "Allowance{" +
                "cost=" + cost +
                ", remaining=" + remaining +
                '}';
    }
}
