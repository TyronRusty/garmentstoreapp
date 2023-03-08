package org.perscholas.app.service;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.app.dao.MyUserRepoI;
import org.perscholas.app.models.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Transactional(rollbackOn = Exception.class)
public class MyUserService {
    MyUserRepoI myUserRepoI;


    @Autowired
    public MyUserService(MyUserRepoI myUserRepoI) {
        this.myUserRepoI = myUserRepoI;
    }

    public void deleteCustomer(String email) throws Exception {
        Optional<MyUser> wantToDelete = myUserRepoI.findByEmailAllIgnoreCase(email);
        if (wantToDelete.isPresent()) {
            myUserRepoI.delete(wantToDelete.get());
            log.debug("customer was deleted");
        } else {
            throw new Exception("Can't find the product with id " + email);
        }
    }

    public List<MyUser> ListAll() {

        return (List<MyUser>) myUserRepoI.findAll();
    }
}
