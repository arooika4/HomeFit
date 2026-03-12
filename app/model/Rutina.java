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

    // getters y setters

}
