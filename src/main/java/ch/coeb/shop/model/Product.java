package ch.coeb.shop.model;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@Builder(toBuilder = true)
@FieldNameConstants
@Jacksonized
@Document
public class Product {

  @Id
  String id;

  String name;

}
