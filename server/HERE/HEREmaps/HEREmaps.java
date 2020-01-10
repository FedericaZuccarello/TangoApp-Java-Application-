/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.HERE.HEREmaps;

import org.json.JSONObject;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Zuccarello Federica
 */
public class HEREmaps extends ServerResource {
    @Post
    public String getMaps(String data) throws Exception{
        JSONObject json = new JSONObject(data); //convertilo in file jsonObject
        //leggi i campi chiave:valore
        String citta = json.getString("citta");
        
        String stato = json.getString("stato");
       
        String ampiezza = json.getString("ampiezza");
        
        HEREmapsAPI maps = new HEREmapsAPI();
        String responseAPI = maps.sendGet(citta, stato, ampiezza);
        //System.out.println(responseAPI);
        return responseAPI;
    }
}
