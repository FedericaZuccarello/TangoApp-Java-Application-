/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.phpMyAdmin;

import java.sql.ResultSet;
import java.util.List;
import org.json.JSONObject;
import server.phpMyAdmin.DatabaseHandler;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;


/**
 *
 * @author Zuccarello Federica
 */
public class SalvaDatiDB extends ServerResource{
    //salva il progetto in DB e restituisce l'id del progetto
    @Post
    public String postDati(String dati) throws Exception{
        //convertilo in file jsonObject
        JSONObject json = new JSONObject(dati); 
        //leggi i campi chiave:valore
        String citta = json.getString("citta");
        String stato = json.getString("stato");
        String id_progetto = json.getString("id_progetto");
        
        DatabaseHandler db = new DatabaseHandler();
        String risultato = db.QuerypostCity(stato, citta, id_progetto);
        return risultato;
    }
    @Get
    public String getStatistiche() throws Exception{
        String db = new DatabaseHandler().QuerygetStatistics().toString();
        return db;
    }
}