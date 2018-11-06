package com.vagner.zipkin.contract;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

public class ZipkinCustomerFacade {
    public static Map<String, Long> getCustomerSalariesByFunction(String function) {
        switch (function.toLowerCase()) {
            case "developers":
                Map<String, Long> devsAndSalaries = new HashMap<>();
                devsAndSalaries.put("Vanderson Catarina", 10142L);
                devsAndSalaries.put("Marrone Talaris", 11026L);
                devsAndSalaries.put("Thiago Descascador", 12142L);
                devsAndSalaries.put("Carlos FazDeTudo", 15142L);
                devsAndSalaries.put("Rafael Schineider", 1000000L);
                devsAndSalaries.put("David Patron", Long.MAX_VALUE);

                return devsAndSalaries;
            default:
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Invalid function provided");
        }
    }
}
