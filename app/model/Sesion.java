package model;

import java.time.LocalDate;

public class Sesion {

    private int idSesion;
    private LocalDate fecha;

    public Sesion(){}

    public Sesion(int idSesion, LocalDate fecha){
        this.idSesion = idSesion;
        this.fecha = fecha;
    }

    // getters y setters

}
