package com.vagner.zipkin;

import com.vagner.zipkin.contract.ApplicationProperties;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Slf4j
@Getter
@SpringBootApplication
public class Application {
    @Autowired
    private AmqpAdmin amqpAdmin;
    @Autowired
    private ApplicationProperties properties;
/*
        @Bean
        public Sampler getSampler() {
            return Sampler.ALWAYS_SAMPLE;
        }
*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @PostConstruct
    void setup() {
        amqpAdmin.declareQueue(new Queue(properties.getQueuePocZipkin()));
    }
}
