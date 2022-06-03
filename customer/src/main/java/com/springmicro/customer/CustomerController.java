package com.springmicro.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequestRequest){
        log.info(String.valueOf(customerRegistrationRequestRequest));
        customerService.register(customerRegistrationRequestRequest);
    }
}
