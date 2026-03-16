package service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class Back4AppConnection {
    
    private static String APPLICATION_ID;
    private static String REST_API_KEY;
    private static String API_URL;
    
    // Bloque estático para cargar configuración UNA SOLA VEZ
    static {
        cargarConfiguracion();
    }
    
    private static void cargarConfiguracion() {
        try (InputStream input = Back4AppConnection.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            
            if (input == null) {
                System.err.println("ERROR: No se encontró config.properties");
                System.err.println("Copia config.properties.EJEMPLO como config.properties y añade tus claves");
                return;
            }
            
            Properties prop = new Properties();
            prop.load(input);
            
            APPLICATION_ID = prop.getProperty("back4app.app.id");
            REST_API_KEY = prop.getProperty("back4app.rest.key");
            API_URL = prop.getProperty("back4app.server.url");
            
            System.out.println("Configuración de Back4App cargada correctamente");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static HttpURLConnection conectar(String endpoint, String metodo) throws Exception {
        
        if (APPLICATION_ID == null || REST_API_KEY == null) {
            throw new Exception("Back4App no configurado. Revisa config.properties");
        }
        
        URL url = new URL(API_URL + endpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        conn.setRequestMethod(metodo);
        conn.setRequestProperty("X-Parse-Application-Id", APPLICATION_ID);
        conn.setRequestProperty("X-Parse-REST-API-Key", REST_API_KEY);
        conn.setRequestProperty("Content-Type", "application/json");
        
        conn.setDoOutput(true);
        
        return conn;
    }
}
