package org.perscholas.app.dao;

import org.perscholas.app.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepoI extends JpaRepository<Product, Integer> {
}
