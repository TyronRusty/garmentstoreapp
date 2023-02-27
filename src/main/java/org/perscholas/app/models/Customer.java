package org.perscholas.app.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Entity
@Slf4j
@NoArgsConstructor
@Table(name="Customers")
@Setter @Getter @ToString @EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NonNull
    String firstName;
    @NonNull
    String lastName;
    @NonNull
    String email;
    @NonNull
    String phone;
    @NonNull
    String password;
    @NonNull
    String address;
    @NonNull
    String city;
    @NonNull
    String state;
    @NonNull
    int zipCode;
    @NonNull
    String country;


    @ToString.Exclude
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private Set<Order> orders = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && zipCode == customer.zipCode && firstName.equals(customer.firstName) && lastName.equals(customer.lastName) && email.equals(customer.email) && phone.equals(customer.phone) && password.equals(customer.password) && address.equals(customer.address) && city.equals(customer.city) && state.equals(customer.state) && country.equals(customer.country) && Objects.equals(orders, customer.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phone, password, address, city, state, zipCode, country, orders);
    }
}
