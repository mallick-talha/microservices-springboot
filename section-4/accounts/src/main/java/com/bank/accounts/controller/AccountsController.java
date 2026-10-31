package com.bank.accounts.controller;

import com.bank.accounts.constant.AccountsConstant;
import com.bank.accounts.dto.AccountInfoDto;
import com.bank.accounts.dto.CustomerDto;
import com.bank.accounts.dto.ResponseDto;
import com.bank.accounts.service.serviceImp.AccountsService;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@Validated
public class AccountsController {
    private final AccountsService accountsService;
    private final AccountInfoDto accountInfoDto;
    @Value("${build.version}")
    private String version;

    public AccountsController(AccountsService accountsService,AccountInfoDto accountInfoDto) {
        this.accountsService = accountsService;
        this.accountInfoDto=accountInfoDto;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCustomer(@Valid @RequestBody CustomerDto dto){
        accountsService.createAccount(dto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstant.STATUS_201,AccountsConstant.MESSAGE_201));
    }
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam
                                                               @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                           String mobileNumber) {
        CustomerDto customerDto = accountsService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails( @Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = accountsService.updateAccount(customerDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstant.STATUS_200, AccountsConstant.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstant.STATUS_417, AccountsConstant.MESSAGE_417_UPDATE));
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetails(@RequestParam
                                                                @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                                String mobileNumber) {
        boolean isDeleted = accountsService.deleteAccount(mobileNumber);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstant.STATUS_200, AccountsConstant.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstant.STATUS_417, AccountsConstant.MESSAGE_417_DELETE));
        }
    }
    @GetMapping("/get-version")
    public String getVersion(){

        return version;
    }
//    @GetMapping("/get/java-version")
//    public String getJavaVersion(){
//        return environment.getProperty("build.version");
//    }
    @GetMapping("get/account-info")
    public ResponseEntity<AccountInfoDto>getAccountsData(){
        return ResponseEntity.status(HttpStatus.OK).body(accountInfoDto);
    }
}
