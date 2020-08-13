package com.jojoldu.book.springboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("v1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jojoldu.book.springboot")) //API문서를 만들어줄 범위를 지정한다
                .paths(PathSelectors.any()) // API의 URL경로를 지정할 수 있다 .paths(PathSelectors.ant("/api/v1/**")) 와 같이 하면 http://localhost:8080/api/v1/ 하위 경로를 가지는 API에 대해 문서를 생성해준다
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("제목 작성")
                .version("버전 작성")
                .description("설명 작정")
                .license("라이센스 작성")
                .licenseUrl("라이센스 URL작성")
                .build();
    }

}
