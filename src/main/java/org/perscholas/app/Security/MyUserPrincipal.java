package org.perscholas.app.Security;

import org.perscholas.app.models.AuthGroup;
import org.perscholas.app.models.MyUser;

import java.util.List;

public class MyUserPrincipal {
    MyUser myUser;
    List<AuthGroup> authGroup;

    public MyUserPrincipal(MyUser myUser, List<AuthGroup> authGroup) {
        this.myUser = myUser;
        this.authGroup = authGroup;
    }
}
