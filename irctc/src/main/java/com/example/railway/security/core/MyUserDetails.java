package com.example.railway.security.core;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.railway.model.User;
import com.example.railway.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class MyUserDetails implements UserDetails {
    private final User user;

    public MyUserDetails(User user2) {
        this.user = user2;
    }

    public MyUserDetails(Optional<org.apache.catalina.User> user2) {
		this.user = new User();
		// TODO Auto-generated constructor stub
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    @Autowired
    private UserRepository userRepository;

    
    public UserDetails loadUserByUserDetails(String username) throws UsernameNotFoundException {
        // Get your custom User from the repository
        Optional<com.example.railway.model.User> user = Optional.ofNullable(userRepository.findByUsername(username));
        
        // Check if the user is present, else throw exception
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        // Convert your custom User to UserDetails (use a custom UserDetails implementation)
        return new MyUserDetails(user.get());
    }
}

