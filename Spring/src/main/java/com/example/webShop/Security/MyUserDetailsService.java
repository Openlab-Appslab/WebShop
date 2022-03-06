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
    MyUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> myUser = userRepository.findByUserName(username);

        myUser.orElseThrow(() -> new UsernameNotFoundException("no found: " + username));

        UserDetails userDetails = myUser.map(myUser1 -> new MyUserDetails(myUser1)).get();


        System.out.println(userDetails.getPassword());
        System.out.println(userDetails.getAuthorities());
        System.out.println(userDetails.getUsername());

        return userDetails;
    }
}
*/