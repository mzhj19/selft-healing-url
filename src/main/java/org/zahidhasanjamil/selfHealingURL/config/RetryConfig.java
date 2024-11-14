package org.zahidhasanjamil.selfHealingURL.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.net.UnknownHostException;
import java.util.Collections;

@Configuration
public class RetryConfig {

    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();

        // Define retry policy to handle UnknownHostException
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy(
                3, // Max attempts
                Collections.singletonMap(UnknownHostException.class, true)
        );
        retryTemplate.setRetryPolicy(retryPolicy);

        // Define backoff policy (optional)
        FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
        backOffPolicy.setBackOffPeriod(2000); // 2 seconds
        retryTemplate.setBackOffPolicy(backOffPolicy);

        return retryTemplate;
    }
}
