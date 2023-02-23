package org.perscholas.app.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
@AllArgsConstructor
@Entity
@Slf4j
@NoArgsConstructor
@Table(name="Customers")
@Setter @Getter @ToString @EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String firstName;
    String lastName;
    String email;
    String phone;
    String password;

    String address;
    String city;
    String state;
    Integer zipCode;
    String country;




}
