package org.perscholas.app.service;

import org.perscholas.app.dao.ProductRepoI;
import org.perscholas.app.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepoI productRepoI;

    public List<Product> search(String keyword){
        return productRepoI.search(keyword);
    }
}
