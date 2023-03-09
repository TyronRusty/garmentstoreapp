package org.perscholas.app;

import org.junit.jupiter.api.Test;
import org.perscholas.app.dao.ProductRepoI;
import org.perscholas.app.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepoTest {

    @Autowired
    private ProductRepoI productRepoI;




    @Test
    public void testFindProductById() {
        Product product =productRepoI.findById(32).orElseThrow(null);

        assertNotNull(product);
    }


}
