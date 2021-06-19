package main.java;

import main.java.com.SpringInterface;
import main.java.com.interfaceBean.StartStop;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.sql.Statement;

/**
 * InitializingBean Bean初始化
 * DisposableBean Bean销毁
 */

public class Demo implements SpringInterface, InitializingBean, DisposableBean, StartStop {
    @Override
    public void add() {
        System.out.println("xingcmy");
    }

    public void start(){

    }

    public void stop(){

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void destroy() throws Exception {

    }
}
