package main.java.com.study.AutowireBean;

import main.java.com.interfaceBean.Say;

public class AutowiringServerConstructor implements Say {

    private AutowiringDemo autowiringDemo;


    public AutowiringServerConstructor(AutowiringDemo autowiringDemo){
        System.out.println("constructor");
        this.autowiringDemo=autowiringDemo;
    }

    @Override
    public void say(String name){
        this.autowiringDemo.say(name);
    }
}
