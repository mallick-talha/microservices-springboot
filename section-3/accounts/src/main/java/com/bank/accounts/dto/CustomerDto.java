package com.bank.accounts.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerDto {

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
}
