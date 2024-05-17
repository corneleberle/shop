package ch.coeb.shop.changeunit;

import ch.coeb.shop.model.Product;
import ch.coeb.shop.repository.ProductRepository;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import java.util.List;
import lombok.RequiredArgsConstructor;

@ChangeUnit(id = "create_products_change_unit", order = "001", author = "mongock")
@RequiredArgsConstructor
public class CreateProductsChangeUnit {

  private final ProductRepository productRepository;

  @Execution
  public void changeSet() {
    productRepository.saveAll(List.of(
        Product.builder()
            .id("product1")
            .name("MacBook Pro")
            .build(),
        Product.builder()
            .id("product2")
            .name("OnePlus Nord 2")
            .build(),
        Product.builder()
            .id("product3")
            .name("Garmin Fenix")
            .build()
    ));
  }

  @RollbackExecution
  public void rollback() {
  }

}
