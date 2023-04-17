package com.manager.systems.api.core.springdoc;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class SpringDocConfig {

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info().title("MANAGER SYSTEMS API").version("v1").description("API de teste técnico")
						.license(new License().name("Apache 2.0").url("http://springdoc.com")))
				.externalDocs(new ExternalDocumentation().description("Manager Systemns").url(""))
				.tags(Arrays.asList(new Tag().name("Usuario").description("Gerencia os usuarios"),
						new Tag().name("Pais").description("Gerencia os paises")));
	}

}
