package com.boutiqaat.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.boutiqaat.jpa.repo.betterpaging.CustomJpaRepositoryFactoryBean;

@EnableJpaRepositories( repositoryFactoryBeanClass = CustomJpaRepositoryFactoryBean.class)
@SpringBootApplication
public class JpaSpecificationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaSpecificationsApplication.class, args);
	}

}
