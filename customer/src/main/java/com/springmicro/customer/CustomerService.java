package com.springmicro.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
    public void register(CustomerRegistrationRequest customerRegistrationRequestRequest) {
        Customer customer=Customer.builder()
                .name(customerRegistrationRequestRequest.name())
                .lastname(customerRegistrationRequestRequest.lastname())
                .email(customerRegistrationRequestRequest.email())
                .build();
        // todo: check if mail is valid;
        // todo: check if mail isn't taken
        // todo: store in db
        customerRepository.saveAndFlush(customer);
        //USING RESTTEMPLATE
        restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        //USING OPEN FIEGN
        //apiClient.isFraudulent(customer.getId());
    }
}
