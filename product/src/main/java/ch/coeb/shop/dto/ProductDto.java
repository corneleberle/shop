package ch.coeb.shop.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ProductDto {

  String id;

  String name;

}
