package dao.impl.parse;

import dao.RegistroEjercicioDAO;
import model.RegistroEjercicio;

import java.util.List;
import java.util.ArrayList;

public class RegistroEjercicioDAOParse implements RegistroEjercicioDAO {

    @Override
    public void crear(RegistroEjercicio registro) {

        System.out.println("Guardando registro de ejercicio");

    }

    @Override
    public RegistroEjercicio obtener(int id) {

        System.out.println("Obteniendo registro");

        return null;
    }

    @Override
    public List<RegistroEjercicio> obtenerTodos() {

        System.out.println("Listando registros");

        return new ArrayList<>();
    }

    @Override
    public void actualizar(RegistroEjercicio registro) {

        System.out.println("Actualizando registro");

    }

    @Override
    public void eliminar(int id) {

        System.out.println("Eliminando registro");

    }
}
