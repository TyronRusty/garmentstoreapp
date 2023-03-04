package org.perscholas.app.dao;

import org.perscholas.app.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepoI extends JpaRepository<CartItem, Integer> {
}
