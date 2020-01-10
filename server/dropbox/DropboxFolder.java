package server.dropbox;

import java.io.IOException;
import java.sql.SQLException;
import org.json.JSONObject;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 * Resource which has only one representation.
 */
public class DropboxFolder extends ServerResource {
    
    String folderDefault = "/ProgettoJava/";
    
    @Post
    public String postRequest(String path) throws SQLException, ClassNotFoundException, IOException, Exception {
        
        JSONObject json = new JSONObject(path); //convertilo in file jsonObject
        //leggi i campi chiave:valore
        String pathDaCreare = json.getString("folder");
        DropboxAPI folder = new DropboxAPI();
        String folderName = folderDefault + pathDaCreare;
        String risposta = folder.createFolder(folderName);
        if ("OK".equals(risposta)){
        return  "Progetto creato!";
        }else{
        return "Nome del file invalido o già esistente!";
        }
    }

    @Get
    public String getFolder() throws Exception{
        String cartellaAttuale = getQueryValue("folder");
        DropboxAPI folder = new DropboxAPI();
        String output = folder.listFolder(folderDefault+cartellaAttuale);
        return output;
    }
      
}