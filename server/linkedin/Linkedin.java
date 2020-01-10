/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.linkedin;


import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.restlet.service.StatusService;


/**
 *
 * @author Zuccarello Federica
 */
public class Linkedin extends ServerResource{
   
    @Get
    public String getLink() throws Exception{
            LinkedinAPI linkedin = new LinkedinAPI();
            linkedin.sendGetLinkedin();
        return "OK";
    }

    
}
