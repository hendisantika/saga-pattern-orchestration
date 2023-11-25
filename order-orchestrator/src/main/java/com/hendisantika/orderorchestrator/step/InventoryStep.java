package com.hendisantika.orderorchestrator.step;

import com.hendisantika.orderorchestrator.common.InventoryRequestDTO;
import com.hendisantika.orderorchestrator.service.WorkflowStep;
import com.hendisantika.orderorchestrator.service.WorkflowStepStatus;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Created by IntelliJ IDEA.
 * Project : saga-pattern-orchestration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/26/23
 * Time: 05:16
 * To change this template use File | Settings | File Templates.
 */
public class InventoryStep implements WorkflowStep {

    private final WebClient webClient;
    private final InventoryRequestDTO requestDTO;
    private final WorkflowStepStatus stepStatus = WorkflowStepStatus.PENDING;

    public InventoryStep(WebClient webClient, InventoryRequestDTO requestDTO) {
        this.webClient = webClient;
        this.requestDTO = requestDTO;
    }
}
