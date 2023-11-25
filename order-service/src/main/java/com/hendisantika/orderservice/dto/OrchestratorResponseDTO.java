package com.hendisantika.orderservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : saga-pattern-orchestration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/26/23
 * Time: 04:37
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@ToString
public class OrchestratorResponseDTO {
    private Integer userId;
    private Integer productId;
    private UUID orderId;
    private Double amount;
    private OrderStatus status;
}
