package com.example.demo.util;


import com.example.demo.model.Customers;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
public class UserDetailsImpl implements UserDetails {
    private Long idCustomers;
    private String username;
    private String password;

    public UserDetailsImpl(String username, String password, Long idCustomers) {
        this.idCustomers = idCustomers;
        this.username = username;
        this.password = password;
    }

    public static UserDetails build(Customers customers){
        return new UserDetailsImpl(
                customers.getUsername(), customers.getPassword(), customers.getIdCustomers()
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
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
}
