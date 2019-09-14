package com.wen.autoconfigure.pylon;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author huwenwen
 * @since 11/08/2018
 */
@Data
@ConfigurationProperties(prefix = "spring.pylon.server")
public class ServerConfig {
    private String name;
    private String cluster;
    private List<String> interfaces;
}
