package cl.inicia.dictionary.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("cl.inicia.dictionary.controller")
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{

}
