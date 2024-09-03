package ejercicio;

import java.util.Random;

public class Docente extends Persona {
    private String cursoDocente;
    private String facultadDocente;

    public Docente(String dni, String nombre, String apellido, String cursoDocente, String facultadDocente) {
        super(dni, nombre, apellido);
        this.cursoDocente = cursoDocente;
        this.facultadDocente = facultadDocente;
    }

    public void calificarCurso(Curso curso) {
        Random rand = new Random();
        int nota = rand.nextInt(21); // Nota aleatoria entre 0 y 20
        System.out.println("El curso " + curso.getNombreCurso() + " ha sido calificado con " + nota);
    }

    // Getters y Setters
    public String getCursoDocente() {
        return cursoDocente;
    }

    public void setCursoDocente(String cursoDocente) {
        this.cursoDocente = cursoDocente;
    }

    public String getFacultadDocente() {
        return facultadDocente;
    }

    public void setFacultadDocente(String facultadDocente) {
        this.facultadDocente = facultadDocente;
    }
}
