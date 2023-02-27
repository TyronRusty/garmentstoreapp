package org.perscholas.app.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Entity
@Slf4j
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name="Orders")
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int orderId;
    @NonNull
    int productId;
    @NonNull
    Date orderDate;
    @NonNull
    String orderStatus;
    @NonNull
    double totalPrice;

    @NonNull
    String shippingAddress;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ToString.Exclude
    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();

    @OneToOne(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private Payment payment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && productId == order.productId && Double.compare(order.totalPrice, totalPrice) == 0 && orderDate.equals(order.orderDate) && orderStatus.equals(order.orderStatus) && shippingAddress.equals(order.shippingAddress) && Objects.equals(customer, order.customer) && Objects.equals(orderDetails, order.orderDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId, orderDate, orderStatus, totalPrice, shippingAddress, customer, orderDetails);
    }
}
