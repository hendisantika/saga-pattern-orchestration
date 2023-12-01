package com.hendisantika.orderorchestrator.step;

import com.hendisantika.orderorchestrator.common.InventoryRequestDTO;
import com.hendisantika.orderorchestrator.common.InventoryResponseDTO;
import com.hendisantika.orderorchestrator.common.InventoryStatus;
import com.hendisantika.orderorchestrator.service.WorkflowStep;
import com.hendisantika.orderorchestrator.service.WorkflowStepStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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
    private WorkflowStepStatus stepStatus = WorkflowStepStatus.PENDING;

    public InventoryStep(WebClient webClient, InventoryRequestDTO requestDTO) {
        this.webClient = webClient;
        this.requestDTO = requestDTO;
    }

    @Override
    public WorkflowStepStatus getStatus() {
        return stepStatus;
    }

    @Override
    public Mono<Boolean> process() {
        return webClient
                .post()
                .uri("/inventory/deduct")
                .body(BodyInserters.fromValue(requestDTO))
                .retrieve()
                .bodyToMono(InventoryResponseDTO.class)
                .map(r -> r.getStatus().equals(InventoryStatus.AVAILABLE))
                .doOnNext(b -> stepStatus = b ? WorkflowStepStatus.COMPLETE : WorkflowStepStatus.FAILED);
    }

    @Override
    public Mono<Boolean> revert() {
        return webClient
                .post()
                .uri("/inventory/add")
                .body(BodyInserters.fromValue(requestDTO))
                .retrieve()
                .bodyToMono(Void.class)
                .map(r -> true)
                .onErrorReturn(false);
    }
}
