package com.hendisantika.orderorchestrator.service;

import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : saga-pattern-orchestration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/26/23
 * Time: 05:14
 * To change this template use File | Settings | File Templates.
 */
public interface WorkflowStep {

    WorkflowStepStatus getStatus();

    Mono<Boolean> process();

    Mono<Boolean> revert();
}
