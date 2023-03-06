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


    public List<Product>ListAll(){

        return (List<Product>) productRepoI.findAll();
    }

    public Product createOrUpdate(Product product) {
        if (productRepoI.findByproductName(product.getProductName()).isPresent()) {
            Product originalProduct = productRepoI.findByproductName(product.getProductName()).get();
            originalProduct.setProductPrice(product.getProductPrice());
            originalProduct.setProductSize(product.getProductSize());
            originalProduct.setProductColor(product.getProductColor());
            originalProduct.setProductQuantity(product.getProductQuantity());
            originalProduct.setProductDescription(product.getProductDescription());

            return productRepoI.save(originalProduct);
        } else {
           // log.debug("Product with name " + product.getProductName() + " does not exist!");
            return productRepoI.save(product);
        }
    }

}
