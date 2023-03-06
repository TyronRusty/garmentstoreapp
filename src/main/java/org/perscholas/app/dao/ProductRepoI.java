package org.perscholas.app.dao;

import org.perscholas.app.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepoI extends JpaRepository<Product, Integer> {
 Optional<Product> findByproductName(String productName);

 @Override
 List<Product> findAll();
}
