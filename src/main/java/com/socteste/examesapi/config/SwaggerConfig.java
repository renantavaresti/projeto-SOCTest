package com.socteste.examesapi.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration /* Para o Spring saber que é uma classe de configuracao */
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.socteste.examesapi"))
				.paths(PathSelectors.regex("/api.*")).build().apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		@SuppressWarnings("rawtypes")
		ApiInfo apiInfo = new ApiInfo("Exames API REST", "API REST de cadastro de exames.", "1.0", "Terms of Service",
				new Contact("Renan Tavares", "https://www.linkedin.com/in/renan-tavares-787845127",
						"renantavaresti@gmail.com"),
				"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
		return apiInfo;
	}
}
