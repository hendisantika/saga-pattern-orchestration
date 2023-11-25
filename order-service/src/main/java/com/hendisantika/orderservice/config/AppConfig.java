package com.hendisantika.orderservice.config;

import com.hendisantika.orderservice.dto.OrchestratorRequestDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

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
public class AppConfig {

    @Bean
    public Sinks.Many<OrchestratorRequestDTO> sink() {
        return Sinks.many().unicast().onBackpressureBuffer();
    }

    @Bean
    public Flux<OrchestratorRequestDTO> flux(Sinks.Many<OrchestratorRequestDTO> sink) {
        return sink.asFlux();
    }
}
