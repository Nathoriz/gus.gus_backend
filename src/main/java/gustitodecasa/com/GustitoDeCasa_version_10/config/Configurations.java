package gustitodecasa.com.GustitoDeCasa_version_10.config;

import gustitodecasa.com.GustitoDeCasa_version_10.custom.CustomPasswordEncoder;
import gustitodecasa.com.GustitoDeCasa_version_10.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebSecurity
public class Configurations extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider( daoAuthenticationProvider() );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/**")
                .permitAll();
    }

    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder( customPasswordEncoder() );
        daoAuthenticationProvider.setUserDetailsService( usuarioService );
        return daoAuthenticationProvider;
    }

    @Bean
    public CustomPasswordEncoder customPasswordEncoder(){
        return new CustomPasswordEncoder();
    }

    @Bean //Swagger
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("gustitodecasa.com.GustitoDeCasa_version_10.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean //Cors Global
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings( CorsRegistry registry ) {
                registry
                        .addMapping("/**")  //access Controller global
                        .allowedOrigins( "*" )    //access a ruta del client(frontend)
                        .allowedMethods( "GET", "POST", "PUT", "PATCH" )  //access a los methods
                ;
            }
        };
    }


}
