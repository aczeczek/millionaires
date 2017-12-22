package pl.annaczeczek.millionaires.external.bitbay.dto;

import java.util.Map;

public class InfoDto {

    private int success;
    private Map<String, BalanceDto> balances;
    private Map<String, String> addresses;
    private double fee;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public Map<String, BalanceDto> getBalances() {
        return balances;
    }

    public void setBalances(Map<String, BalanceDto> balances) {
        this.balances = balances;
    }

    public Map<String, String> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<String, String> addresses) {
        this.addresses = addresses;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
