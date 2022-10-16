/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.security.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author dario
 */

@Setter
@Getter
public class LoginUsuario {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
