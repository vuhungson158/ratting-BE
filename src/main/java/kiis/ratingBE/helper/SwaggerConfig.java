package kiis.ratingBE.helper;

import kiis.ratingBE.RatingBeApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        // securitySchemeList
        final List<SecurityScheme> securitySchemeList = Collections.singletonList(
                new ApiKey("JWT Token", Constant.TOKEN_HEADER, "header")
        );

        // securityContextList
        final List<SecurityReference> securityReferenceList = Collections.singletonList(
                new SecurityReference("JWT Token", new AuthorizationScope[]{
                        new AuthorizationScope("global", "accessEverything")
                })
        );
        final List<SecurityContext> securityContextList = Collections.singletonList(
                SecurityContext.builder().securityReferences(securityReferenceList).build()
        );

        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(securitySchemeList)
                .securityContexts(securityContextList)
                .select()
                .apis(RequestHandlerSelectors.basePackage(RatingBeApplication.class.getPackage().getName()))
                .paths(PathSelectors.any())
                .build();
    }
}
