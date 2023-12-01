package com.hendisantika.orderorchestrator.service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : saga-pattern-orchestration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/2/23
 * Time: 06:03
 * To change this template use File | Settings | File Templates.
 */
public record OrderWorkflow(List<WorkflowStep> steps) implements Workflow {
}
