package pl.annaczeczek.millionaires.external.bitbay.dto;

public class BalanceDto {
    private double available;
    private double locked;

    public double getAvailable() {
        return available;
    }

    public void setAvailable(double available) {
        this.available = available;
    }

    public double getLocked() {
        return locked;
    }

    public void setLocked(double locked) {
        this.locked = locked;
    }

}
