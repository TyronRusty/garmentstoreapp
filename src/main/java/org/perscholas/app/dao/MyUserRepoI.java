package org.perscholas.app.dao;

import org.perscholas.app.models.MyUser;

import org.perscholas.app.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyUserRepoI extends JpaRepository<MyUser,Integer> {
    Optional<MyUser> findByEmailAllIgnoreCase(String email);
    Optional<MyUser> findByEmail(String name);
    Optional<MyUser> findByPhone(String phone);
    Optional<MyUser>findById(int id);
    List<MyUser> findByLastNameAllIgnoreCase(String lastName);

}
