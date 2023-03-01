package org.perscholas.app;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.app.dao.CategoryRepoI;
import org.perscholas.app.dao.CustomerRepoI;
import org.perscholas.app.dao.ProductRepoI;
import org.perscholas.app.models.Category;
import org.perscholas.app.models.Customer;
import org.perscholas.app.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyCommandLineRunner implements CommandLineRunner {
    CategoryRepoI categoryRepoI;
    CustomerRepoI customerRepoI;
    ProductRepoI productRepoI;

    @Autowired
    public MyCommandLineRunner(CategoryRepoI categoryRepoI, CustomerRepoI customerRepoI, ProductRepoI productRepoI) {
        this.categoryRepoI = categoryRepoI;
        this.customerRepoI = customerRepoI;
        this.productRepoI = productRepoI;
    }

    public void run(String... args) throws Exception {

// Create three instances of the Category class in a single line
        Category category1 = new Category(1, "tshirt", "garment tshirt");
        Category category2 = new Category(2, "hoodie", "garment hoodie");
        Category category3 = new Category(3, "shoes", "footwear shoes");

        categoryRepoI.save(category1);
        categoryRepoI.save(category2);
        categoryRepoI.save(category3);
        Product product1 = new Product(1, "garment  White t-shirt", 40.00, "S", "White", "TWS-1234", 50, "classic white t-shirt made from 100% cotton.",category1);
        Product product2 = new Product(2, " garment  White t-shirt", 40.00, "M", "White", "TWM-1235", 50, "classic white t-shirt made from 100% cotton.",category1);
        Product product3 = new Product(3, "garment  White t-shirt", 40.00, "L", "White", "TWL-1236", 50, "classic white t-shirt made from 100% cotton.",category1);
        Product product4 = new Product(4, "garment White t-shirt", 40.00, "XL", "White", "TWXL-1237", 50, "classic white t-shirt made from 100% cotton.",category1);
        Product product5 = new Product(5, "garment  Beige t-shirt", 40.00, "S", "Beige", "TBGS-2234", 50, "classic beige t-shirt made from 100% cotton.",category1);
        Product product6 = new Product(6, " garment  Beige t-shirt", 40.00, "M", "Beige", "TBGM-2235", 50, "classic beige t-shirt made from 100% cotton.",category1);
        Product product7 = new Product(7, "garment  Beige t-shirt", 40.00, "L", "Beige", "TBGL-2236", 50, "classic beige t-shirt made from 100% cotton.",category1);
        Product product8 = new Product(8, "garment Beige t-shirt", 40.00, "XL", "Beige", "TBGXL-2237", 50, "classic beige t-shirt made from 100% cotton.",category1);
        Product product9 = new Product(9, "garment  Gray t-shirt", 40.00, "S", "Gray", "TGS-3234", 50, "classic gray t-shirt made from 100% cotton.",category1);
        Product product10 = new Product(10, "garment Gray t-shirt", 40.00, "M", "Gray", "TGM-3235", 50, "classic gray t-shirt made from 100% cotton.",category1);
        Product product11 = new Product(11, "garment  Gray t-shirt", 40.00, "L", "Gray", "TGL-3236", 50, "classic gray t-shirt made from 100% cotton.",category1);
        Product product12 = new Product(12, "garment Gray t-shirt", 40.00, "XL", "Gray", "TGXL-3237", 50, "classic gray t-shirt made from 100% cotton.",category1);
        Product product13 = new Product(13,  "garment  Black t-shirt", 40.00, "S", "Black", "TBS-4234", 50, "classic black t-shirt made from 100% cotton.",category1);
        Product product14 =new Product(14, "garment Black t-shirt", 40.00, "M", "Black", "TBM-4235", 50, "classic black t-shirt made from 100% cotton.",category1);
        productRepoI.save(product1);
        productRepoI.save(product2);
        productRepoI.save(product3);
        productRepoI.save(product4);
        productRepoI.save(product5);
        productRepoI.save(product6);
        productRepoI.save(product7);
        productRepoI.save(product8);
        productRepoI.save(product9);
        productRepoI.save(product10);
        productRepoI.save(product11);
        productRepoI.save(product12);
        productRepoI.save(product13);
        productRepoI.save(product14);
        Product product16 = new Product(16, "Garment Black Hoodie", 80.00, "S", "Black", "HBS-1234", 50 ,"Classic garment 100% Black hoodie", category2);
        Product product17 = new Product(17, "Garment Black  Hoodie", 80.00, "M", "Black", "HBM-5668", 50 ,"Classic garment 100% Black hoodie", category2);
        Product product18 = new Product(18, "Garment Black  Hoodie", 80.00, "XL", "Black", "HBXL-9002", 50 ,"Classic garment 100% Black hoodie", category2);
        Product product19 = new Product(19, "Garment White Hoodie", 80.00, "L", "White", "HWL-1734", 50 ,"Classic garment 100% Black hoodie", category2);
        Product product20 = new Product(20, "Garment White Hoodie", 80.00, "M", "White", "HWM-5078", 50 ,"Classic garment 100% Black hoodie", category2);
        Product product21 = new Product(21, "Garment White Hoodie", 80.00, "S", "White", "HWS-9912", 50 ,"Classic garment 100% Black hoodie", category2);
        Product product22 = new Product(22, "Garment Gray Hoodie", 80.00, "S", "Gray", "HGS-1245", 50 ,"Classic garment 100% Black hoodie", category2);
        Product product23 = new Product(23, "Garment Gray Hoodie", 80.00, "M", "Gray", "HGM-8678", 50 ,"Classic garment 100% Black hoodie", category2);
        Product product24 = new Product(24, "Garment Gray Hoodie", 80.00, "L", "Gray", "HGL-9012", 50 ,"Classic garment 100% Black hoodie", category2);
        Product product25 = new Product(25, "Garment Black Hoodie", 80.00, "L", "Black", "HBL-5634", 50 ,"Classic garment 100% Black hoodie", category2);
        Product product26 = new Product(26, "Garment Beige Hoodie", 80.00, "L", "Beige", "HBGL-5670", 50 ,"Classic garment 100% Black hoodie", category2);
        Product product27 = new Product(27, "Garment Beige Hoodie", 80.00, "M", "Beige", "HBGM-9332", 50 ,"Classic garment 100% Black hoodie", category2);
        Product product28 = new Product(28, "Garment White Hoodie",80.00, "XL", "White", "HWXL-1004", 50 ,"Classic garment 100% Black hoodie", category2);
        Product product29 = new Product(29, "Garment Beige Hoodie", 80.00, "S", "Beige", "HBGS-5488", 50 ,"Classic garment 100% Black hoodie", category2);
        Product product30 = new Product(30, "Garment Beige Hoodie", 80.00, "XL", "Beige", "HBGXL-9412", 50 ,"Classic garment 100% Black hoodie", category2);

        productRepoI.save(product16);
        productRepoI.save(product17);
        productRepoI.save(product18);
        productRepoI.save(product19);
        productRepoI.save(product20);
        productRepoI.save(product21);
        productRepoI.save(product22);
        productRepoI.save(product23);
        productRepoI.save(product24);
        productRepoI.save(product25);
        productRepoI.save(product26);
        productRepoI.save(product27);
        productRepoI.save(product28);
        productRepoI.save(product29);
        productRepoI.save(product30);

        Product product31 = new Product(31, "Vans all black",50.00, "8", "black", "VAB-1004", 10 ,"Classic all black vans", category3);
        Product product32 = new Product(32, "Vans all black",50.00, "10", "black", "VAB-1005", 10 ,"Classic all black vans", category3);
        Product product33 = new Product(33, "Vans all black",50.00, "11", "black", "VAB-1006", 10 ,"Classic all black vans", category3);
        Product product34 = new Product(34, "Vans old skool",50.00, "8", "blue", "V0S-1007", 10 ,"Classic old skool blue vans", category3);
        Product product35 = new Product(35, "Vans old skool",50.00, "10", "blue", "V0S-1008", 10 ,"Classic old skool blue vans", category3);
        Product product36 = new Product(36, "Vans old skoolB",50.00, "8", "black", "V0A-1009", 10 ,"Classic old skool black vans", category3);
        Product product37 = new Product(37, "Vans old skoolB",50.00, "11", "black", "V0A-1010", 10 ,"Classic old skool black vans", category3);

        productRepoI.save(product31);
        productRepoI.save(product32);
        productRepoI.save(product33);
        productRepoI.save(product34);
        productRepoI.save(product35);
        productRepoI.save(product36);
        productRepoI.save(product37);

        Customer customer1 = new Customer(1, "John", "Doe", "johndoe@gmail.com", "123-456-7890", "password", "123 Main St", "New York", "NY", 10001, "USA");
        Customer customer2 = new Customer(2, "Jane", "Smith", "janesmith@gmail.com", "555-555-5555", "password123", "456 1st Ave", "Los Angeles", "CA", 90001, "USA");
        Customer customer3 = new Customer(3, "Bob", "Johnson", "bjohnson@gmail.com", "111-111-1111", "secret", "789 2nd St", "Chicago", "IL", 60601, "USA");
        Customer customer4 = new Customer(4, "Alice", "Williams", "awilliams@gmail.com", "555-123-4567", "qwerty", "246 3rd St", "Houston", "TX", 77001, "USA");
        Customer customer5 = new Customer(5, "David", "Brown", "dbrown@gmail.com", "888-888-8888", "letmein", "135 4th St", "Philadelphia", "PA", 19019, "USA");
        customerRepoI.save(customer1);
        customerRepoI.save(customer2);
        customerRepoI.save(customer3);
        customerRepoI.save(customer4);
        customerRepoI.save(customer5);










    }
}