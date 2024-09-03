package ejercicio;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sofía
 */
public class Curso {
    private String nombreCurso;

    public Curso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    // Getters y Setters
    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
}