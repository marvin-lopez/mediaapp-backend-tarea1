package com.tarea1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


//http://localhost:8080/swagger-ui.html
//http://localhost:8080/v2/api-docs
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final Contact DEFAULT_CONTACT = new Contact(null,null,null);
    public static final ApiInfo DEFAULT_API_INFO =
            new ApiInfo("API Documentation","Documentación de servicios REST Tarea 1 ",
                    "1.0",null,DEFAULT_CONTACT,null,null,new ArrayList<VendorExtension>());

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
    }
}
