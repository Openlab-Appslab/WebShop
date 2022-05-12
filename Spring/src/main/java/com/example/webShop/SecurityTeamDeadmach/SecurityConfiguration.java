/*
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
*/

package com.example.webShop.SecurityTeamDeadmach;

import com.example.webShop.InformationPage.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
      }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers(HttpMethod.GET, "/lastThree").permitAll()
                .antMatchers(HttpMethod.POST, "/ideal").permitAll()
                .antMatchers(HttpMethod.POST, "/productsDetail").permitAll()
                .antMatchers(HttpMethod.GET, "/getIdeal").permitAll()
                .antMatchers(HttpMethod.POST, "/saveInfoAboutSport").permitAll()
                .antMatchers(HttpMethod.GET, "/infoAboutSport").permitAll()
                .antMatchers(HttpMethod.POST,"/deleteProduct").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/getStars").permitAll()
                .antMatchers(HttpMethod.POST, "/addNewRating").permitAll()
                .antMatchers(HttpMethod.POST, "/addComplaint").permitAll()
                .antMatchers(HttpMethod.GET,"/feedback").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/deleteComplaint").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/products").permitAll()
                .antMatchers(HttpMethod.POST, "/products").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("*")
                        .allowCredentials(true);
            }

        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
