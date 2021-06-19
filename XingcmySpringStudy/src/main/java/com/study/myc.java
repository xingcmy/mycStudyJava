package main.java.com.study;

import main.Xingcmy;
import main.java.com.study.noteBean.NoteBean;
import org.junit.Test;

public class myc extends Xingcmy {
    public myc(){
        super("classpath*:xinngcmy-spring-study-note.xml");
    }

    @Test
    public void mycTest(){
        //NoteBean noteBean=super.getBean("noteBean");
    }
}
