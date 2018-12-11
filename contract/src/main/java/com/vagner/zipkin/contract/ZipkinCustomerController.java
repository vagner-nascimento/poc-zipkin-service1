package com.vagner.zipkin.contract;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customers")
public class ZipkinCustomerController {
    @Autowired
    private ZipkinCustomerFacade facade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DeveloperResponse> getCustomerSalariesByFunction() {
        return facade.getCustomerSalariesByFunction();
    }
}
