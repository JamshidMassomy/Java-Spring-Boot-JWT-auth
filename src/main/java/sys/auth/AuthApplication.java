package sys.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import sys.auth.configuration.*;

@SpringBootApplication
@Import({
		SwaggerConfig.class
		,CROSconfig.class
		,AppConfig.class
		,ContentNegotiationConfig.class
		,SecurityConfig.class
})
@ComponentScan({"sys.auth.controller","sys.auth.services","sys.auth.configuration","sys.auth.entities","sys.auth.repository","sys.auth.security"})
@EntityScan("sys.auth.entities")
@EnableJpaRepositories(basePackages = "sys.auth.repository")

public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
		//System.out.print("hello");
	}

}
