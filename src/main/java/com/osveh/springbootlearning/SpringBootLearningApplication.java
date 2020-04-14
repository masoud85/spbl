package com.osveh.springbootlearning;

import com.osveh.config.SpringBootLearningConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableConfigurationProperties(SpringBootLearningConfig.class)
public class SpringBootLearningApplication {

    @Autowired
    private SpringBootLearningConfig springBootLearningConfig;

    public static final Logger LOGGER = LoggerFactory.getLogger(SpringBootLearningApplication.class);

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLearningApplication.class, args);
    }

    @Bean
    @Profile("dev")
    CommandLineRunner commandLineRunner() {
        return (args -> System.out.println("message is: " + springBootLearningConfig.getWelcomeMsg()));
    }

}
