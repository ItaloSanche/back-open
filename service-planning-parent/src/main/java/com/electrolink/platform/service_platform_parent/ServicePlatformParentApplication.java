package com.electrolink.platform.service_platform_parent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ServicePlatformParentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicePlatformParentApplication.class, args);
	}

}
