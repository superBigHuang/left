package com.huang.left.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * swagger配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {


    @Bean
    public Docket docket(Environment environment) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("huang")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.huang.left.controller"))
                .build();
    }

    // 使用自己的apiInfo
    private ApiInfo apiInfo() {
        Contact contact = new Contact("黄能", "www.baidu.com", "841069102@qq.com");
        return new ApiInfo("huang的swaggerAPI文档",
                "描述",
                "v1.0",
                "#",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
