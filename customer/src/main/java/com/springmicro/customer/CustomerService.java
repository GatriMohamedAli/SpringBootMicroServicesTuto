package com.springmicro.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void register(CustomerRegistrationRequest customerRegistrationRequestRequest) {
        Customer customer=Customer.builder()
                .name(customerRegistrationRequestRequest.name())
                .lastname(customerRegistrationRequestRequest.lastname())
                .email(customerRegistrationRequestRequest.email())
                .build();
        // todo: check if mail is valid;
        // todo: check if mail isn't taken
        // todo: store in db
        customerRepository.save(customer);
    }
}
