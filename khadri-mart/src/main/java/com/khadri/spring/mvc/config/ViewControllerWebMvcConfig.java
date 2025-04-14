package com.khadri.spring.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ViewControllerWebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("main");
		registry.addViewController("/top").setViewName("top");
		registry.addViewController("/bottom-right").setViewName("bottom-right");
		registry.addViewController("/bottom-left-clo").setViewName("bottom-left-clo");
		registry.addViewController("/bottom-left-gro").setViewName("bottom-left-gro");
		registry.addViewController("/bottom-left-fruits").setViewName("bottom-left-fruits");
		registry.addViewController("/bottom-left-veg").setViewName("bottom-left-veg");
		registry.addViewController("/grosary/add/page").setViewName("grosary-add");
		registry.addViewController("/grosary/modify/page").setViewName("grosary-modify-search");
		registry.addViewController("/grosary/delete/page").setViewName("grosary-delete");
		registry.addViewController("/veg/add/page").setViewName("veg-add");
		registry.addViewController("/veg/search/page").setViewName("veg-modify-search");
		registry.addViewController("/veg/delete/page").setViewName("veg-delete");
	}
}
