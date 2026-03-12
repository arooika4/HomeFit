package dao.impl.parse;

import dao.RutinaDAO;
import model.Rutina;
import service.Back4AppConnection;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class RutinaDAOParse implements RutinaDAO {

    @Override
    public void crear(Rutina rutina) {

        try {

            HttpURLConnection conn = Back4AppConnection.conectar("Rutina", "POST");

            String json = "{ \"nombre\": \"" + rutina.getNombre() + "\" }";

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
            os.flush();

            System.out.println("Rutina guardada en Back4App");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Rutina obtener(int id) {

        System.out.println("GET rutina no implementado todavía");

        return null;
    }

    @Override
    public List<Rutina> obtenerTodas() {

        try {

            HttpURLConnection conn = Back4AppConnection.conectar("Rutina", "GET");

            System.out.println("Consultando rutinas en Back4App");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void actualizar(Rutina rutina) {

        System.out.println("Actualizar rutina no implementado");

    }

    @Override
    public void eliminar(int id) {

        System.out.println("Eliminar rutina no implementado");

    }
}
