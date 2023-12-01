package com.hendisantika.inventoryservice.dto;

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
 * Date: 12/2/23
 * Time: 06:10
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@ToString
public class InventoryRequestDTO {
    private Integer userId;

    private Integer productId;

    private UUID orderId;
}
