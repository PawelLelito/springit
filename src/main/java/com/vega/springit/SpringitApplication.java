package com.vega.springit;

import com.vega.springit.model.Comment;
import com.vega.springit.model.Link;
import com.vega.springit.repository.CommentRepository;
import com.vega.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringitApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
	}

	@Bean
	CommandLineRunner runner (LinkRepository linkRepository, CommentRepository commentRepository){

		return args -> {

			Link link = new Link("Getting Started with Spring Boot 2 ","https://therealdanvega.com/spring-boot-2");
			linkRepository.save(link);

			Comment comment = new Comment("This Sprong Booot 2 is awsome!", link);
			commentRepository.save(comment);

			link.addComment(comment);
		};

	}

}
