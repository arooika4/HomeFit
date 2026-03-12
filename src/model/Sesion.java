package model;

import java.time.LocalDate;

public class Sesion {

    private int idSesion;
    private LocalDate fecha;

    public Sesion() {}

    public Sesion(int idSesion, LocalDate fecha) {
        this.idSesion = idSesion;
        this.fecha = fecha;
    }

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
