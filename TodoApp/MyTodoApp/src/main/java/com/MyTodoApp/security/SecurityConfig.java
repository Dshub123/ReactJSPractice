package com.MyTodoApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.MyTodoApp.security.jwt.JwtAutherizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception
    {
		
        return super.authenticationManagerBean(); 
    }
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		
		http.cors();
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests()
		.antMatchers("/api/authentication/sign-up").permitAll()
		.antMatchers("/api/authentication/sign-in").permitAll()
        .anyRequest()
        .authenticated();
		http.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	public JwtAutherizationFilter jwtAuthorizationFilter()
	{
		return new JwtAutherizationFilter();
	}
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public  WebMvcConfigurer corsConfigurer()
	{
		System.out.println("step-23");
		return new WebMvcConfigurer()
		{
			@Override
			public void addCorsMappings(CorsRegistry  registry)
			{
				registry.addMapping("/**")
				        .allowedOrigins("*")
				        .allowedMethods("*");
				        
			}
		};
	}
	
	
}
