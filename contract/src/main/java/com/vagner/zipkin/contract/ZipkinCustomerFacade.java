package com.vagner.zipkin.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

@Service
public class ZipkinCustomerFacade {
    @Autowired
    private FinancialResrClient financialResrClient;

    public List<DeveloperResponse> getCustomerSalariesByFunction(String function) {
        if ("developers".equalsIgnoreCase(function)) {

            Map<Integer, Long> idsAndSalaries = financialResrClient.getSalariesByIds(Arrays.asList(1, 2, 3, 4, 5));

            List<DeveloperResponse> developers = new ArrayList<>();

            developers.add(DeveloperResponse.builder()
                    .id(1)
                    .name("Vanderson Catarina")
                    .salary(idsAndSalaries.get(1)).build());

            developers.add(DeveloperResponse.builder()
                    .id(2)
                    .name("Thiago Descascador")
                    .salary(idsAndSalaries.get(2)).build());

            developers.add(DeveloperResponse.builder()
                    .id(3)
                    .name("Carlos FazDeTudo")
                    .salary(idsAndSalaries.get(3)).build());

            developers.add(DeveloperResponse.builder()
                    .id(4)
                    .name("Rafael Madero Schineider")
                    .salary(idsAndSalaries.get(4)).build());

            developers.add(DeveloperResponse.builder()
                    .id(5)
                    .name("David Patron")
                    .salary(idsAndSalaries.get(5)).build());

            return developers;
        }

        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Invalid function provided");
    }
}
