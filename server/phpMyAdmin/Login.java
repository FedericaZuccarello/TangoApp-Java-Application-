package server.phpMyAdmin;

import client.classi.AES;
import java.io.IOException;
import java.sql.SQLException;
import org.json.JSONObject;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import server.ApplicationCredentials;

/**
 * Resource which has only one representation.
 */
public class Login extends ServerResource {

    @Post
    public String postRequest(String data) throws SQLException, ClassNotFoundException, IOException {
        JSONObject json = new JSONObject(data); //convertilo in file jsonObject
        //leggi i campi chiave:valore
        String username = json.getString("username");
        String password = json.getString("password");
        String decryptedString = AES.encrypt(password, new ApplicationCredentials().getsecretkey()) ;
        //Esegui il metodo querylogin passando i valori inseriti dal client
        String result = new DatabaseHandler().QueryLogin(username, decryptedString);
        
        return  result;
    }

  
    @Get
    public String getLinkedin()  throws Exception{
        
        String username = getQueryValue("username");
        String id_linkedin = getQueryValue("id_linkedin");
        //Esegui il metodo querylogin passando i valori inseriti dal client
        String result = new DatabaseHandler().QueryLinkedin(username, id_linkedin);
        
        return  result;
    }
}
