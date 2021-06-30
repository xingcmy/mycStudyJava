package com.xingcmy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Application {
    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        Welcome welcome=(Welcome) context.getBean("welcome");
        System.out.println(welcome.toString());
    }
}
