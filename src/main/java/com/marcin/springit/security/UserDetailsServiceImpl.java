package com.marcin.springit.security;

import com.marcin.springit.domain.User;
import com.marcin.springit.repository.UserRepopsitory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepopsitory userRepopsitory;

    public UserDetailsServiceImpl(UserRepopsitory userRepopsitory) {
        this.userRepopsitory = userRepopsitory;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepopsitory.findByEmail(email);
        if ( !user.isPresent()) {
            throw new UsernameNotFoundException(email);
        }
        return user.get();
    }
}
