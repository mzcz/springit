package com.marcin.springit;

import com.marcin.springit.domain.Comment;
import com.marcin.springit.domain.Link;
import com.marcin.springit.repository.CommentRepository;
import com.marcin.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }


    @Bean
        //@Profile("dev")
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {
            Link link = new Link("Getting started with spring boot 2","https://docs.spring.io/spring-boot/docs/current/reference/html/index.html");
            linkRepository.save(link);

            Comment comment = new Comment("This Sprnng boot 2 link is ....", link);
            commentRepository.save(comment);
            link.addComment(comment);

            System.out.println("We just inserted link and comment");
            System.out.println("----------------------------------");
        };
    }

}
