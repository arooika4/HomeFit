package dao;

import java.util.List;
import model.Sesion;

public interface SesionDAO {

    void crear(Sesion sesion);

    Sesion obtener(int id);

    List<Sesion> obtenerTodas();

    void actualizar(Sesion sesion);

    void eliminar(int id);
}