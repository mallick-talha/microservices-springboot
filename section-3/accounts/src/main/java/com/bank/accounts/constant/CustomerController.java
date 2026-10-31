package com.bank.accounts.constant;

import com.bank.accounts.dto.CustomerDetailsDto;
import com.bank.accounts.service.serviceImp.CustomerService;
import jakarta.validation.constraints.Pattern;
import org.apache.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerDetails")
@Validated
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/fetchDetails")
    public ResponseEntity<CustomerDetailsDto>fetchCustomerDetails( @RequestParam
                                                                       @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                                       String mobileNumber){
        CustomerDetailsDto customerDetailsDto = customerService.fetchCustomerDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.SC_OK).body(customerDetailsDto);
    }
}