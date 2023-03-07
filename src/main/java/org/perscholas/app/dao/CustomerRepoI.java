package org.perscholas.app.dao;

import org.perscholas.app.models.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepoI extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByEmailAllIgnoreCase(String email);
    Optional<Customer> findByPhone(String phone);
    List<Customer> findByLastNameAllIgnoreCase(String lastName);

}
