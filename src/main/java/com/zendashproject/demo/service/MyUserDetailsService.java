package com.zendashproject.demo.service;

import com.zendashproject.demo.model.Role;
import com.zendashproject.demo.model.User;
import com.zendashproject.demo.repository.RoleRepository;
import com.zendashproject.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
       Role role = new Role();
        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(role.getName());
        String password = user.getPassword();
        Boolean enabled = user.getEnabled();
        return new org.springframework.security.core.userdetails.User(email, password, enabled, true, true, true, auth);
    }

    public User get(String email){
        return userService.findByEmail(email);
    }

    public User get(Long id){
        return userRepository.findById(id).get();
    }

    public String getUsername(Long id){
        User user = userRepository.findById(id).get();
        return user.getFirstname() + " " + user.getLastname();
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles){
        Set<GrantedAuthority> roles = new HashSet<>();
        for (Role role : userRoles){
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities){
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                user.getEnabled(), true, true, true,authorities);
    }

    public Iterable<User> findAllUsers(){
        return userRepository.findAll();
    }
}
