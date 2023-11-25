package com.hendisantika.orderservice.service;

import com.hendisantika.orderservice.dto.OrchestratorResponseDTO;
import com.hendisantika.orderservice.repository.PurchaseOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : saga-pattern-orchestration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/26/23
 * Time: 04:48
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateService {

    private final PurchaseOrderRepository orderRepository;

    public Mono<Void> updateOrder(OrchestratorResponseDTO responseDTO) {
        log.info("Response::" + responseDTO.getStatus());

        return orderRepository.findById(responseDTO.getOrderId())
                .doOnNext(p -> p.setStatus(responseDTO.getStatus()))
                .doOnNext(orderRepository::save)
                .then();
    }
}
