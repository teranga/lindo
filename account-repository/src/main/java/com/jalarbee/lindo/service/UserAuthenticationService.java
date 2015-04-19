package com.jalarbee.lindo.service;

import com.jalarbee.lindo.dao.UserDao;
import com.jalarbee.lindo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Abdoulaye Diallo
 */

@Service
public class UserAuthenticationService implements UserDetailsService {

    @Autowired private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user.getRoles()));

    }

    private Collection<? extends GrantedAuthority> getAuthorities(Set<String> roles) {

        return roles.stream().map(r -> (GrantedAuthority) () -> r).collect(Collectors.toSet());
    }

}
