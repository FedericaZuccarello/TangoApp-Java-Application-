/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.connServer;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;


/**
 *
 * @author Zuccarello Federica
 */
public class ConnectionHTTP extends javax.swing.JFrame {
    
    private static final String url = "http://localhost:4000/mioServer";
    
	// HTTP POST request
	public String sendPost(String data, String url) throws Exception {
            
            //<< http://hc.apache.org/httpclient-3.x/tutorial.html >>
            
            String responseClient = null;
            //*****Instantiating HttpClient
            //Il costruttore no argument di HttpClient fornisce un buon set di 
            //valori predefiniti per la maggior parte delle situazioni, 
            //quindi questo è ciò che useremo.    
            HttpClient client = new HttpClient();
            //*****Creating a Method
            // I vari metodi definiti dalla specifica HTTP corrispondono 
            //alle varie classi in HttpClient che implementano l'interfaccia 
            //HttpMethod. Queste classi sono tutte presenti nel pacchetto 
            //org.apache.commons.httpclient.methods. 
 
            // Il metodo post viene utilizzato per richiedere che il server di 
            //origine accetti l'entità inclusa nella richiesta come nuovo 
            //subordinato della risorsa identificata dall'URI di richiesta 
            //nella riga di richiesta
            
            PostMethod post = new PostMethod(ConnectionHTTP.url + url);
           /* NameValuePair[] data = {
                new NameValuePair("nome", "joe"),
                new NameValuePair("cognome", "bloggs")
            };*/
            post.setRequestBody(data);
            
            
            //****Method recovery
            //Per impostazione predefinita, HttpClient tenterà automaticamente 
            //di recuperare dagli errori non fatali, ovvero quando viene generata 
            //una IOException normale. HttpClient riproverà il metodo tre volte, 
            //a condizione che la richiesta non sia mai stata completamente 
            //trasmessa al server di destinazione.
            
            // set per default
            client.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
              new DefaultHttpMethodRetryHandler());
            
            try {
            //****Execute the method
            //L'esecuzione effettiva del metodo viene eseguita chiamando 
            //executeMethod sul client e passando il metodo da eseguire. 
            //Poiché le connessioni di rete sono inaffidabili, dobbiamo anche 
            //occuparci di eventuali errori che si verificano. 
 
            //Esistono due tipi di eccezioni che possono essere lanciate da 
            //executeMethod: HttpException e IOException. 
 
            //L'altra informazione utile è il codice di stato che viene 
            //restituito dal server. Questo codice viene restituito da 
            //executeMethod come int e può essere utilizzato per determinare 
            //se la richiesta ha avuto esito positivo o meno e a volte può 
            //indicare che sono necessarie ulteriori azioni da parte del client, 
            //come la fornitura delle credenziali di autenticazione.
            int statusCode = client.executeMethod(post);

            if (statusCode != HttpStatus.SC_OK) {
              System.err.println("Method failed: " + post.getStatusLine());
            }
            //******Read the Response
            byte[] responseBody = post.getResponseBody();
            
            //****Gestire la response
            //Ora abbiamo completato la nostra interazione con HttpClient e 
            //possiamo concentrarci sul fare ciò che dobbiamo fare con i dati. 
            //Nel nostro caso, lo stamperemo semplicemente sulla console. 
            
            String response = new String(responseBody);
            
            responseClient = response;
            
                    } catch (HttpException e) {
              System.err.println("Fatal protocol violation: " + e.getMessage());
              e.printStackTrace();
            } catch (IOException e) {
              System.err.println("Fatal transport error: " + e.getMessage());
              e.printStackTrace();
            } finally {
              //****Release the Connection
            //Questo è un passo cruciale per far fluire le cose. 
            //Dobbiamo dire a HttpClient che abbiamo terminato la connessione 
            //e che ora può essere riutilizzata. Senza fare questo HttpClient 
            //attenderà indefinitamente per liberare una connessione in modo 
            //che possa essere riutilizzata.
                
              post.releaseConnection();
            } 
            return responseClient;
	}
	
        // HTTP GET request
	public String sendGet(String url) throws Exception {
            String responseClient = null;
            //*****Instantiating HttpClient
            //Il costruttore no argument di HttpClient fornisce un buon set di 
            //valori predefiniti per la maggior parte delle situazioni, 
            //quindi questo è ciò che useremo.    
            HttpClient client = new HttpClient();
            //*****Creating a Method
            // I vari metodi definiti dalla specifica HTTP corrispondono 
            //alle varie classi in HttpClient che implementano l'interfaccia 
            //HttpMethod. Queste classi sono tutte presenti nel pacchetto 
            //org.apache.commons.httpclient.methods. 
 
            //Useremo il metodo Get che è un metodo semplice che prende 
            //semplicemente un URL e ottiene il documento a cui punta l'URL.
            
            GetMethod method = new GetMethod(ConnectionHTTP.url + url);
            
            
            //****Method recovery
            //Per impostazione predefinita, HttpClient tenterà automaticamente 
            //di recuperare dagli errori non fatali, ovvero quando viene generata 
            //una IOException normale. HttpClient riproverà il metodo tre volte, 
            //a condizione che la richiesta non sia mai stata completamente 
            //trasmessa al server di destinazione.
            
            // set per default
            client.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
              new DefaultHttpMethodRetryHandler());
            
            try {
            //****Execute the method
            //L'esecuzione effettiva del metodo viene eseguita chiamando 
            //executeMethod sul client e passando il metodo da eseguire. 
            //Poiché le connessioni di rete sono inaffidabili, dobbiamo anche 
            //occuparci di eventuali errori che si verificano. 
 
            //Esistono due tipi di eccezioni che possono essere lanciate da 
            //executeMethod: HttpException e IOException. 
 
            //L'altra informazione utile è il codice di stato che viene 
            //restituito dal server. Questo codice viene restituito da 
            //executeMethod come int e può essere utilizzato per determinare 
            //se la richiesta ha avuto esito positivo o meno e a volte può 
            //indicare che sono necessarie ulteriori azioni da parte del client, 
            //come la fornitura delle credenziali di autenticazione.
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
              System.err.println("Method failed: " + method.getStatusLine());
            }
            //******Read the Response
            byte[] responseBody = method.getResponseBody();
            
            //****Gestire la response
            //Ora abbiamo completato la nostra interazione con HttpClient e 
            //possiamo concentrarci sul fare ciò che dobbiamo fare con i dati. 
            //Nel nostro caso, lo stamperemo semplicemente sulla console. 
            
            String response = new String(responseBody);
            
            responseClient = response;
                    } catch (HttpException e) {
              System.err.println("Fatal protocol violation: " + e.getMessage());
              e.printStackTrace();
            } catch (IOException e) {
              System.err.println("Fatal transport error: " + e.getMessage());
              e.printStackTrace();
            } finally {
              //****Release the Connection
            //Questo è un passo cruciale per far fluire le cose. 
            //Dobbiamo dire a HttpClient che abbiamo terminato la connessione 
            //e che ora può essere riutilizzata. Senza fare questo HttpClient 
            //attenderà indefinitamente per liberare una connessione in modo 
            //che possa essere riutilizzata.
                
              method.releaseConnection();
            }
            return responseClient;
	}
        // HTTP GET request PDF
	public String sendGetPDF(String url) throws Exception {
            String responseClient = null;
            InputStream responseBody = null;
            //*****Instantiating HttpClient
            //Il costruttore no argument di HttpClient fornisce un buon set di 
            //valori predefiniti per la maggior parte delle situazioni, 
            //quindi questo è ciò che useremo.    
            HttpClient client = new HttpClient();
            //*****Creating a Method
            // I vari metodi definiti dalla specifica HTTP corrispondono 
            //alle varie classi in HttpClient che implementano l'interfaccia 
            //HttpMethod. Queste classi sono tutte presenti nel pacchetto 
            //org.apache.commons.httpclient.methods. 
 
            //Useremo il metodo Get che è un metodo semplice che prende 
            //semplicemente un URL e ottiene il documento a cui punta l'URL.
            
            GetMethod method = new GetMethod(ConnectionHTTP.url + url);
            
            
            //****Method recovery
            //Per impostazione predefinita, HttpClient tenterà automaticamente 
            //di recuperare dagli errori non fatali, ovvero quando viene generata 
            //una IOException normale. HttpClient riproverà il metodo tre volte, 
            //a condizione che la richiesta non sia mai stata completamente 
            //trasmessa al server di destinazione.
            
            // set per default
            client.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
              new DefaultHttpMethodRetryHandler());
            
            try {
            //****Execute the method
            //L'esecuzione effettiva del metodo viene eseguita chiamando 
            //executeMethod sul client e passando il metodo da eseguire. 
            //Poiché le connessioni di rete sono inaffidabili, dobbiamo anche 
            //occuparci di eventuali errori che si verificano. 
 
            //Esistono due tipi di eccezioni che possono essere lanciate da 
            //executeMethod: HttpException e IOException. 
 
            //L'altra informazione utile è il codice di stato che viene 
            //restituito dal server. Questo codice viene restituito da 
            //executeMethod come int e può essere utilizzato per determinare 
            //se la richiesta ha avuto esito positivo o meno e a volte può 
            //indicare che sono necessarie ulteriori azioni da parte del client, 
            //come la fornitura delle credenziali di autenticazione.
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
              System.err.println("Method failed: " + method.getStatusLine());
            }
            //******Read the Response
                responseBody = method.getResponseBodyAsStream();
            
            //****Gestire la response
            //Ora abbiamo completato la nostra interazione con HttpClient e 
            //possiamo concentrarci sul fare ciò che dobbiamo fare con i dati. 
            //Nel nostro caso, lo stamperemo semplicemente sulla console. 
            
            byte[] buffer = new byte[1024 * 1024 * 5];
                String path = null;
                int length;
                while ((length = responseBody.read(buffer)) > 0) {
                    path = new String(buffer);
                }
                System.out.println("Response of service: " + path);
                System.out.println("==================");    
            //String response = new String(responseBody);
            
            //responseClient = response;
                    } catch (HttpException e) {
              System.err.println("Fatal protocol violation: " + e.getMessage());
              e.printStackTrace();
            } catch (IOException e) {
              System.err.println("Fatal transport error: " + e.getMessage());
              e.printStackTrace();
            } finally {
              //****Release the Connection
            //Questo è un passo cruciale per far fluire le cose. 
            //Dobbiamo dire a HttpClient che abbiamo terminato la connessione 
            //e che ora può essere riutilizzata. Senza fare questo HttpClient 
            //attenderà indefinitamente per liberare una connessione in modo 
            //che possa essere riutilizzata.
              responseBody.close();
              method.releaseConnection();
            }
            return responseClient;
	}
        
}
