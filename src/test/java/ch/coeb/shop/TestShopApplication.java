package ch.coeb.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestShopApplication {

	@Bean
	@ServiceConnection
	MongoDBContainer mongoDbContainer() {
		return new MongoDBContainer(DockerImageName.parse("mongo:7"));
	}

	public static void main(String[] args) {
		SpringApplication.from(ShopApplication::main).with(TestShopApplication.class).run(args);
	}

	@Bean
	WebTestClient webTestClient() {
		return WebTestClient.bindToServer()
				.baseUrl("http://localhost:8080/graphql")
				.build();
	}

}
