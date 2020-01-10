package server.phpMyAdmin;

import client.classi.AES;
import org.json.*;
import java.io.IOException;
import java.sql.SQLException;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import server.ApplicationCredentials;

/**
 * Resource which has only one representation.
 */
public class Registrazione extends ServerResource{
    
    
    @Post
    public String postRequest(String data) throws SQLException, ClassNotFoundException, IOException {
        JSONObject json = new JSONObject(data); //convertilo in file jsonObject
        //leggi i campi chiave:valore
        String username = json.getString("username");
        String password = json.getString("password");
        String encryptedString = AES.encrypt(password, new ApplicationCredentials().getsecretkey());
        //System.out.println("Password cifrata: "+encryptedString);
        //Esegui il metodo queryRegistration passando i valori inseriti dal client
        Integer result1 = new DatabaseHandler().QueryRegistration(username, encryptedString);
        return result1.toString();
    }
}
    
   
