package pl.sdejnert.restApiDemo.configuration.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthorizationUserService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final String LOGIN = "rest";
        final String PASSWORD = "$2a$12$sMRwQE/zPQbVN6FNxdlJNuAct7RXvJPvcyzymofNKZBYnggn0CxT2";
        if (LOGIN.equals(username))
            return new User(LOGIN, PASSWORD, new ArrayList<>());
        else
            throw new UsernameNotFoundException(String.format("User not found with username: %s", username));
    }

}