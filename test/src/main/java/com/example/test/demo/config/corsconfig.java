package com.example.test.demo.config;

import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



//配置跨域
@Configuration
public class corsconfig {
    private CorsConfiguration buildConfig() {
    	CorsConfiguration corsConfiguration = new CorsConfiguration();
    	corsConfiguration.addAllowedOrigin("*");
    	corsConfiguration.addAllowedHeader("*");
    	corsConfiguration.addAllowedMethod("*");
    	return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter(){
    	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	source.registerCorsConfiguration("/**", buildConfig());
    	return new CorsFilter(source);
    }
}
