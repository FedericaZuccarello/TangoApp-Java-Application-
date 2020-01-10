/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.HERE.HEREweather;

import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Zuccarello Federica
 */
public class HEREweather extends ServerResource {
    @Post
    public String getAstronomy(String citta) throws Exception{
        HEREweatherAPI meteo = new HEREweatherAPI();
        String response = meteo.sendGet(citta);
        return response;
    }
}
