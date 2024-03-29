//package com.springsecurity.api.security;
//
//import com.springsecurity.api.exception.MyAccessDeniedHandler;
//import com.springsecurity.api.models.ERole;
//import com.springsecurity.api.security.jwt.AuthEntryPointJwt;
//import com.springsecurity.api.security.jwt.AuthTokenFilter;
//import com.springsecurity.api.security.services.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfigSave extends WebSecurityConfigurerAdapter {
//    
//    @Autowired
//    UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    private AuthEntryPointJwt unauthorizedHandler;
//
//    @Bean
//    public AuthTokenFilter authenticationJwtTokenFilter() {
//        return new AuthTokenFilter();
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public AccessDeniedHandler accessDeniedHandler(){
//        return new MyAccessDeniedHandler();
//    }
//    
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable()
//                .exceptionHandling().accessDeniedHandler(accessDeniedHandler()).authenticationEntryPoint(unauthorizedHandler).and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                //.authorizeRequests().antMatchers("/api/admin/**").hasAnyAuthority(ERole.MODERATOR.name(), ERole.ADMIN.name()).and()
//                .authorizeRequests().antMatchers("/api/admin/**").hasAnyAuthority(ERole.MODERATOR.name(), ERole.ADMIN.name()).and()
//                .authorizeRequests().antMatchers("/api/pets/**").hasAnyAuthority(ERole.MODERATOR.name(), ERole.ADMIN.name(), ERole.USER.name()).and()
//                .authorizeRequests().antMatchers("/api/roles/**").hasAnyAuthority(ERole.MODERATOR.name(), ERole.ADMIN.name(), ERole.USER.name()).and()
//                .authorizeRequests().antMatchers("GET", "/api/roles/**").permitAll().and()
//                .authorizeRequests().antMatchers("/api/message/**").anonymous().and()
//                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
//                .antMatchers("/api/test/**").permitAll()
//                .anyRequest().authenticated();
//
//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//    }
//    
//}
