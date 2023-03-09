package org.perscholas.app.dao;

import org.perscholas.app.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepoI extends JpaRepository<Product, Integer> {
 Optional<Product> findByproductName(String productName);
Optional<Product>findByProductId(int productId);
 @Query(value ="SELECT * FROM products WHERE "+"MATCH(product_name,product_description,product_color)"+"AGAINST(?1)"
         ,nativeQuery = true)
 public List<Product> search (String keyword);
}
