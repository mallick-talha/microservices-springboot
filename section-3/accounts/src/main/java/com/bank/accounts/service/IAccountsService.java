package com.bank.accounts.service;

import com.bank.accounts.dto.CustomerDto;
import com.bank.accounts.entity.Customer;

public interface IAccountsService {
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);

}
