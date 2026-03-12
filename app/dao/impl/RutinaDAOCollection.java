package daoimpl;

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
        // buscar rutina
        return null;
    }

    @Override
    public List<Rutina> obtenerTodas() {
        return rutinas;
    }

    @Override
    public void actualizar(Rutina rutina) {
        // actualizar
    }

    @Override
    public void eliminar(int id) {
        // eliminar
    }
}
