package com.hendisantika.orderorchestrator.config;

import com.hendisantika.orderorchestrator.common.OrchestratorRequestDTO;
import com.hendisantika.orderorchestrator.common.OrchestratorResponseDTO;
import com.hendisantika.orderorchestrator.service.OrchestratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Function;

/**
 * Created by IntelliJ IDEA.
 * Project : saga-pattern-orchestration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/2/23
 * Time: 06:01
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@RequiredArgsConstructor
public class OrchestratorConfig {

    private final OrchestratorService orchestratorService;

    @Bean
    public Function<Flux<OrchestratorRequestDTO>, Flux<OrchestratorResponseDTO>> processor() {
        return flux -> flux.flatMap(dto -> orchestratorService.orderProduct(dto))
                .doOnNext(dto -> System.out.println("Status : " + dto.getStatus()));
    }
}
