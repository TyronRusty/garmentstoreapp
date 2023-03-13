package org.perscholas.app;

import org.junit.jupiter.api.Test;
import org.perscholas.app.dao.MyUserRepoI;
import org.perscholas.app.dao.ProductRepoI;
import org.perscholas.app.models.MyUser;
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
    @Autowired
    private MyUserRepoI myUserRepoI;


    @Test
    public void testFindProductById() {
        Product product =productRepoI.findById(32).orElseThrow(null);

        assertNotNull(product);
    }
@Test
public void testGetUserById(){
    MyUser myUser = myUserRepoI.findById(4).get();
    assertNotNull(myUser);
}
}
