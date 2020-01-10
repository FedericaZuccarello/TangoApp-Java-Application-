/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.linkedin;

import client.Client;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import server.ApplicationCredentials;


/**
 *
 * @author Zuccarello Federica
 */
public class LinkedinSuccess extends ServerResource {
    private static String persona;
    @Get
    public String getLog() throws Exception{
        String error = getQueryValue("error");
        String state = getQueryValue("state");
        //se il client non ha commesso errori in fase di autenticazione o rifiutato il consenso
        //e lo stato di sicurezza è uguale a quello di partenza autenticalo
        if(error == null && state.equals(new ApplicationCredentials().getstate())){
            //System.out.println("non ci sono errori e attacchi");
            
            String code = getQueryValue("code");
            
            LinkedinAPI link = new LinkedinAPI();
            LinkedInProfile profilo = link.sendPost(code);
            persona = "{id:'"+profilo.getId()+"',nome:'" + profilo.getFirstName()+ "',cognome:'"+ profilo.getLastName()+"'}";
            new Client().getPersona();
            //link.closeBrowser();

        return "Autenticato";
        //se lo stato è diverso
        }else if(!state.equals(new ApplicationCredentials().getstate())){
            return "Non autenticato! Probabile attacco CSRF!";
        }else{
            String errorDescription = getQueryValue("error_description");
            return errorDescription;
        }
        
    }
    public String getPersona(){
        return persona;
    }
}
