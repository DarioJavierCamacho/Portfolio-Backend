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


/**
 *
 * @author dario
 */

@Entity
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String subtitulo;
    private String imgsrc;
    private String fInicio;
    private String fFin;
    private int percent;
    @NotNull
    private int tipo;
    

    public Tarjeta(Long id, String titulo, String subtitulo, String imgsrc, String fInicio, String fFin, int tipo, int percent) {
        this.id = id;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.imgsrc = imgsrc;
        this.fInicio = fInicio;
        this.fFin = fFin;
        this.tipo = tipo;
        this.percent = percent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getfInicio() {
        return fInicio;
    }

    public void setfInicio(String fInicio) {
        this.fInicio = fInicio;
    }

    public String getfFin() {
        return fFin;
    }

    public void setfFin(String fFin) {
        this.fFin = fFin;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
    

   
    public Tarjeta() {
    }
}
