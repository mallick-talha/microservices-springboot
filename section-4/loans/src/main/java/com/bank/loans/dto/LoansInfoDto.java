package com.bank.loans.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;
import java.util.List;

@ConfigurationProperties(prefix = "loans")
@Getter
@Setter
public class LoansInfoDto {
    private String message;
    private Map<String,String> contactDetails;
    private List<String>onCallSupport;
}
