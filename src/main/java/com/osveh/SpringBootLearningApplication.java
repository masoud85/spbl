package com.osveh;

import com.osveh.config.SpringBootLearningConfig;
import com.osveh.domain.Comment;
import com.osveh.domain.Link;
import com.osveh.repository.CommentRepository;
import com.osveh.repository.LinkRepository;
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
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
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

//    @Bean
    @Profile("dev")
    CommandLineRunner commandLineRunner(LinkRepository linkRepository, CommentRepository commentRepository) {
        return (args -> {
            Link link = new Link("Getting started with spring boot 2", "https://spring.io/projects/spring-boot");
            linkRepository.save(link);

            Comment comment = new Comment("This spring boot 2 link is awesome", link);
            commentRepository.save(comment);
            link.addComment(comment);
        });
    }

}
