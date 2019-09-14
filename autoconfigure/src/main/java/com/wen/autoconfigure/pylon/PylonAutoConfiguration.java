package com.wen.autoconfigure.pylon;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huwenwen
 * @since 11/08/2018
 */
@Configuration
@EnableConfigurationProperties(PylonProperties.class)
public class PylonAutoConfiguration {

    @Bean
    public ServerConfig serverConfig(PylonProperties properties) {
        return properties.getServer();
    }

    @Bean
    public ClientPostProcessor clientPostProcessor() {
        return new ClientPostProcessor();
    }

    @Bean
    public ClientBeanPostProcessor clientBeanPostProcessor(){
        return new ClientBeanPostProcessor();
    }

}
