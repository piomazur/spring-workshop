package com.azimo.tukan.logging.micrometer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class SanitizeConfiguration {

    @Bean
    public SanitizedToStringAnnotationProcessor sanitizedToStringAnnotationProcessor() {
        return new SanitizedToStringAnnotationProcessor();
    }
}
