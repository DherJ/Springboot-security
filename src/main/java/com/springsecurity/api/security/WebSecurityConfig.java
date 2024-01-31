package com.springsecurity.api.security;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import com.springsecurity.api.exception.MyAccessDeniedHandler;
import com.springsecurity.api.models.ERole;
import com.springsecurity.api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@EnableJpaRepositories("com.springsecurity.api.repository")
@EntityScan("com.springsecurity.api.models")
public class WebSecurityConfig implements WebMvcConfigurer {
    
    @Autowired
    UserService userService;

    @Autowired
    private JwtAuthentificationFilter jwtAuthentificationFilter;

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new MyAccessDeniedHandler();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*");
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
		        .authorizeHttpRequests((authorize) -> authorize
		        		.requestMatchers("/api/admin/**").hasAnyAuthority(ERole.MODERATOR.name(), ERole.ADMIN.name())
		        		.requestMatchers("/api/pets/**").hasAnyAuthority(ERole.MODERATOR.name(), ERole.ADMIN.name(), ERole.USER.name())
		        		.requestMatchers("/api/roles/**").hasAnyAuthority(ERole.MODERATOR.name(), ERole.ADMIN.name(), ERole.USER.name())
		        		.requestMatchers("GET", "/api/roles/**").permitAll()
		        		.requestMatchers("/api/message/**").anonymous()
		        		.requestMatchers("/api/auth/**").permitAll()
		        		.requestMatchers("/api/test/**").permitAll()
		        		.anyRequest().authenticated()
		    		)
		        .sessionManagement(manager -> manager.sessionCreationPolicy(STATELESS))
		        .authenticationProvider(authenticationProvider()).addFilterBefore(
                        jwtAuthentificationFilter, UsernamePasswordAuthenticationFilter.class);
                //.exceptionHandling().accessDeniedHandler(accessDeniedHandler()).authenticationEntryPoint(unauthorizedHandler);

        //http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService.userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }
    
}
