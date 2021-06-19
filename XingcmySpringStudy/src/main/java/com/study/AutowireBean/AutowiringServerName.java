package main.java.com.study.AutowireBean;

import main.java.com.interfaceBean.Say;

public class AutowiringServerName implements Say {
    private AutowiringDemo autowiringDemo;

    public void setAutowiringDemo(AutowiringDemo autowiringDemo) {
        System.out.println("Name");
        this.autowiringDemo = autowiringDemo;
    }

    @Override
    public void say(String name){
        this.autowiringDemo.say(name);
    }
}
