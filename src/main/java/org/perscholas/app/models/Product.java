package org.perscholas.app.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

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
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int productId;
    @NonNull
    String productName;
    @NonNull
    double productPrice;
    @NonNull
    String productSize;
    @NonNull
    String productColor;
    @NonNull
    String productSKU;


    @NonNull
    int productQuantity;

    @NonNull
    String productDescription;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<CartItem> cartItems = new LinkedHashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private List<OrderDetail> orderDetails = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Double.compare(product.productPrice, productPrice) == 0 && productQuantity == product.productQuantity  && productName.equals(product.productName) && productSize.equals(product.productSize) && productColor.equals(product.productColor) && productSKU.equals(product.productSKU) && productDescription.equals(product.productDescription) && Objects.equals(category, product.category) && Objects.equals(cartItems, product.cartItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productPrice, productSize, productColor, productSKU, productQuantity, productDescription, category, cartItems);
    }
}
