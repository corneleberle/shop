package ch.coeb.shop.controller.graphql;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import ch.coeb.shop.TestShopApplication;
import ch.coeb.shop.dto.ProductDto;
import ch.coeb.shop.model.Product.Fields;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.graphql.test.tester.GraphQlTester.EntityList;
import org.springframework.graphql.test.tester.HttpGraphQlTester;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(
    classes = TestShopApplication.class,
    webEnvironment = WebEnvironment.RANDOM_PORT
)
class GraphQlProductControllerTest {

  @LocalServerPort
  private int port;

  private GraphQlTester graphQlTester;

  @BeforeEach
  void setUp() {
    WebTestClient client =
        WebTestClient.bindToServer()
            .baseUrl("http://localhost:" + port + "/graphql")
            .build();

    graphQlTester = HttpGraphQlTester.create(client);
  }

  @Test
  void products() {
    // Given

    // When
    EntityList<ProductDto> result = this.graphQlTester
        .documentName("products")
        .execute()
        .path("products")
        .entityList(ProductDto.class);

    // Then
    assertThat(result.get(), Matchers.containsInAnyOrder(
        hasProperty(Fields.name, is("MacBook Pro")),
        hasProperty(Fields.name, is("OnePlus Nord 2"))
    ));
  }

}
