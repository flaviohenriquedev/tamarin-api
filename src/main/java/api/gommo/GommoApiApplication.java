package api.gommo;

import api.gommo._root.comum.repository.impl.DefaultRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(
		basePackages = "api.gommo",
		repositoryBaseClass = DefaultRepositoryImpl.class
)
public class GommoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GommoApiApplication.class, args);
	}
}
