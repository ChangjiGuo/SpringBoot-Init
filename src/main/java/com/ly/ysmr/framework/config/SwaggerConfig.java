package com.ly.ysmr.framework.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

/**
 * description:
 *
 * @author changji.guo
 * @date 2020/4/26 17:28
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = Lists.newArrayList();
        tokenPar.name("client-secret").description("访问令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.ly.ysmr.framework.controller"))
            .paths(PathSelectors.any())
            .build()
            .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("ysmr restful apis")
            .description("ysmr平台接口文档")
            .termsOfServiceUrl("http://localhost:5270/ysmr/swagger-ui.html")
            .version("1.0")
            .build();
    }
}
