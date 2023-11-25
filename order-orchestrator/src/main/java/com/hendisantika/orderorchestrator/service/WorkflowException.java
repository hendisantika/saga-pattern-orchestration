package com.hendisantika.orderorchestrator.service;

/**
 * Created by IntelliJ IDEA.
 * Project : saga-pattern-orchestration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/26/23
 * Time: 05:15
 * To change this template use File | Settings | File Templates.
 */
public class WorkflowException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public WorkflowException(String message) {
        super(message);
    }
}
