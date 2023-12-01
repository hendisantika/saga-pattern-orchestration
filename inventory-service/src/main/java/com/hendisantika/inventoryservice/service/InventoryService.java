package com.hendisantika.inventoryservice.service;

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
}
