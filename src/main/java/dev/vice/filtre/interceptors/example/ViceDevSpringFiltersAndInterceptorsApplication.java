package dev.vice.filtre.interceptors.example;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@SpringBootApplication
public class ViceDevSpringFiltersAndInterceptorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViceDevSpringFiltersAndInterceptorsApplication.class, args);
	}
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@EventListener
	public void readKeys(ApplicationStartedEvent event) throws IOException {
		Resource res = resourceLoader.getResource("classpath:keys/key.txt");
		System.out.println(new String(res.getInputStream().readAllBytes()));
	}

}
