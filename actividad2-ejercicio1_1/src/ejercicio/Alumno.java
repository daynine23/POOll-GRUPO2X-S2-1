package ejercicio;

import java.io.BufferedReader;
import java.io.FileReader;
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
public class Alumno extends Persona{
    private String codigoAlumno;
    private List<Curso> listaCursos;



    public Alumno(String codigoAlumno, List<Curso> listaCursos, String nombre) {
        this.nombre = nombre;
        this.codigoAlumno = codigoAlumno;
        this.listaCursos = listaCursos;
        this.leeCursosAlumno("./src/ejercicio/cursosAlumnos.txt");
        //this.leeCursoAlumno("");
    }
    
    public void guardar(Curso curso){
        listaCursos.add(curso);
        
    }
    private void leeCursosAlumno(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Supongamos que el archivo tiene un formato donde cada línea es un curso
                listaCursos.add(new Curso(linea));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
    
    
    
    
    
    
}
