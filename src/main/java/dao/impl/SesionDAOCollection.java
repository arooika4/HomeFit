package dao.impl;

import dao.SesionDAO;
import model.Sesion;
import java.util.ArrayList;
import java.util.List;

public class SesionDAOCollection implements SesionDAO {

    private List<Sesion> sesiones = new ArrayList<>();

    @Override
    public void crear(Sesion sesion) {
        sesiones.add(sesion);
    }

    @Override
    public Sesion obtener(int id) {
        for (Sesion s : sesiones) {
            if (s.getIdSesion() == id) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Sesion> obtenerTodas() {
        return sesiones;
    }

    @Override
    public void actualizar(Sesion sesion) {
        for (int i = 0; i < sesiones.size(); i++) {
            if (sesiones.get(i).getIdSesion() == sesion.getIdSesion()) {
                sesiones.set(i, sesion);
                break;
            }
        }
    }

    @Override
    public void eliminar(int id) {
        sesiones.removeIf(s -> s.getIdSesion() == id);
    }
}