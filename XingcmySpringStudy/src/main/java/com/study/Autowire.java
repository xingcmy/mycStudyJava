package main.java.com.study;

import main.Xingcmy;
import main.java.com.study.AutowireBean.AutowiringServerConstructor;
import main.java.com.study.AutowireBean.AutowiringServerName;
import main.java.com.study.AutowireBean.AutowiringServerType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class Autowire extends Xingcmy {

    public Autowire(){
        super("classpath:xingcmy-spring-study-autowire.xml");
    }

    @Test
    public void TestByName(){
        AutowiringServerName autowiringServer=super.getBean("autowiringServerName");
        autowiringServer.say("ByName");
    }

    @Test
    public void TestByType(){
        AutowiringServerType autowiringServerType=super.getBean("autowiringServerType");
        autowiringServerType.say("ByType");
    }

    @Test
    public void TestConstructor(){
        AutowiringServerConstructor autowiringServerConstructor=super.getBean("autowiringServerConstructor");
        autowiringServerConstructor.say("Constructor");
    }
}
