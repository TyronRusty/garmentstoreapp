package org.perscholas.app.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {


    int productId;

    String productName;

    double productPrice;

    String productSize;

    String productColor;




    int productQuantity;


    String productDescription;

}
