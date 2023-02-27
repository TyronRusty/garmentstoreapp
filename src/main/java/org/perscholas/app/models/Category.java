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
@Table(name="Category")
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int CategoryId;
    @NonNull
    String categoryName;
    @NonNull
    String CategoryDescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return CategoryId == category.CategoryId && categoryName.equals(category.categoryName) && CategoryDescription.equals(category.CategoryDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CategoryId, categoryName, CategoryDescription);
    }
}
