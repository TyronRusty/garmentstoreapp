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
@Table(name="users")
@Setter @Getter @ToString @EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyUser {
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
    @OneToMany(mappedBy = "myUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private Set<Order> orders = new LinkedHashSet<>();

    public MyUser(@NonNull int id, @NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String phone, @NonNull String password, @NonNull String address, @NonNull String city, @NonNull String state, @NonNull int zipCode) {
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

    public MyUser(@NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public MyUser(@NonNull int id, @NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyUser myUser = (MyUser) o;
        return zipCode == myUser.zipCode && firstName.equals(myUser.firstName) && lastName.equals(myUser.lastName) && email.equals(myUser.email) && phone.equals(myUser.phone) && password.equals(myUser.password) && address.equals(myUser.address) && city.equals(myUser.city) && state.equals(myUser.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phone, password, address, city, state, zipCode);
    }
}
