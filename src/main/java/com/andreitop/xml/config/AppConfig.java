package com.andreitop.xml.config;

import com.andreitop.xml.mount.Mount;
import com.andreitop.xml.mount.Tiger;
import com.andreitop.xml.mount.Wolf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Configuration
@ComponentScan(basePackages = "com.andreitop.xml")
@PropertySource("config/heroes.properties")
public class AppConfig {

    @Autowired
    Environment environment;

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

    @Bean
    public Map<String, Mount> mapOfMounts(@Qualifier("shadowTiger") Tiger tiger, @Qualifier("frostWolf") Wolf wolf) {
        Map<String, Mount> mountMap = new HashMap<>();
        mountMap.put("m1", wolf);
        mountMap.put("m2", tiger);
        return mountMap;
    }

    @Bean
    public Date creationDate() throws Exception {
        String stringDate = environment.getProperty("character.created");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.parse(stringDate);
    }

    @Bean
    public int colorCode() {
        return java.util.concurrent.ThreadLocalRandom.current().nextInt(1, 10);
    }
}
