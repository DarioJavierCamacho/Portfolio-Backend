/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author dario
 */

@Setter @Getter
@Entity
public class Tarjeta {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String subtitulo;
    private String imgsrc;
    @NotNull
    private int tipo;
    private int percent;
    private String fInicio;
    private String fFin;

    public Tarjeta(Long id, String titulo, String subtitulo, String imgsrc, int percent, String fInicio, String fFin) {
        this.id = id;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.imgsrc = imgsrc;
        this.percent = percent;     
        this.fInicio = fInicio;
        this.fFin = fFin;
    }

  
    public Tarjeta() {
    }
}
