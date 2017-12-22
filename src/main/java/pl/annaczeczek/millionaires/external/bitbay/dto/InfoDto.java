package pl.annaczeczek.millionaires.external.bitbay.dto;

import java.util.Map;

public class InfoDto {

    public int success;
    public Map<String, BalanceDto> balances;
    public Map<String, String> addresses;
    public double fee;
}
