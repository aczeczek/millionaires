package pl.annaczeczek.millionaires.external.bitbay.dto;

public class TransactionDto {

    private long date;
    private double price;
    private String type;
    private double amount;
    private String tid;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

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
