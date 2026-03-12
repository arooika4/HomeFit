package model;

public class Ejercicio {

    private int idEjercicio;
    private String nombre;
    private String descripcion;
    private String videoReferencia;
    private int idRutina;

    public Ejercicio() {}

    public Ejercicio(int idEjercicio, String nombre) {
        this.idEjercicio = idEjercicio;
        this.nombre = nombre;
    }

    public int getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(int idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getVideoReferencia() {
        return videoReferencia;
    }

    public void setVideoReferencia(String videoReferencia) {
        this.videoReferencia = videoReferencia;
    }

    public int getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(int idRutina) {
        this.idRutina = idRutina;
    }
}
