package za.co.digitalplatoon.communicationservice;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// Spring annotations
@Configuration
// Swagger annotations
@EnableSwagger2
@Import({BeanValidatorPluginsConfiguration.class})
public class SwaggerConfig {

    @Value("${project.version}")
    private String projectVersion;

    @Bean
    public Docket swaggerApi() {
        ApiInfo apiInfo = new ApiInfo(
                "Demo REST API",
                "REST API documentation",
                projectVersion,
                "",
                new Contact("William Gadney", "", "William.Gadney@eoh.com"),
                "Apache License Version 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("za.co.digitalplatoon.communicationservice"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiInfo);
    }
}
