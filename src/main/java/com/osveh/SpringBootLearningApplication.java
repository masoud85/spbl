package com.osveh;

import com.osveh.config.SpringBootLearningConfig;
import org.ocpsoft.prettytime.PrettyTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties(SpringBootLearningConfig.class)
@EnableJpaAuditing
public class SpringBootLearningApplication {

    @Autowired
    private SpringBootLearningConfig springBootLearningConfig;

    public static final Logger LOGGER = LoggerFactory.getLogger(SpringBootLearningApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLearningApplication.class, args);
    }

    @Bean
    public PrettyTime prettyTime() {
        return new PrettyTime();
    }

}
