package com.hendisantika.orderservice.consumer;

import com.hendisantika.orderservice.dto.OrchestratorRequestDTO;
import com.hendisantika.orderservice.dto.OrchestratorResponseDTO;
import com.hendisantika.orderservice.service.UpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;
import java.util.function.Supplier;

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

    @Bean
    public Supplier<Flux<OrchestratorRequestDTO>> supplier() {
        return () -> flux;
    }

    @Bean
    public Consumer<Flux<OrchestratorResponseDTO>> consumer() {
        return c -> c
                .doOnNext(a -> System.out.println("Consuming::" + a))
                .flatMap(responseDTO -> update.updateOrder(responseDTO))
                .subscribe();
    }

}
