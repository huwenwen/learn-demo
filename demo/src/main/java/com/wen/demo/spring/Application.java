package com.wen.demo.spring;

import com.wen.demo.spring.bean.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext("com.wen.demo.spring");
        app.getBean(Student.class);
    }
}
