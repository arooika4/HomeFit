package dao.impl.parse;

import dao.EjercicioDAO;
import model.Ejercicio;
import service.Back4AppConnection;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class EjercicioDAOParse implements EjercicioDAO {

    @Override
    public void crear(Ejercicio ejercicio) {

        try {

            HttpURLConnection conn = Back4AppConnection.conectar("Ejercicio", "POST");

            String json =
                    "{ \"nombre\":\"" + ejercicio.getNombre() + "\"" +
                    ",\"descripcion\":\"" + ejercicio.getDescripcion() + "\"" +
                    ",\"videoReferencia\":\"" + ejercicio.getVideoReferencia() + "\"" +
                    "}";

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
            os.flush();

            System.out.println("Ejercicio guardado en Back4App");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Ejercicio obtener(int id) {
        return null;
    }

    @Override
    public List<Ejercicio> obtenerTodos() {

        System.out.println("GET ejercicios");

        return new ArrayList<>();
    }

    @Override
    public void actualizar(Ejercicio ejercicio) {}

    @Override
    public void eliminar(int id) {}
}
