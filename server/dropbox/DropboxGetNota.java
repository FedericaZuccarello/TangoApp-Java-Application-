package server.dropbox;

import java.io.IOException;
import java.sql.SQLException;
import org.json.JSONObject;
import org.restlet.Application;
import static org.restlet.Application.getCurrent;
import org.restlet.resource.Delete;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 * Resource which has only one representation.
 */
public class DropboxGetNota extends ServerResource {
    
    String folderDefault = "/ProgettoJava/";
    
    @Post
     public String postRequest(String dati) throws SQLException, ClassNotFoundException, IOException, Exception {
         //convertilo in file jsonObject
         JSONObject json = new JSONObject(dati); 
        //leggi i campi chiave:valore
        String nomeNota = json.getString("nomeNota");
        String pathNota = json.getString("pathNota");
        DropboxAPI drop = new DropboxAPI();
        String risposta = drop.getFile(folderDefault + pathNota+ "/" + nomeNota);
        return  risposta;
   
    }
    @Delete
    public String deleteRequest() throws SQLException, ClassNotFoundException, IOException, Exception {
        Application file = getCurrent();
        System.out.println(file);
        return "il file inviato è " + file;
    }
}
