package main.java.com.study.AutowireBean;

import main.java.com.interfaceBean.Say;

public class AutowiringServerType implements Say {

    private AutowiringDemo autowiringDemo;

    public void setAutowiringDemo(AutowiringDemo autowiringDemo) {
        System.out.println("Type");
        this.autowiringDemo = autowiringDemo;
    }

    @Override
    public void say(String name){
        this.autowiringDemo.say(name);
    }
}
