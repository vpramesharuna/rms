package restpick;

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
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())             
          .paths(PathSelectors.any())                          
          .build();                                           
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringMVC Dynamic Service API")
                .description("SpringMVC Dynamic Service API reference for developers")
                .termsOfServiceUrl("http://techmahindra.com")
                .contact(new Contact("Anees Ahmed", "techmahindra.com", "am00514047@techmahindra.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("2.0")
                .build();
    }
    
}
