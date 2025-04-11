package com.khadri.spring.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.khadri.spring.mvc" })
@Import(value = { ResourceHandlerWebMvcConfig.class, ViewControllerWebMvcConfig.class,
		ViewResolversWebMvcConfig.class })
public class AppConfig {

}
