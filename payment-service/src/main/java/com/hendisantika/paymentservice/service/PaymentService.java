package com.hendisantika.paymentservice.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : saga-pattern-orchestration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/26/23
 * Time: 04:58
 * To change this template use File | Settings | File Templates.
 */
@Service
@Slf4j
public class PaymentService {

    private Map<Integer, Double> paymentMap;

    @PostConstruct
    private void init() {
        paymentMap = new HashMap<>();

        paymentMap.put(1, 500d);
        paymentMap.put(2, 1000d);
        paymentMap.put(3, 700d);
    }
}
