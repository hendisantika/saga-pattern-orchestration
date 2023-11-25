package com.hendisantika.orderorchestrator.common;

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
 * Time: 05:08
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@ToString
public class OrderRequestDTO {
    private Integer userId;
    private Integer productId;
    private UUID orderId;
}
