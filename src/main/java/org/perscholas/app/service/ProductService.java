package org.perscholas.app.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.app.dao.ProductRepoI;
import org.perscholas.app.dto.ProductDTO;
import org.perscholas.app.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class ProductService {
    @Autowired
    ProductRepoI productRepoI;

    public List<Product> search(String keyword){
        return productRepoI.search(keyword);
    }
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
            log.debug("Product with name " + product.getProductName() + " does not exist!");
            return productRepoI.save(product);
        }
    }

    public void deleteProduct(Integer productId) throws Exception {
        Optional<Product> wantToDelete = productRepoI.findById(productId);
        if (wantToDelete.isPresent()) {
            productRepoI.delete(wantToDelete.get());
        } else {
            throw new Exception("Can't find the product with id " + productId);
        }
    }

    public Product findProductById(int productId) {
return productRepoI.findById(productId).get();

    }



}
