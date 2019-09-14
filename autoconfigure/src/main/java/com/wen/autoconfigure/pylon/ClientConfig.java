package com.wen.autoconfigure.pylon;

import lombok.Data;

import java.util.List;

/**
 * @author huwenwen
 * @since 11/08/2018
 */
@Data
public class ClientConfig {
    private String name;
    private String cluster;
    private List<String> interfaces;
}
