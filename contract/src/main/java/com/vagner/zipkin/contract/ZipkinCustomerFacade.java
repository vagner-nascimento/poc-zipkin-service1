package com.vagner.zipkin.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class ZipkinCustomerFacade {
    @Autowired
    private FinancialResrClient financialResrClient;

    public List<DeveloperResponse> getCustomerSalariesByFunction() {

        Map<Integer, Long> idsAndSalaries = financialResrClient.getSalariesByIds(Arrays.asList(1, 2, 3, 4, 5));

        List<DeveloperResponse> developers = new ArrayList<>();

        developers.add(DeveloperResponse.builder()
                .id(1)
                .name("Vanderson Catarina")
                .salary(idsAndSalaries.get(1))
                .build());
        developers.add(DeveloperResponse.builder()
                .id(2)
                .name("Thiago Descascador")
                .salary(idsAndSalaries.get(2))
                .build());

        developers.add(DeveloperResponse.builder()
                .id(3)
                .name("Carlos FazDeTudo")
                .salary(idsAndSalaries.get(3))
                .build());

        developers.add(DeveloperResponse.builder()
                .id(4)
                .name("Rafael Madero Schineider")
                .salary(idsAndSalaries.get(4))
                .build());

        return developers;
    }
}
