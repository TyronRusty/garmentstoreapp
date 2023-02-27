package org.perscholas.app.dao;

import org.perscholas.app.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepoI extends JpaRepository<Category,Integer> {
}
