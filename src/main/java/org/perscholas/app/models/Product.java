package org.perscholas.app.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Entity
@Slf4j
@Table(name="Products")
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int productId;
    String productName;
    double productPrice;
    String productSize;
    String productColor;
    String productSKU;
    String productCategoryId;
    int productQuantity;
    int inventoryId;
    String productDescription;

}
