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
@Table(name="Payment")
@Setter
@Getter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    int id;

    @NonNull
    String paymentMethod;

    @NonNull
    String bank ;
    @NonNull
    Date payementDate;

    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    @JoinColumn(name = "payment")
    private Order order;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id && paymentMethod.equals(payment.paymentMethod) && bank.equals(payment.bank) && payementDate.equals(payment.payementDate) && Objects.equals(order, payment.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentMethod, bank, payementDate, order);
    }
}
