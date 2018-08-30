package com.andreitop.xml.config;

import com.andreitop.xml.mount.Mount;
import com.andreitop.xml.mount.Tiger;
import com.andreitop.xml.mount.Wolf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.andreitop.xml")
public class AppConfig {

    Tiger shadowTiger;
    Wolf frostWolf;

    @Bean
    public List<Mount> listOfMounts() {
        List<Mount> mountList = new ArrayList<>();
        mountList.add(shadowTiger);
        mountList.add(frostWolf);
        mountList.add(null);
        return mountList;
    }
}
