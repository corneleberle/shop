package ch.coeb.shop.service;

import ch.coeb.shop.model.Product;
import ch.coeb.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public Page<Product> loadProducts(Pageable pageable) {
    return productRepository.findAll(pageable);
  }

}
