/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.security.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author dario
 */
public class UsuarioPrincipal implements UserDetails {

    private String nombre;
    private String username;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> Authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public UsuarioPrincipal(String nombre, String username, String email, String password, Collection<? extends GrantedAuthority> Authorities) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.password = password;
        this.Authorities = Authorities;
    }

    public static UsuarioPrincipal build(Usuario usuario) {
        List<GrantedAuthority> authorities
                = usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolnombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassword(), authorities);
    }
}
