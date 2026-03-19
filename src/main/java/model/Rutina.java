package model;

import java.util.List;

public class Rutina {

    private int idRutina;
    private String nombre;
    private List<Ejercicio> ejercicios;

    public Rutina() {}

    public Rutina(int idRutina, String nombre) {
        this.idRutina = idRutina;
        this.nombre = nombre;
    }

    public int getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(int idRutina) {
        this.idRutina = idRutina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }
}