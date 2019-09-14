package com.wen.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author huwenwen
 * @since 29/07/2018
 */
@ConfigurationProperties(prefix = "spring.wen.redis")
@Data
public class RedisProperties {

    private String host;

    private int port;

    private SSSLLL ssl = new SSSLLL();

    @Data
    public static class SSSLLL {
        private Integer enable;
    }

}
