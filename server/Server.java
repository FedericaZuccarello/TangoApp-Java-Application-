
package server;

import org.restlet.Component;
import org.restlet.data.Protocol;

/**
 *
 * @author Zuccarello Federica
 */
public class Server extends Thread
{
    public static void main(String[] args) throws Exception 
    {  
    
        // Create a new Component.  
        Component component = new Component();  

        // Add a new HTTP server listening on port 4000. 
        int porta = 4000;
        component.getServers().add(Protocol.HTTP, porta);
        
        // Attach the sample application.  

        component.getDefaultHost().attach("/mioServer",  
                new Root());  

        // Start the component.  
        component.start();  
    }
}
