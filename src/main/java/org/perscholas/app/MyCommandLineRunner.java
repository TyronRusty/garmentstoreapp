package org.perscholas.app;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.app.dao.CustomerRepoI;
import org.perscholas.app.dao.ProductRepoI;
import org.perscholas.app.models.Customer;
import org.perscholas.app.models.Product;
import org.perscholas.app.service.ImageService;
import org.perscholas.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j

public class MyCommandLineRunner implements CommandLineRunner {

    CustomerRepoI customerRepoI;
    ProductRepoI productRepoI;
    ProductService productService;
    ImageService imageService;
    @Autowired
    public MyCommandLineRunner(CustomerRepoI customerRepoI, ProductRepoI productRepoI, ProductService productService, ImageService imageService) {
        this.customerRepoI = customerRepoI;
        this.productRepoI = productRepoI;
        this.productService = productService;
        this.imageService = imageService;
    }



    @Override
    public void run(String... args) throws Exception {


        imageService.init();

        Product product3 = new Product( "White t-shirt", 40.00, "L", "White", "TWL-1236", 50, "white t-shirt 100% cotton.");
        Product product5 = new Product("Beige t-shirt", 40.00, "L", "Beige", "TBGS-2234", 50, "beige t-shirt 100% cotton");
        Product product9 = new Product("Gray t-shirt", 40.00, "L", "Gray", "TGS-3234", 50, "gray t-shirt 100% cotton.");
        Product product13 = new Product( "Black t-shirt", 40.00, "L", "Black", "TBS-4234", 50, "black t-shirt 100% cotton.");

        productRepoI.save(product3);
        productRepoI.save(product5);
        productRepoI.save(product9);
        productRepoI.save(product13);

        Product product17 = new Product("Black  Hoodie", 80.00, "L", "Black", "HBM-5668", 50 ,"100% Black hoodie");
        Product product18 = new Product( "Black  Hoodie", 80.00, "XL", "Black", "HBXL-9002", 50 ,"100% Black hoodie");
        Product product20 = new Product( "White Hoodie", 80.00, "L", "White", "HWM-5078", 50 ,"100% Black hoodie");
        Product product21 = new Product( "White Hoodie", 80.00, "XL", "White", "HWS-9912", 50 ,"100% Black hoodie");
        Product product22 = new Product("Gray Hoodie", 80.00, "L", "Gray", "HGS-1245", 50 ,"100% Black hoodie");
        Product product26 = new Product( "Beige Hoodie", 80.00, "L", "Beige", "HBGL-5670", 50 ,"100% Black hoodie");

        productRepoI.save(product17);
        productRepoI.save(product18);
        productRepoI.save(product20);
        productRepoI.save(product21);
        productRepoI.save(product22);
        productRepoI.save(product26);



        Product product31 = new Product( "Vans all black",50.00, "10", "black", "VAB-1004", 10 ,"Classic all black vans");
        Product product34 = new Product( "Vans old skool",50.00, "10", "white", "V0S-1007", 10 ,"Classic old skool  vans");
        Product product37 = new Product( "Vans old blue",50.00, "10", "black", "V0A-1010", 10 ,"Classic blue vans");

        productRepoI.save(product31);
        productRepoI.save(product34);
        productRepoI.save(product37);

        Customer customer1 = new Customer(1, "John", "Doe", "johndoe@gmail.com", "123-456-7890", "password", "123 Main St", "New York", "NY", 10001);
        Customer customer2 = new Customer(2, "Jane", "Smith", "janesmith@gmail.com", "555-555-5555", "password123", "456 1st Ave", "Los Angeles", "CA", 90001);
        Customer customer3 = new Customer(3, "Bob", "Johnson", "bjohnson@gmail.com", "111-111-1111", "secret", "789 2nd St", "Chicago", "IL", 60601);
        Customer customer4 = new Customer(4, "Alice", "Williams", "awilliams@gmail.com", "555-123-4567", "qwerty", "246 3rd St", "Houston", "TX", 77001);
        Customer customer5 = new Customer(5, "David", "Brown", "dbrown@gmail.com", "888-888-8888", "letmein", "135 4th St", "Philadelphia", "PA", 19019);
        customerRepoI.save(customer1);
        customerRepoI.save(customer2);
        customerRepoI.save(customer3);
        customerRepoI.save(customer4);
        customerRepoI.save(customer5);










    }
}