package com.rhanem.frontend.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.List;

@EnableWebMvc
@Configuration
@ComponentScan("com.rhanem.frontend.web")
public class FrontendWebConfig extends WebMvcConfigurerAdapter {

	public FrontendWebConfig() {
		super();
	}

	/**
	 * Registers the existing View Controllers for the application
	 */
	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		super.addViewControllers(registry);
/*
		registry.addViewController("/login.html");
		registry.addViewController("/register.html");
		registry.addViewController("/authenticated.html");

		registry.addViewController("/admin/users.html");
		registry.addViewController("/admin/dev_only.html");
		registry.addViewController("/admin/full_auth_only.html");

		registry.addViewController("/demande-list.html");
		registry.addViewController("/add-demande.html");
		registry.addViewController("/edit-demande.html");
		registry.addViewController("/dashboard.html");
		registry.addViewController("/404.html");
		registry.addViewController("/verification-list.html");
		registry.addViewController("/add-verification.html");
		registry.addViewController("/edit-verification.html");
		registry.addViewController("/list-users.html");
		registry.addViewController("/add-users.html");
		registry.addViewController("/edit-user.html");
		registry.addViewController("/testrestauration-list.html");
		registry.addViewController("/add-testrestauration.html");
		registry.addViewController("/edit-testrestauration.html");
		registry.addViewController("/add-sauvegarde.html");
		registry.addViewController("/list-Sauvegardetrim.html");
		registry.addViewController("/user-profile.html");
		registry.addViewController("/sauvegarde.html");
		registry.addViewController("/add-Admin.html");
		registry.addViewController("/allsauvegardelist.html");
*/

	}

	/**
	 * Register the {@link JstlView} ViewResolver that will be used by spring
	 * mvc and configure it.
	 * 
	 * @return a new instance of a {@link ViewResolver}
	 */
	@Bean
	public ViewResolver viewResolver() {
		final InternalResourceViewResolver bean = new InternalResourceViewResolver();

		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/view/");
		bean.setSuffix(".jsp");
		bean.setExposedContextBeanNames(new String[] { "properties" });

		return bean;
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(300000);
		return multipartResolver;
	}



	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/image/**","/assets/**").addResourceLocations(
				"/image/","/assets/");
	}

}
