package com.bank.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDetailsDto {
    @NotNull(message = "name can not be null or empty")
    @Size(min = 3,max = 20,message = "name must contains 3 digits and goes upto 20 digits")
    private String name;
    @Email
    @NotNull(message = "email can not be null or empty")
    private String email;
    @NotNull
    @Pattern(regexp = "^$|[0-9]{10}",message = "mobile number must be ten digits")
    private String mobileNumber;
    private AccountsDto accountsDto;
    private LoansDto loansDto;
    private CardsDto cardsDto;

}
