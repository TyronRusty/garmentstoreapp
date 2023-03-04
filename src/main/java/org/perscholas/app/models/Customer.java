package org.perscholas.app.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


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

    @ToString.Exclude
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private Set<Order> orders = new LinkedHashSet<>();

    public Customer(@NonNull int id, @NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String phone, @NonNull String password, @NonNull String address, @NonNull String city, @NonNull String state, @NonNull int zipCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return zipCode == customer.zipCode && firstName.equals(customer.firstName) && lastName.equals(customer.lastName) && email.equals(customer.email) && phone.equals(customer.phone) && password.equals(customer.password) && address.equals(customer.address) && city.equals(customer.city) && state.equals(customer.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phone, password, address, city, state, zipCode);
    }
}
