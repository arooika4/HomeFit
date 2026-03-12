package dao;

import java.util.List;
import model.RegistroEjercicio;

public interface RegistroEjercicioDAO {

    // Crear un registro de ejercicio
    void crear(RegistroEjercicio registro);

    // Obtener un registro por ID
    RegistroEjercicio obtener(int id);

    // Obtener todos los registros
    List<RegistroEjercicio> obtenerTodos();

    // Actualizar un registro
    void actualizar(RegistroEjercicio registro);

    // Eliminar un registro
    void eliminar(int id);

}
