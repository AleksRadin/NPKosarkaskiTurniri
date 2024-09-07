package repository.db;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


/**
 * Predstavlja klasu za upravljanje konekcijama sa bazom podataka koristeći Singleton obrazac.
 * Ova klasa obezbeđuje jedinstvenu instancu konekcije sa bazom podataka tokom rada aplikacije.
 * 
 * @author Radin
 */
public class DbConnection {
	/**
     * Konekcija na bazu podataka.
     */
    private Connection connection;
    /**
     * Jedinstvena instanca klase DbConnection.
     */
    private static DbConnection instance;

    /**
     * Privatni konstruktor koji sprečava kreiranje novih instanci izvan ove klase.
     * Poziva se samo prilikom inicijalnog kreiranja jedinstvene instance ove klase.
     */
    private DbConnection() {
    }

    /**
     * Vraća jedinstvenu instancu klase DbConnection.
     * Ako instanca ne postoji, kreira novu instancu. U suprotnom, vraća postojeću instancu.
     * 
     * @return Jedinstvena instanca klase DbConnection.
     */
    public static DbConnection getInstance() {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }

    /**
     * Vraća konekciju sa bazom podataka. Ako konekcija ne postoji ili je zatvorena, kreira novu konekciju
     * koristeći parametre iz konfiguracionog fajla dbconfig.json.
     * 
     * @return Konekcija sa bazom podataka.
     * @throws SQLException Ako dođe do greške prilikom ostvarivanja konekcije sa bazom podataka.
     * @throws FileNotFoundException Ako konfiguracioni fajl dbconfig.json nije pronađen.
     * @throws IOException Ako dođe do greške prilikom čitanja konfiguracionog fajla.
     */
    public Connection getConnection() throws SQLException, FileNotFoundException, IOException {
        if(connection == null || connection.isClosed()){
        	try(FileReader fr = new FileReader("src/main/java/resources/dbconfig.json")){
				Gson gson = new Gson();
				JsonObject jsonObject = gson.fromJson(fr, JsonObject.class);

				 String url = jsonObject.get("url").getAsString();
	             String username = jsonObject.get("username").getAsString();
	             String password = jsonObject.get("password").getAsString();

	             connection = DriverManager.getConnection(url, username, password);
	             connection.setAutoCommit(false);

			} catch (Exception e) {
				e.printStackTrace();
                throw e;
			}
        }
        return connection;
    }
    
    
    
}
