/*package com.example.webShop.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> aUser = userRepository.findByUserName(username);

        aUser.orElseThrow(() -> new UsernameNotFoundException("no found: " + username));

        UserDetails userDetails = aUser.map(aUser1 -> new MyUserDetails(aUser1)).get();


        System.out.println(userDetails.getPassword());
        System.out.println(userDetails.getAuthorities());
        System.out.println(userDetails.getUsername());

        return userDetails;
    }
}
*/