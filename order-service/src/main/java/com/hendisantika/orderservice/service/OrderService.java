package com.hendisantika.orderservice.service;

import com.hendisantika.orderservice.dto.OrchestratorRequestDTO;
import com.hendisantika.orderservice.dto.OrderRequestDTO;
import com.hendisantika.orderservice.dto.OrderResponseDTO;
import com.hendisantika.orderservice.entity.PurchaseOrder;
import com.hendisantika.orderservice.repository.PurchaseOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : saga-pattern-orchestration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/26/23
 * Time: 04:45
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private static final Map<Integer, Double> ORDER_PRICE = Map.of(1, 100d,
            2, 200d,
            3, 300d);

    private final PurchaseOrderRepository orderRepository;

    private final Sinks.Many<OrchestratorRequestDTO> sink;

    public Mono<PurchaseOrder> createOrder(OrderRequestDTO orderRequestDTO) {
        return orderRepository.save(dtoToEntity(orderRequestDTO))
                .doOnNext(e -> orderRequestDTO.setOrderId(e.getId()))
                .doOnNext(e -> emitEvent(orderRequestDTO));
    }

    public Flux<OrderResponseDTO> getAllOrder() {
        return orderRepository.findAll()
                .map(this::entityToDto);
    }

    private void emitEvent(OrderRequestDTO orderRequestDTO) {
        sink.tryEmitNext(getOrchestratorRequestDTO(orderRequestDTO));
    }

}
