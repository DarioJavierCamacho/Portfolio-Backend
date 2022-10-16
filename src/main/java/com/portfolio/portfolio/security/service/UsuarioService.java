/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.security.service;

import com.portfolio.portfolio.security.entity.Usuario;
import com.portfolio.portfolio.security.repository.UsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dario
 */
@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuariorepository;

    public Optional<Usuario> getByNombreUsuario(String nombreusuario) {
        return usuariorepository.findByUsername(nombreusuario);
    }

    public boolean existsByNombreUsuario(String nombreusuario) {
        return usuariorepository.existByUsername(nombreusuario);
    }

    public boolean existsByEmail(String email) {
        return usuariorepository.existByEmail(email);
    }

    public void save(Usuario usuario) {
        usuariorepository.save(usuario);
    }
}
