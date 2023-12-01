package com.hendisantika.orderorchestrator.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Created by IntelliJ IDEA.
 * Project : saga-pattern-orchestration
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/2/23
 * Time: 06:02
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class WebClientConfig {
    @Bean
    @Qualifier("payment")
    public WebClient paymentClient(@Value("${service.endpoints.payment}") String endpoint) {
        return WebClient.builder()
                .baseUrl(endpoint)
                .build();
    }
}
