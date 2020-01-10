/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.HERE.HEREmaps;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import server.ApplicationCredentials;
/**
 *
 * @author Zuccarello Federica
 */
public class HEREmapsAPI {
    
    
     //<< http://hc.apache.org/httpclient-3.x/tutorial.html >>

        // HTTP GET request
	public String sendGet(String citta, String stato, String dimensione) throws Exception {
            String daInviare = null;
            String urlImage;
            String nomeImg;
            //se non viene specificata la citta:
            if("null".equals(citta)){
                urlImage = "https://image.maps.api.here.com/mia/1.6/mapview?co="+stato+"&i=1&app_id="+new ApplicationCredentials().getAPP_ID()+"&app_code="+new ApplicationCredentials().getAPP_CODE()+"&w="+ dimensione;
                nomeImg = stato;
                //se non viene specificato lo stato:
            }else if("null".equals(stato)){
                urlImage = "https://image.maps.api.here.com/mia/1.6/mapview?i=1&app_id="+new ApplicationCredentials().getAPP_ID()+"&app_code="+new ApplicationCredentials().getAPP_CODE()+"&ci="+citta+"&w="+ dimensione;
                nomeImg = citta;
                //se non viene specificato lo stato e la dimensione di ritorno della mappa:
            }else if("null".equals(stato) & "null".equals(dimensione)){
                urlImage = "https://image.maps.api.here.com/mia/1.6/mapview?i=1&app_id="+new ApplicationCredentials().getAPP_ID()+"&app_code="+new ApplicationCredentials().getAPP_CODE()+"&ci="+citta;
                nomeImg = citta;
                //se non viene specificata la citta e la dimensione di ritorno della mappa:
            }else if("null".equals(citta) & "null".equals(dimensione)){
                urlImage = "https://image.maps.api.here.com/mia/1.6/mapview?co="+stato+"&i=1&app_id="+new ApplicationCredentials().getAPP_ID()+"&app_code="+new ApplicationCredentials().getAPP_CODE();
                nomeImg = stato;
                //se non viene specificata la dimensione di ritono della mappa:
            }else if("null".equals(dimensione)){
                urlImage = "https://image.maps.api.here.com/mia/1.6/mapview?co="+stato+"&i=1&app_id="+new ApplicationCredentials().getAPP_ID()+"&app_code="+new ApplicationCredentials().getAPP_CODE()+"&ci="+citta;
                nomeImg = citta;
                //se vengono specificati tutti i campi
            }else{
                urlImage = "https://image.maps.api.here.com/mia/1.6/mapview?co="+stato+"&i=1&app_id="+new ApplicationCredentials().getAPP_ID()+"&app_code="+new ApplicationCredentials().getAPP_CODE()+"&ci="+citta+"&w="+ dimensione;
                nomeImg = citta;
            }
            
            URL url = new URL(urlImage);

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
            
            GetMethod method = new GetMethod(urlImage);
            
            
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
            
            
            
            //scrivi l'immagine su file per creare cache
            InputStream is = url.openStream();
            String destinationFile = "src/main/java/client/cache/mapsImage/"+ nomeImg + ".jpg";
            OutputStream os = new FileOutputStream(destinationFile);
            int length;
            while ((length = is.read(responseBody)) != -1) {
                os.write(responseBody, 0, length);
            }
            
            //****Gestire la response
            //Ora abbiamo completato la nostra interazione con HttpClient e 
            //possiamo concentrarci sul fare ciò che dobbiamo fare con i dati. 
            //Nel nostro caso, lo stamperemo semplicemente sulla console. 
            
            
            String response = new String(responseBody);
            
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
              //****Release the Connection
            //Questo è un passo cruciale per far fluire le cose. 
            //Dobbiamo dire a HttpClient che abbiamo terminato la connessione 
            //e che ora può essere riutilizzata. Senza fare questo HttpClient 
            //attenderà indefinitamente per liberare una connessione in modo 
            //che possa essere riutilizzata.
                
              method.releaseConnection();
            }
            
            return daInviare;
	
        }
        
        }

