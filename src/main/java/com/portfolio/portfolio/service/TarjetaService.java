/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Tarjeta;
import com.portfolio.portfolio.repository.TarjetaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dario
 */
@Service
public class TarjetaService implements ITarjetaService{
    
    @Autowired
    private TarjetaRepository tarjetaRepo;
    
    @Override
    public List<Tarjeta> getAll(){
        return tarjetaRepo.findAll();
    }

    @Override
    public void saveTarjeta(Tarjeta tarj) {
        tarjetaRepo.save(tarj);
    }
}
