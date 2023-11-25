package com.hendisantika.orderservice.consumer;

import com.hendisantika.orderservice.dto.OrchestratorRequestDTO;
import com.hendisantika.orderservice.service.UpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

/**
 * Created by IntelliJ IDEA.
 * Project : saga-pattern-orchestration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/26/23
 * Time: 04:50
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@RequiredArgsConstructor
public class OrderConsumer {

    private final Flux<OrchestratorRequestDTO> flux;

    private final UpdateService update;
}
