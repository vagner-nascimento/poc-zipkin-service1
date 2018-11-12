package com.vagner.zipkin.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class ZipkinCustomerController {
    @Autowired
    private ZipkinCustomerFacade facade;

    @GetMapping(value = "salaries/{function}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DeveloperResponse> getCustomerSalariesByFunction(@PathVariable("function")
                                                                 @NotNull(message = "Customer's function must be provided")
                                                                         String function) {
        return facade.getCustomerSalariesByFunction(function);
    }
}
