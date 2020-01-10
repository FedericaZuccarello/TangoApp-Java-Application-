/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.Wikipedia;

import java.io.IOException;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 *
 * @author Zuccarello Federica
 */
public class WikipediaAPI {
    private static final String LANG = "it";
    private static final String ACTION = "query";
    private static final String FORMAT = "json";
    private static final String NUMCHARS = "800";
    // HTTP GET request
	public String sendGet(String title) throws Exception {
            String url = "https://"+LANG+".wikipedia.org/w/api.php?action="+ACTION
                    +"&format="+FORMAT+"&prop=extracts%7Cdescription&titles="+title
                    +"&exchars="+NUMCHARS+"&explaintext=1&exsectionformat=plain";
               
            HttpClient client = new HttpClient();
                        
            GetMethod method = new GetMethod(url);
            
            client.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
              new DefaultHttpMethodRetryHandler());
            String daInviare = null;
            try {
            
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
              System.err.println("Method failed: " + method.getStatusLine());
            }
            //******Read the Response
            byte[] responseBody = method.getResponseBody();
                
            String response = new String(responseBody, "UTF-8");
            daInviare = response;
            
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + statusCode);
            
                    } catch (HttpException e) {
              System.err.println("Fatal protocol violation: " + e.getMessage());
              e.printStackTrace();
            } catch (IOException e) {
              System.err.println("Fatal transport error: " + e.getMessage());
              e.printStackTrace();
            } finally {
                            
              method.releaseConnection();
            }
            return daInviare;
	}
}
