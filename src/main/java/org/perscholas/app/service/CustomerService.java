package org.perscholas.app.service;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.app.dao.CustomerRepoI;
import org.perscholas.app.models.Customer;
import org.perscholas.app.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Transactional(rollbackOn = Exception.class)
public class CustomerService {
    CustomerRepoI customerRepoI;


    @Autowired
    public CustomerService(CustomerRepoI customerRepoI) {
        this.customerRepoI = customerRepoI;
    }

    public void deleteCustomer(String email) throws Exception {
        Optional<Customer> wantToDelete = customerRepoI.findByEmailAllIgnoreCase(email);
        if (wantToDelete.isPresent()) {
            customerRepoI.delete(wantToDelete.get());
            log.debug("customer was deleted");
        } else {
            throw new Exception("Can't find the product with id " + email);
        }
    }

    public List<Customer> ListAll() {

        return (List<Customer>) customerRepoI.findAll();
    }
}
