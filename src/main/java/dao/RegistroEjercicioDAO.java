package dao;

import java.util.List;
import model.RegistroEjercicio;

public interface RegistroEjercicioDAO {

    void crear(RegistroEjercicio registro);

    RegistroEjercicio obtener(int id);

    List<RegistroEjercicio> obtenerTodos();

    void actualizar(RegistroEjercicio registro);

    void eliminar(int id);

}