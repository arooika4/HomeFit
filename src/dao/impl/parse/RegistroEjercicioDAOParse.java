package dao.impl.parse;

import dao.RegistroEjercicioDAO;
import model.RegistroEjercicio;
import service.Back4AppConnection;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class RegistroEjercicioDAOParse implements RegistroEjercicioDAO {

    @Override
    public void crear(RegistroEjercicio registro) {

        try {
            HttpURLConnection conn = Back4AppConnection.conectar("RegistroEjercicio", "POST");

            String json =
                    "{ \"tiempo\":" + registro.getTiempo() +
                    ",\"nivel\":\"" + registro.getNivel() + "\"" +
                    ",\"foto\":\"" + registro.getFoto() + "\"" +
                    "}";

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
            os.flush();

            System.out.println("Registro guardado en Back4App");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public RegistroEjercicio obtener(int id) {
        return null;
    }

    @Override
    public List<RegistroEjercicio> obtenerTodos() {
        System.out.println("GET registros");
        return new ArrayList<>();
    }

    @Override
    public void actualizar(RegistroEjercicio registro) {}

    @Override
    public void eliminar(int id) {}
}
