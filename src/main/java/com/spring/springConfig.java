package com.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@EnableWebMvc
@ComponentScan("com")
@PropertySources({ //
        @PropertySource(value = "file:./spring.properties", ignoreResourceNotFound = true) //
})
public class springConfig {
}
