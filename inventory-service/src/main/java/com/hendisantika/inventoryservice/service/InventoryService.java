package com.hendisantika.inventoryservice.service;

import com.hendisantika.inventoryservice.dto.InventoryRequestDTO;
import com.hendisantika.inventoryservice.dto.InventoryResponseDTO;
import com.hendisantika.inventoryservice.dto.InventoryStatus;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : saga-pattern-orchestration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/2/23
 * Time: 06:12
 * To change this template use File | Settings | File Templates.
 */
@Service
public class InventoryService {

    private Map<Integer, Integer> inventoryMap;

    @PostConstruct
    private void init() {
        inventoryMap = new HashMap<>();

        inventoryMap.put(1, 2);
        inventoryMap.put(2, 3);
        inventoryMap.put(3, 4);
    }

    public InventoryResponseDTO deduct(InventoryRequestDTO requestDTO) {
        int qty = inventoryMap.getOrDefault(requestDTO.getProductId(), 0);

        InventoryResponseDTO responseDTO = new InventoryResponseDTO();
        responseDTO.setOrderId(requestDTO.getOrderId());
        responseDTO.setProductId(requestDTO.getProductId());
        responseDTO.setUserId(requestDTO.getUserId());
        responseDTO.setStatus(InventoryStatus.UNAVAILABLE);

        System.out.println("Inside Inventory::" + qty);

        if (qty > 0) {
            responseDTO.setStatus(InventoryStatus.AVAILABLE);
            inventoryMap.put(requestDTO.getProductId(), qty - 1);
        }

        return responseDTO;
    }
}
