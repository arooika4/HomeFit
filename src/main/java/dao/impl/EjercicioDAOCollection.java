package dao.impl;

import dao.EjercicioDAO;
import model.Ejercicio;
import java.util.ArrayList;
import java.util.List;

public class EjercicioDAOCollection implements EjercicioDAO {

    private List<Ejercicio> ejercicios = new ArrayList<>();

    @Override
    public void crear(Ejercicio ejercicio) {
        ejercicios.add(ejercicio);
    }

    @Override
    public Ejercicio obtener(int id) {
        for (Ejercicio e : ejercicios) {
            if (e.getIdEjercicio() == id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Ejercicio> obtenerTodos() {
        return ejercicios;
    }

    @Override
    public void actualizar(Ejercicio ejercicio) {
        for (int i = 0; i < ejercicios.size(); i++) {
            if (ejercicios.get(i).getIdEjercicio() == ejercicio.getIdEjercicio()) {
                ejercicios.set(i, ejercicio);
                break;
            }
        }
    }

    @Override
    public void eliminar(int id) {
        ejercicios.removeIf(e -> e.getIdEjercicio() == id);
    }
}