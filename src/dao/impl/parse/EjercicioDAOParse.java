package dao.impl.parse;

import dao.EjercicioDAO;
import model.Ejercicio;

import java.util.List;
import java.util.ArrayList;

public class EjercicioDAOParse implements EjercicioDAO {

    @Override
    public void crear(Ejercicio ejercicio) {

        System.out.println("Creando ejercicio en Back4App");

    }

    @Override
    public Ejercicio obtener(int id) {

        System.out.println("Obteniendo ejercicio");

        return null;
    }

    @Override
    public List<Ejercicio> obtenerTodos() {

        System.out.println("Listando ejercicios");

        return new ArrayList<>();
    }

    @Override
    public void actualizar(Ejercicio ejercicio) {

        System.out.println("Actualizando ejercicio");

    }

    @Override
    public void eliminar(int id) {

        System.out.println("Eliminando ejercicio");

    }
}
