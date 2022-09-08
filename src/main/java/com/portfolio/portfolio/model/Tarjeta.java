/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private String tipo;

    public Tarjeta(long id, String titulo, String subtitulo, String imgsrc, String tipo) {
        this.id = id;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.imgsrc = imgsrc;
        this.tipo = tipo;
    }

    public Tarjeta() {
    }
}
