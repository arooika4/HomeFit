package dao.impl;

import dao.RutinaDAO;
import model.Rutina;
import java.util.ArrayList;
import java.util.List;

public class RutinaDAOCollection implements RutinaDAO {

    private List<Rutina> rutinas = new ArrayList<>();

    @Override
    public void crear(Rutina rutina) {
        rutinas.add(rutina);
    }

    @Override
    public Rutina obtener(int id) {
        for (Rutina r : rutinas) {
            if (r.getIdRutina() == id) {
                return r;
            }
        }
        return null;
    }

    @Override
    public List<Rutina> obtenerTodas() {
        return rutinas;
    }

    @Override
    public void actualizar(Rutina rutina) {
        // implementar después
    }

    @Override
    public void eliminar(int id) {
        // implementar después
    }
}