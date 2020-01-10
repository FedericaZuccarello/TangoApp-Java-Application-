/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.phpMyAdmin;

import java.util.List;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Zuccarello Federica
 */
public class GetFullProject extends ServerResource{
    //restituisce i progetti creati con l'id relativo
     @Post
    public String postID(String id) throws Exception{
        DatabaseHandler db = new DatabaseHandler();
        List<String> risposta = db.QuerygetFullProject(id);
        return risposta.toString();
    }
}
