package dao.impl.parse;

import dao.SesionDAO;
import model.Sesion;
import service.Back4AppConnection;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class SesionDAOParse implements SesionDAO {

    @Override
    public void crear(Sesion sesion) {

        try {

            HttpURLConnection conn = Back4AppConnection.conectar("Sesion", "POST");

            String json = "{ \"fecha\": \"" + sesion.getFecha() + "\" }";

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
            os.flush();

            System.out.println("Sesion guardada en Back4App");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Sesion obtener(int id) {
        return null;
    }

    @Override
    public List<Sesion> obtenerTodas() {

        System.out.println("GET sesiones");

        return new ArrayList<>();
    }

    @Override
    public void actualizar(Sesion sesion) {}

    @Override
    public void eliminar(int id) {}
}
