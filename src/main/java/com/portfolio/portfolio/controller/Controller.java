/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Tarjeta;
import com.portfolio.portfolio.service.ITarjetaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dario
 */
@RestController
@CrossOrigin(origins = "https://portfoliodariocamacho.web.app")
public class Controller {

    @Autowired
    private ITarjetaService tarj;
    
    @CrossOrigin(origins = "https://portfoliodariocamacho.web.app")
    @GetMapping("/tarjeta")
    @ResponseBody
    public List<Tarjeta> GetDatos() {
        return tarj.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/tarjeta")
    public void agregarTarjeta(@RequestBody Tarjeta Tarj) {
        tarj.saveTarjeta(Tarj);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/tarjeta")
    public void editarTarjeta(@RequestBody Tarjeta Tarj) {
        tarj.saveTarjeta(Tarj);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/tarjeta")
    public void editarTarjeta(@RequestParam Long id){
        tarj.borrarTarjeta(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/tarjeta/{id}")
    public Optional<Tarjeta> getByid(@PathVariable Long id){
       return tarj.getById(id);
    }
    
}
