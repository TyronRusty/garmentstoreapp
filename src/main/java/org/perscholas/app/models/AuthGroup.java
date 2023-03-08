package org.perscholas.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NonNull
    String email;

    @NonNull
    String role;
}
