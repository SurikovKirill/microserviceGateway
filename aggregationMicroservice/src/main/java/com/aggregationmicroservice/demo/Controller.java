package com.aggregationmicroservice.demo;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/aggregation")
public class Controller {


    @GetMapping("{orderId}")
    public Map<String, String> aggregateOrderAndPayment(@PathVariable(value = "orderId") Integer orderId){
        Map<String, String> aggregatedResult = new HashMap<>();
        restservice service = new restservice(new RestTemplateBuilder());
        aggregatedResult.put("Payment", service.getPayment(orderId));
        aggregatedResult.put("Order", service.getOrder(orderId));
        return aggregatedResult;
    }
}
