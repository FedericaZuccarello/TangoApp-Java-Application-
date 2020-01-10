package server.dropbox;

import java.io.IOException;
import java.sql.SQLException;
import org.json.JSONObject;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 * Resource which has only one representation.
 */
public class DropboxDeleteNota extends ServerResource {
    
    String folderDefault = "/ProgettoJava/";
    
    @Post
    public String postRequest(String nomeNota) throws SQLException, ClassNotFoundException, IOException, Exception {
        
        JSONObject json = new JSONObject(nomeNota); //convertilo in file jsonObject
        //leggi i campi chiave:valore
        String nome = json.getString("name");
        System.out.println(nome);
        DropboxAPI api = new DropboxAPI();
        String folderName = folderDefault + nome;
        //String newFolderName = folderName + "/NewFolder";
        api.delete(folderName);
        
        
        return  "Eliminato!";
    }

   
}