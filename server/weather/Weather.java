/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.weather;

import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;


/**
 *
 * @author Zuccarello Federica
 */
public class Weather extends ServerResource {
    @Post
    public String getMeteo(String citta) throws Exception{
        WeatherAPI meteo = new WeatherAPI();
        String responseMeteo = meteo.sendGet(citta);
        return responseMeteo;
    }
}
