package com.hendisantika.orderorchestrator.step;

import com.hendisantika.orderorchestrator.common.PaymentRequestDTO;
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
 * Time: 05:17
 * To change this template use File | Settings | File Templates.
 */
public class PaymentStep implements WorkflowStep {

    private final WebClient webClient;
    private final PaymentRequestDTO requestDTO;
    private final WorkflowStepStatus stepStatus = WorkflowStepStatus.PENDING;

    public PaymentStep(WebClient webClient, PaymentRequestDTO requestDTO) {
        this.webClient = webClient;
        this.requestDTO = requestDTO;
    }

    @Override
    public WorkflowStepStatus getStatus() {
        return stepStatus;
    }
}
