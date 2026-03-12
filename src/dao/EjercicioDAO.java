package dao;

import java.util.List;
import model.Ejercicio;

public interface EjercicioDAO {

    void crear(Ejercicio ejercicio);

    Ejercicio obtener(int id);

    List<Ejercicio> obtenerTodos();

    void actualizar(Ejercicio ejercicio);

    void eliminar(int id);
}
