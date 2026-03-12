package dao.impl.parse;

import dao.SesionDAO;
import model.Sesion;

import java.util.List;
import java.util.ArrayList;

public class SesionDAOParse implements SesionDAO {

    @Override
    public void crear(Sesion sesion) {

        System.out.println("Creando sesión en Back4App");

    }

    @Override
    public Sesion obtener(int id) {

        System.out.println("Obteniendo sesión");

        return null;
    }

    @Override
    public List<Sesion> obtenerTodas() {

        System.out.println("Listando sesiones");

        return new ArrayList<>();
    }

    @Override
    public void actualizar(Sesion sesion) {

        System.out.println("Actualizando sesión");

    }

    @Override
    public void eliminar(int id) {

        System.out.println("Eliminando sesión");

    }
}
