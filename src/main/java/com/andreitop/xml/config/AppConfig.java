package com.andreitop.xml.config;

import com.andreitop.xml.mount.Mount;
import com.andreitop.xml.mount.Tiger;
import com.andreitop.xml.mount.Wolf;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.andreitop.xml")
public class AppConfig {

    @Bean
    public Tiger shadowTiger() {
        return new Tiger();
    }

    @Bean
    public Wolf frostWolf() {
        return new Wolf();
    }

    @Bean
    public List<Mount> listOfMounts(@Qualifier("shadowTiger") Tiger tiger, @Qualifier("frostWolf") Wolf wolf) {
        List<Mount> mountList = new ArrayList<>();
        mountList.add(tiger);
        mountList.add(wolf);
        mountList.add(null);
        return mountList;
    }
}
