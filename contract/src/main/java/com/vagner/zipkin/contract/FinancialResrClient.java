package com.vagner.zipkin.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FinancialResrClient {
    private static final String END_POINT = "http://localhost:8082/zipkin/financial/salaries/";
    @Autowired
    private RestTemplate restTemplate;

    public Map<Integer, Long> getSalariesByIds(List<Integer> ids) {
        return restTemplate.exchange(END_POINT.concat(ids.stream().
                        map(Object::toString).
                        collect(Collectors.joining(","))),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<Map<Integer, Long>>() {
                }).getBody();
    }
}
