package com.xingcmy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Welcome {
    @Setter
    @Getter
    private String welcome;

    public Welcome(){}

    public Welcome(String welcome){
        this.welcome = welcome;
    }

    @Override
    public String toString() {
        return "Welcome{" +
                "welcome='" + welcome + '\'' +
                '}';
    }
}
