package com.cxxwl96.ADAdmin.Swagger.Config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@PropertySource(value = {"classpath:swagger-config.properties"}, encoding = "utf-8")
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger.enable}")
    private Boolean enable;
    @Value("${swagger.pathMapping}")
    private String pathMapping;
    @Value("${swagger.apiInfo.title}")
    private String title;
    @Value("${swagger.apiInfo.description}")
    private String description;
    @Value("${swagger.apiInfo.version}")
    private String version;
    @Value("${swagger.apiInfo.contact.name}")
    private String name;
    @Value("${swagger.apiInfo.contact.url}")
    private String url;
    @Value("${swagger.apiInfo.contact.email}")
    private String email;
    @Value("${swagger.apiInfo.license}")
    private String license;
    @Value("${swagger.apiInfo.licenseUrl}")
    private String licenseUrl;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }
    /**
     * 配置Swagger信息apiInfo
     */
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .contact(new Contact(name, url, email))
                .license(license)
                .licenseUrl(licenseUrl)
                .build();
    }
}
