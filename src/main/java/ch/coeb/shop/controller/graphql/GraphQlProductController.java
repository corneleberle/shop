package ch.coeb.shop.controller.graphql;

import ch.coeb.shop.converter.ProductConverter;
import ch.coeb.shop.dto.ProductDto;
import ch.coeb.shop.model.Product;
import ch.coeb.shop.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class GraphQlProductController {

  private final ProductService productService;

  private final ProductConverter productConverter;

  @QueryMapping
  public List<ProductDto> products(@Argument int pageNumber, @Argument int pageSize) {
    PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
    return productService.loadProducts(pageRequest).getContent().stream()
        .map(productConverter::entityToDto)
        .toList();
  }

  @QueryMapping
  public ProductDto productById(@Argument String id) {
    Product product = productService.loadProductById(id);
    return productConverter.entityToDto(product);
  }

}
