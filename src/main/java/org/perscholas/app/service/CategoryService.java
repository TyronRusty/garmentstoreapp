package org.perscholas.app.service;

import org.perscholas.app.dao.CategoryRepoI;
import org.perscholas.app.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    CategoryRepoI categoryRepoI;
@Autowired
public CategoryService(CategoryRepoI categoryRepoI) {
        this.categoryRepoI = categoryRepoI;
    }
}
