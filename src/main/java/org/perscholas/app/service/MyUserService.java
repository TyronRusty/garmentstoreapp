package org.perscholas.app.service;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.app.dao.MyUserRepoI;
import org.perscholas.app.models.MyUser;
import org.perscholas.app.models.Product;
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


    public List<MyUser> ListAll() {

        return (List<MyUser>) myUserRepoI.findAll();
    }

    public MyUser save(MyUser myUser) {
        log.debug("save method from srv layer" +myUser);
        if(myUserRepoI.findByEmail(myUser.getEmail()).isPresent()){
            log.debug("user exist");
            MyUser Db = myUserRepoI.findByEmail(myUser.getEmail()).get();
        Db.setFirstName(myUser.getFirstName());
        Db.setLastName(myUser.getLastName());

        Db.setAddress(myUser.getAddress());
        Db.setCity(myUser.getCity());
      Db=  myUserRepoI.save(Db);
      return  Db;
        } else {
            return myUserRepoI.save(myUser);
        }



    }

    public void deleteUser(Integer id) throws Exception {
        Optional<MyUser> wantToDelete = myUserRepoI.findById(id);
        if (wantToDelete.isPresent()) {
            myUserRepoI.delete(wantToDelete.get());
        } else {
            throw new Exception("Can't find the user with id " + id);
        }
    }
}
