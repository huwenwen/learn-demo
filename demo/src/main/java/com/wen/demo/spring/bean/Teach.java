package com.wen.demo.spring.bean;

import org.springframework.stereotype.Component;

@Component
public class Teach {

    static {
        System.out.println("static Teach");
    }

}
