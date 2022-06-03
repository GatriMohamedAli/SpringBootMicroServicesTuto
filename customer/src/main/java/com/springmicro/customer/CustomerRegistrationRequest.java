package com.springmicro.customer;

public record CustomerRegistrationRequest(
        String name,
        String lastname,
        String email
) {
}
