package main;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class Xingcmy {

    private ClassPathXmlApplicationContext context;

    private String springPath;

    public Xingcmy(){}


    public Xingcmy(String springPath){
        this.springPath=springPath;
    }


    @Before
    public void before(){
        if (StringUtils.isEmpty(springPath)){
            springPath="classpath*:xingcmy-spring-study-*.xml";
        }
        try {
            context=new ClassPathXmlApplicationContext(springPath);
            context.start();
        }catch (BeansException e){
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        context.registerShutdownHook();
    }

    @SuppressWarnings("unchecked")
    protected <T extends Object> T getBean(String beanId) {
        try {
            return (T)context.getBean(beanId);
        } catch (BeansException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected <T extends Object> T getBean(Class<T> clazz) {
        try {
            return context.getBean(clazz);
        } catch (BeansException e) {
            e.printStackTrace();
            return null;
        }
    }

}
