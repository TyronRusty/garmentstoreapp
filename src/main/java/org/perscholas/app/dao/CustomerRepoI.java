package org.perscholas.app.dao;

import org.perscholas.app.models.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepoI extends JpaRepository<Customer,Integer> {
}
