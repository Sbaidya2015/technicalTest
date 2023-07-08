package coding.assignment;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Map;
import java.util.Optional;

import static coding.assignment.ApplicationConfig.AUDIT_PROVIDER;

@Configuration
@Log4j2
@EnableJpaAuditing( auditorAwareRef = AUDIT_PROVIDER)
@EnableWebMvc
public class ApplicationConfig{
public static  final String AUDIT_PROVIDER =  "auditProvider";
    @Bean
    @ConfigurationProperties(prefix = "coding.assignment")
    public ApplicationProperties createApplicationProperties(){
        return new ApplicationProperties();
    }

    @Bean(AUDIT_PROVIDER)
    AuditorAware<String> auditorAware()
    {
        return new AuditorAware<String>() {
            @Override
            public Optional<String> getCurrentAuditor() {
                return Optional.of("User");
            }
        };
    }

    @Bean
    public ErrorAttributes creatErrorAttributes(){

        return new DefaultErrorAttributes(){
           public Map<String, Object>  getErrorAttributes(WebRequest webRequest, boolean includeStackTrace){
               Map<String, Object> errorAttribute = super.getErrorAttributes(webRequest,includeStackTrace);
               errorAttribute.put("locale",webRequest.getLocale().toString());
               return errorAttribute;
           }
        };
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }




}
