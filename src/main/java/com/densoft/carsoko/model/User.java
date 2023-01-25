package com.densoft.carsoko.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {
    private String name;
    @Column(unique = true)
    private String email;
    @Column(length = 500)
    private String image;
    @Column(unique = true)
    private String phone;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String role;
    private String location;
    @OneToOne
    private BusinessInfo businessInfo;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles;

    public User(String name, String email, String phone, String password, String location) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.location = location;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<>(Collections.singleton(new SimpleGrantedAuthority(role)));
    }

    @Override
    public String getUsername() {
        return email;
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
