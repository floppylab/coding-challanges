package codingchallanges.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    ApiInfo mazeApiInfo() {
        return new ApiInfoBuilder()
                .title("coding challanges - maze")
                .description("with this API you can complete the maze")
                .license("")
                .licenseUrl("")
                .version("0.1.0")
                .contact(new Contact("Leonora Der", "http://floppylab.com", "info@floppylab.com"))
                .build();
    }

    /**
     * Maze API Swagger configuration.
     * 
     * @return configuration
     */
    @Bean
    public Docket mazeApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("maze")
                .apiInfo(mazeApiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/mazes/**"))
                .build();
    }

}