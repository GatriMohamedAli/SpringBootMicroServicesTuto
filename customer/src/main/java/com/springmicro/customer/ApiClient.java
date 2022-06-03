package com.springmicro.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "fraudApi", url = "http://localhost:8082/")
public interface ApiClient {
    @RequestMapping(method = RequestMethod.GET, path = "api/v1/fraud-check/{customerId}")
    FraudCheckResponse isFraudulent(@PathVariable("customerId") Integer customerId);
}
