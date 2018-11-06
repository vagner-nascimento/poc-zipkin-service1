package com.vagner.zipkin.contract;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class ZipkinCustomerController {
    @GetMapping(value = "salaries/{function}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> getCustomerSalariesByFunction(@PathVariable("function")
                                                           @NotNull(message = "Customer's function must be provided")
                                                                   String function) {
        return ZipkinCustomerFacade.getCustomerSalariesByFunction(function);
    }
}
