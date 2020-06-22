package kr.or.connect.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"kr.or.connect.reservation"})
@Import({DBConfig.class})
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
}
