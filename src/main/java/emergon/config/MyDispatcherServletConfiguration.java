package emergon.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// Αντικαθιστώ τον Dispatcher-Servlet.xml με αυτήν την κλάση.

//this is a spring configuration class
@Configuration

// <mvc:annotation-driven/>
// Our application will contain Annotations in some classes. So take them into account
@EnableWebMvc

// 
// start scanning from base package emergon to find classes with Annotations
@ComponentScan(basePackages = "emergon")                                         

public class MyDispatcherServletConfiguration implements WebMvcConfigurer{
 
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        
        // Είναι αντικείμενο για τον ViewResolver.
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }

    // Εδώ θα βάλω τα resourses μου.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
    
    
}
