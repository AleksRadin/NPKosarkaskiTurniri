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
 *
 * @author Radin
 */
public class DbConnection {
     private Connection connection;
    private static DbConnection instance;

    private DbConnection() {
    }

    public static DbConnection getInstance() {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }

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
