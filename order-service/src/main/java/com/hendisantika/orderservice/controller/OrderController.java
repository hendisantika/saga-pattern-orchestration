package com.hendisantika.orderservice.controller;

import com.hendisantika.orderservice.dto.OrderRequestDTO;
import com.hendisantika.orderservice.dto.OrderResponseDTO;
import com.hendisantika.orderservice.entity.PurchaseOrder;
import com.hendisantika.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : saga-pattern-orchestration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/26/23
 * Time: 04:52
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public Mono<PurchaseOrder> createOrder(@RequestBody Mono<OrderRequestDTO> orderMono) {
        return orderMono.flatMap(orderService::createOrder);
    }

    @GetMapping("/all")
    public Flux<OrderResponseDTO> getOrders() {
        return orderService.getAllOrder();
    }
}
