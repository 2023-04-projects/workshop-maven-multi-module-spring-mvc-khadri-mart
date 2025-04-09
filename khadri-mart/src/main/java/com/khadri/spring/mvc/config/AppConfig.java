package com.khadri.spring.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.khadri.spring.mvc" })
public class AppConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("main");
		registry.addViewController("/khadri-mart").setViewName("main");
		registry.addViewController("/top").setViewName("top");
		registry.addViewController("/bottom-right").setViewName("bottom-right");
		registry.addViewController("/bottom-left-clo").setViewName("bottom-left-clo");
		registry.addViewController("/bottom-left-gro").setViewName("bottom-left-gro");
		registry.addViewController("/bottom-left-fruits").setViewName("bottom-left-fruits");
		registry.addViewController("/bottom-left-veg").setViewName("bottom-left-veg");
		registry.addViewController("/clothes/add/page").setViewName("clothes-add");
		registry.addViewController("/clothes/search/page").setViewName("clothes-modify-search");
		registry.addViewController("/clothes/delete/page").setViewName("clothes-delete");

	}
}
