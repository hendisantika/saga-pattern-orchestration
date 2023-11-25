package com.hendisantika.paymentservice.service;

import com.hendisantika.paymentservice.dto.PaymentRequestDTO;
import com.hendisantika.paymentservice.dto.PaymentResponseDTO;
import com.hendisantika.paymentservice.dto.PaymentStatus;
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

    public PaymentResponseDTO debit(PaymentRequestDTO requestDTO) {
        double balance = paymentMap.getOrDefault(requestDTO.getUserId(), 0d);

        PaymentResponseDTO responseDTO = new PaymentResponseDTO();
        responseDTO.setOrderId(requestDTO.getOrderId());
        responseDTO.setUserId(requestDTO.getUserId());
        responseDTO.setAmount(requestDTO.getAmount());
        responseDTO.setStatus(PaymentStatus.PAYMENT_REJECTED);

        log.info("Inside Payment:: " + balance);

        if (balance >= requestDTO.getAmount()) {
            responseDTO.setStatus(PaymentStatus.PAYMENT_APPROVED);
            paymentMap.put(requestDTO.getUserId(), balance - requestDTO.getAmount());
        }

        return responseDTO;
    }

    public void credit(PaymentRequestDTO requestDTO) {
        paymentMap.computeIfPresent(requestDTO.getUserId(), (k, v) -> v + requestDTO.getAmount());
    }
}
