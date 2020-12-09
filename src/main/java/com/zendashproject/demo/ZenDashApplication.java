package com.zendashproject.demo;

import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;


@SpringBootApplication
public class ZenDashApplication {

	public static void main ( String[] args ) {
		SpringApplication.run ( ZenDashApplication.class , args );
	}

	@Bean
	RestTemplate restTemplate (RestTemplateBuilder builder ) {
		return builder.build ();
	}

	@Bean
	public SpringSecurityDialect securityDialect ( ) {
		return new SpringSecurityDialect ();
	}

	@Configuration
	public static class ServerConfig {
		@Bean
		public ConfigurableServletWebServerFactory webServerFactory ( ) {
			TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory ();
			factory.addErrorPages ( new ErrorPage( HttpStatus.FORBIDDEN , "/403" ) );
			return factory;
		}
	}


	@Bean
	PolicyFactory getUserHtmlPolicy ( ) {
		return new HtmlPolicyBuilder().allowCommonBlockElements ().allowCommonInlineFormattingElements ().toFactory ();
	}
}

