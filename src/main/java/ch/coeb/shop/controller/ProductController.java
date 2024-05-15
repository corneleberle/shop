package ch.coeb.shop.controller;

import ch.coeb.shop.converter.ProductConverter;
import ch.coeb.shop.dto.ProductDto;
import ch.coeb.shop.model.Product;
import ch.coeb.shop.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  private final ProductConverter productConverter;

  @GetMapping
  public Page<ProductDto> getProducts(@PageableDefault Pageable pageable) {
    Page<Product> productPage = productService.loadProducts(pageable);
    return new PageImpl<>(convert(productPage.getContent()), productPage.getPageable(),
        productPage.getTotalElements());
  }

  private List<ProductDto> convert(List<Product> products) {
    return products.stream()
        .map(this::convert)
        .toList();
  }

  private ProductDto convert(Product product) {
    return productConverter.entityToDto(product);
  }

}
