package com.spring.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Value("${swagger.show}")
    private boolean swaggerShow;


    public static final HashSet<String> consumes = new HashSet<String>() {{
        add("application/x-www-form-urlencoded");
    }};


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).enable(this.swaggerShow)
                .groupName("例子")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.spring.order.service"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(getTokenPar()).consumes(Swagger2.consumes);
    }

    /**
     * token认证机制
     *
     * @return List<Parameter>
     */
    public List<Parameter> getTokenPar() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("Authorization")
                .description("认证信息")
                .modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        pars.add(tokenPar.build());
        return pars;
    }

}
