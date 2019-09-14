package com.wen.autoconfigure.pylon;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author huwenwen
 * @since 11/08/2018
 */
@Data
@ConfigurationProperties("spring.pylon")
public class PylonProperties {

    private ServerConfig server;

    private List<ClientConfig> clients;
}
