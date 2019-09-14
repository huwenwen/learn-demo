package com.wen.lombok.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huwenwen
 * @since 16/09/2018
 */
@RestController
public class TestController {

    @RequestMapping("/ping")
    public String ping() {
        return "pong111";
    }

}
