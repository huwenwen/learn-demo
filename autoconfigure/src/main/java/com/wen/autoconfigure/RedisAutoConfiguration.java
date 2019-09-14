package com.wen.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huwenwen
 * @since 29/07/2018
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
@ConditionalOnProperty(prefix = "spring.wen.redis", name = "port", matchIfMissing = true)
@Slf4j
public class RedisAutoConfiguration {

    @Bean
    public RedisTemplate redis(RedisProperties properties) {
        log.info("host={} port={}", properties.getHost(), properties.getPort());
        return new RedisTemplate();
    }

}
