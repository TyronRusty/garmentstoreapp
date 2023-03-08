package org.perscholas.app.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@AllArgsConstructor
@Slf4j
@NoArgsConstructor
@Table(name="users")
@Getter @ToString @EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyUser {
    @Id
    @NonNull
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NonNull
    @NotBlank( message = "can't be blank")
    String firstName;
    @NonNull
    String lastName;
    @NonNull
    @Email( message = "can't be blank")
    @Column(unique = true)
    String email;
    @NonNull
    String phone;

    @NonNull
    String address;
    @NonNull
    String city;
    @NonNull
    String state;
    @NonNull
    int zipCode;
    @Setter(AccessLevel.NONE)
    @NonNull @NotBlank(message = "can't be blank") @Size(min=3, message = "not less than 3 characters")
    String password;
    public String setPassword(String password) {
        return this.password = new BCryptPasswordEncoder().encode(password);
    }
    @ToString.Exclude
    @OneToMany(mappedBy = "myUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private Set<Order> orders = new LinkedHashSet<>();

    public MyUser(@NonNull int id, @NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String phone, @NonNull String password, @NonNull String address, @NonNull String city, @NonNull String state, @NonNull int zipCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password =  setPassword(password);
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public MyUser(@NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password =  setPassword(password);
    }

    public MyUser(@NonNull int id, @NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password =  setPassword(password);
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
