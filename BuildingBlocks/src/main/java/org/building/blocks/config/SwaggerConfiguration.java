package org.building.blocks.config;

import java.util.Date;

import org.building.blocks.BuildingBlocksApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket swaggerSpringfoxDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).forCodeGeneration(true)
				.genericModelSubstitutes(ResponseEntity.class).ignoredParameterTypes(Pageable.class)
				.ignoredParameterTypes(java.sql.Date.class)
				.directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
				.directModelSubstitute(java.time.LocalDateTime.class, Date.class).useDefaultResponseMessages(false);

		docket = docket.select().apis(RequestHandlerSelectors.basePackage("org.building.blocks.controller"))
				.paths(PathSelectors.any()).build();
		return docket;
	}

	private ApiInfo apiInfo() {
		final String version = BuildingBlocksApplication.class.getPackage().getImplementationVersion();
		ApiInfo apiInfo = new ApiInfoBuilder().title("Building Bricks Service REST API")
				.description("Methods supporting all Building Bricks Service APIs")
				.version(version == null ? "version not available" : version).termsOfServiceUrl("Terms of service")
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").build();
		return apiInfo;
	}
}
