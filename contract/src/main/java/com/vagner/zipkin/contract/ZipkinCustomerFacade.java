package com.vagner.zipkin.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ZipkinCustomerFacade {
    @Autowired
    private FinancialResrClient financialResrClient;

    public List<DeveloperResponse> getCustomerSalariesByFunction(String function) {
        if ("developers".equalsIgnoreCase(function)) {

            //Map<Integer, Long> idsAndSalaries = financialResrClient.getSalariesByIds(Arrays.asList(1, 2, 3, 4, 5));

            List<DeveloperResponse> developers = new ArrayList<>();

            developers.add(DeveloperResponse.builder()
                    .id(1)
                    .name("Vanderson Catarina")
                    //.salary(idsAndSalaries.get(1))
                    .salary(ThreadLocalRandom.current().nextLong(1000000))
                    .build());
            developers.add(DeveloperResponse.builder()
                    .id(2)
                    .name("Thiago Descascador")
                    //.salary(idsAndSalaries.get(2))
                    .salary(ThreadLocalRandom.current().nextLong(1000000))
                    .build());

            developers.add(DeveloperResponse.builder()
                    .id(3)
                    .name("Carlos FazDeTudo")
                    //.salary(idsAndSalaries.get(3))
                    .salary(ThreadLocalRandom.current().nextLong(1000000))
                    .build());

            developers.add(DeveloperResponse.builder()
                    .id(4)
                    .name("Rafael Madero Schineider")
                    //.salary(idsAndSalaries.get(4))
                    .salary(ThreadLocalRandom.current().nextLong(1000000))
                    .build());

            return developers;
        }

        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Invalid function provided");
    }
}
