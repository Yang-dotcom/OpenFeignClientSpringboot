package com.example.democlient.infrastructure.repositories;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

public class FeignConfig {
    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    public static class CustomErrorDecoder implements ErrorDecoder {

        private static final Logger logger = LoggerFactory.getLogger(CustomErrorDecoder.class);

        @Override
        public Exception decode(String methodKey, Response response) {
            logger.error("Error occurred in method {} with status {}: {}",
                    methodKey, response.status(), response.reason());
            return new RuntimeException("Feign client error: " + response.reason());
        }
    }
}
