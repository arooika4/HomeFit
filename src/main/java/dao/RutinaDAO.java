package dao;

import java.util.List;
import model.Rutina;

public interface RutinaDAO {

    void crear(Rutina rutina);

    Rutina obtener(int id);

    List<Rutina> obtenerTodas();

    void actualizar(Rutina rutina);

    void eliminar(int id);
}