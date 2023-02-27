package org.perscholas.app.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@AllArgsConstructor
@Entity
@Slf4j
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name="OrderDetail")
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetail {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int OrderDetailId ;
    @NonNull
    int quantity ;
    @NonNull
    double totalPrice;
    @NonNull
    double unitPrice;

    @NonNull
    int orderId;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "orders_id")
    private Order order;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "product_id")
    private Product product;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return OrderDetailId == that.OrderDetailId && quantity == that.quantity && Double.compare(that.totalPrice, totalPrice) == 0 && Double.compare(that.unitPrice, unitPrice) == 0  && orderId == that.orderId && Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(OrderDetailId, quantity, totalPrice, unitPrice, orderId, order);
    }
}
