package andrade.dev.contas.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Configuration
@ComponentScan(basePackages = {"andrade.dev.contas.repository", "andrade.dev.contas.controllers", "andrade.dev.contas.services.impl"})
@EnableSpringDataWebSupport
public class AppConfig {

}
