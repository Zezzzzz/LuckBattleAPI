package com.LuckBattle.Webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan("com.LuckBattle.Webservices")
@EntityScan(basePackages={"com.LuckBattle.Webservices.entity"})
public class WebservicesApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WebservicesApplication.class, args);
	}

}
