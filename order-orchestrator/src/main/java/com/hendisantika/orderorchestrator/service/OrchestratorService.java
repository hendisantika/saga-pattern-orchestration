package com.hendisantika.orderorchestrator.service;

import com.hendisantika.orderorchestrator.common.OrchestratorRequestDTO;
import com.hendisantika.orderorchestrator.common.OrchestratorResponseDTO;
import com.hendisantika.orderorchestrator.common.OrderStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : saga-pattern-orchestration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/26/23
 * Time: 05:10
 * To change this template use File | Settings | File Templates.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class OrchestratorService {

    @Qualifier("payment")
    private final WebClient paymentClient;

    @Qualifier("inventory")
    private final WebClient inventoryClient;

    public Mono<OrchestratorResponseDTO> orderProduct(final OrchestratorRequestDTO requestDTO) {
        Workflow orderWorkflow = getOrderWorkflow(requestDTO);

        return Flux.fromStream(() -> orderWorkflow.getSteps().stream()).flatMap(WorkflowStep::process)
                .handle(((aBoolean, synchronousSink) -> {
                    if (aBoolean.booleanValue()) {
                        synchronousSink.next(true);
                    } else {
                        synchronousSink.error(new WorkflowException("Order not processed."));
                    }
                })).then(Mono.fromCallable(() -> getResponseDTO(requestDTO, OrderStatus.ORDER_COMPLETED)))
                .onErrorResume(ex -> revertOrder(orderWorkflow, requestDTO));

    }

    private Mono<OrchestratorResponseDTO> revertOrder(final Workflow workflow, final OrchestratorRequestDTO requestDTO) {
        return Flux.fromStream(() -> workflow.getSteps().stream())
                .filter(wf -> wf.getStatus().equals(WorkflowStepStatus.COMPLETE))
                .flatMap(WorkflowStep::revert).retry(3)
                .then(Mono.just(getResponseDTO(requestDTO, OrderStatus.ORDER_CANCELLED)));
    }
}
