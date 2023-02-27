package org.perscholas.app.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Objects;

@AllArgsConstructor
@Entity
@Slf4j
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name="CartItems")
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItem {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cartId;
    @NonNull
    int quantity ;
    @NonNull
    String productName;
    @NonNull
    Date createdAt;
    @NonNull
    int totalPrice;
    @NonNull
    int unitPrice;


    @ToString.Exclude
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return cartId == cartItem.cartId && quantity == cartItem.quantity && totalPrice == cartItem.totalPrice && unitPrice == cartItem.unitPrice && productName.equals(cartItem.productName) && createdAt.equals(cartItem.createdAt) && Objects.equals(product, cartItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, quantity, productName, createdAt, totalPrice, unitPrice, product);
    }
}
