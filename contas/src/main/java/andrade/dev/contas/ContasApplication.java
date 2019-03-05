package andrade.dev.contas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import andrade.dev.contas.config.AppConfig;

@SpringBootApplication
@Import(value = AppConfig.class)
public class ContasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContasApplication.class, args);
	}

}
