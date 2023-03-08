package org.perscholas.app.dao;

import org.perscholas.app.models.MyUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyUserRepoI extends JpaRepository<MyUser,Integer> {
    Optional<MyUser> findByEmailAllIgnoreCase(String email);
    Optional<MyUser> findByPhone(String phone);
    List<MyUser> findByLastNameAllIgnoreCase(String lastName);

}
