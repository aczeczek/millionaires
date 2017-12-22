package pl.annaczeczek.millionaires.external.bitbay.dto;

public class TransactionDto {

    public long date;
    public double price;
    public String type;
    public double amount;
    public String tid;
    
    @Override
    public String toString() {
        return "TransactionDto{" +
                "date=" + date +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", tid='" + tid + '\'' +
                '}';
    }
}
