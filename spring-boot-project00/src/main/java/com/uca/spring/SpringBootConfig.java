package com.uca.spring;

import java.util.concurrent.TimeUnit; 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@ComponentScan
@SpringBootApplication
public class SpringBootConfig extends SpringBootServletInitializer{
	
	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	     return application.sources(SpringBootConfig.class);
	  }
	
  public static void main(String[] args) {
    SpringApplication.run(SpringBootConfig.class, args);
  }
  
  
  
}
