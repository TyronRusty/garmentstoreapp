package org.perscholas.app.dao;

import org.perscholas.app.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepoI extends JpaRepository<Order,Integer> {
}
