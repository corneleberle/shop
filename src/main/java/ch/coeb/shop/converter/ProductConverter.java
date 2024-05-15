package ch.coeb.shop.converter;

import ch.coeb.shop.dto.ProductDto;
import ch.coeb.shop.model.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductConverter {

  ProductDto entityToDto(Product car);

}
