/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Tarjeta;
import com.portfolio.portfolio.service.ITarjetaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
public class Controller {

    @Autowired
    private ITarjetaService tarj;

    @GetMapping("/test")
    @ResponseBody
    public List<Tarjeta> GetDatos() {
        return tarj.getAll();
    }

    @PostMapping("/test")
    public void agregarTarjeta(@RequestBody Tarjeta Tarj) {
        tarj.saveTarjeta(Tarj);
    }
    @PutMapping("/test")
    public void editarTarjeta(@RequestBody Tarjeta Tarj) {
        tarj.saveTarjeta(Tarj);
    }
    @DeleteMapping("/test")
    public void editarTarjeta(@RequestParam Long id){
        tarj.borrarTarjeta(id);
    }
    
}
