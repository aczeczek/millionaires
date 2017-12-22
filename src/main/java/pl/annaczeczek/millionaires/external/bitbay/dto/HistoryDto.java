package pl.annaczeczek.millionaires.external.bitbay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HistoryDto {
    public long id;
    public double amount;
    @JsonProperty("balance_after")
    public double balanceAfter;
    public String currency;
    @JsonProperty("operation_type")
    public String operationType;
    public String time;
    public String comment;
    
}
