package com.bank.loans.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;
import java.util.List;

@ConfigurationProperties(prefix = "loans")
public record LoansInfoDto(String message, Map<String,String> contactDetails, List<String>onCallSupport) {
}
