package main.java.com.study.noteBean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@Configuration
@Component
@ImportResource("classpath:myc.xml")
public class Note {

    @Value("${myc.name}")
    private String name;

    @Value("${myc.password}")
    private String password;

    @Value("${myc.url}")
    private String url;

    @Bean(name = "mycBean")
    public NoteBean noteBean(){
        return new NoteBean(name,password,url);
    }
}
