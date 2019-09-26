package com.wen.demo.spring.bean;

import lombok.Data;

@Data
public class Student {
    private Long id;
    private String name;

    static {
        System.out.println("static Student");
    }
}
