/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.phpMyAdmin;

import org.json.JSONObject;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;


/**
 *
 * @author Zuccarello Federica
 */
public class SalvaProjectDB extends ServerResource{
    //salva il progetto in DB e restituisce l'id del progetto
    @Post
    public String postDati(String dati) throws Exception{
        //convertilo in file jsonObject
        JSONObject json = new JSONObject(dati); 
        //leggi i campi chiave:valore
        String nome = json.getString("nomeProgetto");
        String dataRicerca = json.getString("dataRicerca");
        String id_utente = json.getString("id_utente");
        
        DatabaseHandler db = new DatabaseHandler();
        String id_progetto = db.QuerypostProject(nome, dataRicerca, id_utente);
        return id_progetto;
    }
    
}