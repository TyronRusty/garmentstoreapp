package org.perscholas.app.Security;

import org.perscholas.app.dao.AuthGroupRepoI;
import org.perscholas.app.dao.MyUserRepoI;
import org.perscholas.app.models.AuthGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService{
    MyUserRepoI myUserRepoI;
    AuthGroupRepoI authGroupRepoI;

    @Autowired
    public MyUserDetailsService(MyUserRepoI myUserRepoI, AuthGroupRepoI authGroupRepoI) {
        this.myUserRepoI = myUserRepoI;
        this.authGroupRepoI = authGroupRepoI;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<AuthGroup> authGroupList = authGroupRepoI.findByEmail(username);


        return new MyUserPrincipal(myUserRepoI.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("did not find email"))
                ,authGroupList);
    }

}
