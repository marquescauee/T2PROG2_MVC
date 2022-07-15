/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Exceptions;

public class IdentificadorUnicoException extends Exception {
    
    public IdentificadorUnicoException() {
        super("Já existe registro com esse identificador");
    }
}
