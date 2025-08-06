package Wiprospringframework;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "Wiprospringframework")

@PropertySource("classpath:datafile.properties")

public class AppConfig {

}
