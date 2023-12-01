package com.hendisantika.inventoryservice.controller;

import com.hendisantika.inventoryservice.dto.InventoryRequestDTO;
import com.hendisantika.inventoryservice.dto.InventoryResponseDTO;
import com.hendisantika.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : saga-pattern-orchestration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/2/23
 * Time: 06:13
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/deduct")
    public InventoryResponseDTO az(@RequestBody InventoryRequestDTO rqRequestDTO) {
        return inventoryService.deduct(rqRequestDTO);

    }

    @PostMapping("/add")
    public void add(@RequestBody InventoryRequestDTO rqRequestDTO) {
        inventoryService.add(rqRequestDTO);
    }
}
}
