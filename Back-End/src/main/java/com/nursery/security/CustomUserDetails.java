package com.nursery.security;

import com.nursery.model.Employee;
import com.nursery.model.Manager;
import com.nursery.model.Parent;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
public class CustomUserDetails implements UserDetails {

    private final Object user;

    public CustomUserDetails(Object user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Determine role based on the user type
        if (user instanceof Manager) {
            return Collections.singleton(new SimpleGrantedAuthority("ROLE_MANAGER"));
        } else if (user instanceof Parent) {
            return Collections.singleton(new SimpleGrantedAuthority("ROLE_PARENT"));
        } else if (user instanceof Employee) {
            return Collections.singleton(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
        } else {
            throw new IllegalArgumentException("Unsupported user type: " + user.getClass().getName());
        }
    }

    @Override
    public String getPassword() {
        if (user instanceof Manager) {
            return ((Manager) user).getPassword();
        } else if (user instanceof Parent) {
            return ((Parent) user).getPassword();
        } else if (user instanceof Employee) {
            return ((Employee) user).getPassword();
        } else {
            throw new IllegalArgumentException("Unsupported user type: " + user.getClass().getName());
        }
    }

    @Override
    public String getUsername() {
        if (user instanceof Manager) {
            return ((Manager) user).getUsername();
        } else if (user instanceof Parent) {
            return ((Parent) user).getUsername();
        } else if (user instanceof Employee) {
            return ((Employee) user).getUsername();
        } else {
            throw new IllegalArgumentException("Unsupported user type: " + user.getClass().getName());
        }
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
}
