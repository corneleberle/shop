package ch.coeb.shop.controller.rest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import ch.coeb.shop.TestShopApplication;
import ch.coeb.shop.dto.ProductDto;
import ch.coeb.shop.model.Product.Fields;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;

@SpringBootTest(
    classes = TestShopApplication.class,
    webEnvironment = WebEnvironment.RANDOM_PORT
)
class RestProductControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  void products() {
    // Given

    // When
    Page<ProductDto> result = this.restTemplate.exchange(
        "http://localhost:" + port + RestProductController.PATH,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<ResponsePage<ProductDto>>() {
        }).getBody();

    // Then
    assertThat(result, hasProperty("content", containsInAnyOrder(
        hasProperty(Fields.name, is("MacBook Pro")),
        hasProperty(Fields.name, is("OnePlus Nord 2")),
        hasProperty(Fields.name, is("Garmin Fenix"))
    )));
  }

}
