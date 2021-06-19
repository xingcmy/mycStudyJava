package main.java.com;

import main.Xingcmy;
import main.java.Demo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class SpringStudy extends Xingcmy {

    public SpringStudy(){
        super("classpath:xingcmy-spring-study.xml");
    }

    @Test
    public void start(){
        Demo demo=super.getBean("demo");
        demo.add();
    }


}
