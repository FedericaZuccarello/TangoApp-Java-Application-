/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.Wikipedia;

import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Zuccarello Federica
 */
public class Wikipedia extends ServerResource{
    @Post
    public String getWiki(String title) throws Exception{
        WikipediaAPI wiki = new WikipediaAPI();
        String responseWiki = wiki.sendGet(title);
        return responseWiki;
    }
}
