/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Tarjeta;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *      
 * @author dario
 */
@Service
public interface ITarjetaService {
    
    //Trae la lista completa de tarjetas de informacion
    public List<Tarjeta> getAll();
    
    //Guarda una tarjeta 
    public void saveTarjeta(Tarjeta tarj);
    
    public void editarTarjeta( Tarjeta Tarj);
    
    public void borrarTarjeta(Long id);
    
    public Optional<Tarjeta> getById(long id);
}
