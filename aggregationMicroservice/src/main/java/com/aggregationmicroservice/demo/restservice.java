package com.aggregationmicroservice.demo;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class restservice {

    private final RestTemplate restTemplate;

    public restservice(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getPayment(int id){
        String _id = Integer.toString(id);
        String url = "http://localhost:8011/payment-service/payment/"+_id;
        return this.restTemplate.getForObject(url, String.class);
    }
    public String getOrder(int id){
        String _id = Integer.toString(id);
        String url = "http://localhost:8011/order-service/orders/"+_id;
        return this.restTemplate.getForObject(url, String.class);
    }


}
