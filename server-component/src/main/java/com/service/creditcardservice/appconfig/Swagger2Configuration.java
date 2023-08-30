package com.service.creditcardservice.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration implements WebMvcConfigurer {

    /**
     * Docket Provides sensible defaults and convenience methods for configuration.
     *
     * @return prepared Docket instance
     */
    @Bean
    public Docket api() {

        // Returns the prepared Docket instance
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.service"))
            .paths(PathSelectors.any())
            .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * Method for API Information
     *
     * @return API information
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Banking Service")
            .description("Banking Service REST API Documentation created using Swagger framework. Our REST API are:")
            .version("1.0")
            .build();
    }

}
