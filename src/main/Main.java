import dao.impl.parse.RutinaDAOParse;
import model.Rutina;

public class Main {

    public static void main(String[] args) {

        RutinaDAOParse dao = new RutinaDAOParse();

        Rutina r = new Rutina(1, "Rutina Piernas");

        dao.crear(r);

        System.out.println("Programa terminado");

    }

}
