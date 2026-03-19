package dao.impl;

import dao.RegistroEjercicioDAO;
import model.RegistroEjercicio;
import java.util.ArrayList;
import java.util.List;

public class RegistroEjercicioDAOCollection implements RegistroEjercicioDAO {

    private List<RegistroEjercicio> registros = new ArrayList<>();

    @Override
    public void crear(RegistroEjercicio registro) {
        registros.add(registro);
    }

    @Override
    public RegistroEjercicio obtener(int id) {
        for (RegistroEjercicio r : registros) {
            if (r.getIdRegistro() == id) {
                return r;
            }
        }
        return null;
    }

    @Override
    public List<RegistroEjercicio> obtenerTodos() {
        return registros;
    }

    @Override
    public void actualizar(RegistroEjercicio registro) {
        for (int i = 0; i < registros.size(); i++) {
            if (registros.get(i).getIdRegistro() == registro.getIdRegistro()) {
                registros.set(i, registro);
                break;
            }
        }
    }

    @Override
    public void eliminar(int id) {
        registros.removeIf(r -> r.getIdRegistro() == id);
    }
}