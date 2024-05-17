package ch.coeb.shop;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import ch.coeb.shop.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
    classes = TestShopApplication.class
)
class ShopApplicationTests {

  @Autowired
  private ProductController productController;

  @Test
  void contextLoads() {
    assertThat(productController, notNullValue());
  }

}
