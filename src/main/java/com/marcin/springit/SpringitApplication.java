package com.marcin.springit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringitApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

/*
    @Bean
        //@Profile("dev")
    CommandLineRunner runner() {
        return args -> {
            System.out.println("This is something that we would only do it in dev");
            System.out.println("--------------------------------------------------");
            String[] beans = applicationContext.getBeanDefinitionNames();
            Arrays.sort(beans);
            for(String bean: beans) {
                System.out.println(bean);
            }
            log.error("CommandLineRunner.run();");
            log.warn("CommandLineRunner.run();");
            log.info("CommandLineRunner.run();");
            log.debug("CommandLineRunner.run();");
            log.trace("CommandLineRunner.run();");
        };
    }*/

}
