package server.dropbox;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import server.ApplicationCredentials;

//References:

//https://dropbox.com
//https://dropbox.github.io/dropbox-api-v2-explorer/
//https://www.dropbox.com/developers/documentation/http/documentation#auth-token-from_oauth1

public class DropboxAPI {

    
    public String listFolder(String foldername) throws Exception {
    String fileDaImportare = "";    
      try {

        URL url = new URL("https://api.dropboxapi.com/2/files/list_folder");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        String parameters = "{\"path\": \"" + foldername + "\",\"recursive\": false,\"include_deleted\": false,\"include_has_explicit_shared_members\": false}";
        
        conn.setRequestProperty("Accept", "application/json");        
        conn.addRequestProperty ("Authorization", new ApplicationCredentials().gettokenDropbox());
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        
        conn.setDoOutput(true);

        DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
        writer.writeBytes(parameters);
        writer.flush();

        if (writer != null)
            writer.close();
        
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
            (conn.getInputStream())));
        
        System.out.println("\nSending 'POST' request to URL : " + url);
	System.out.println("Post parameters : " + parameters);
	System.out.println("Response Code : " + conn.getResponseMessage());
        System.out.println("Output : ");
        String output;
        while ((output = br.readLine()) != null) {
            System.out.println(output);
            fileDaImportare = output;
            }
        
        conn.disconnect();

      } catch (MalformedURLException e) {

        e.printStackTrace();

      } catch (IOException e) {

        e.printStackTrace();

      }
      return fileDaImportare;
    }
    
    public void delete(String path) throws Exception {
        
          try {

            URL url = new URL("https://api.dropboxapi.com/2/files/delete_v2");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String parameters = "{\"path\": \"" + path + "\"}";
            
            conn.setRequestProperty("Accept", "application/json");        
            conn.addRequestProperty ("Authorization", new ApplicationCredentials().gettokenDropbox());
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            
            conn.setDoOutput(true);

            DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
            writer.writeBytes(parameters);
            writer.flush();

            if (writer != null)
                writer.close();
            
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

            String output;
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + parameters);
            System.out.println("Response Code : " + conn.getResponseMessage());
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            
            conn.disconnect();

          } catch (MalformedURLException e) {

            e.printStackTrace();

          } catch (IOException e) {

            e.printStackTrace();

          }

        }
    
    public String createFolder(String path) throws Exception {
        String risposta = null;
          try {

            URL url = new URL("https://api.dropboxapi.com/2/files/create_folder_v2");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String parameters = "{\"path\": \"" + path + "\"}";
            
            conn.setRequestProperty("Content-Type", "application/json");    
            conn.addRequestProperty ("Authorization", new ApplicationCredentials().gettokenDropbox());
            conn.setRequestMethod("POST");
            
            
            conn.setDoOutput(true);

            DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
            writer.writeBytes(parameters);
            writer.flush();

            if (writer != null)
                writer.close();
            
            if (conn.getResponseCode() != 200) {
                System.out.println(conn.getResponseMessage());
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));
            risposta = conn.getResponseMessage();
            String output;
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + parameters);
            System.out.println("Response Code : " + conn.getResponseMessage());
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

          } catch (MalformedURLException e) {

            e.printStackTrace();

          } catch (IOException e) {

            e.printStackTrace();

          }
          return risposta;
        }
    
    public void putFile(String foldername, String path) throws Exception {
        
          try {

            URL url = new URL("https://content.dropboxapi.com/2/files/upload");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String parameters = "{\"path\": \"" + foldername + "\"}";
            
            conn.setRequestProperty("Content-Type", "application/octet-stream");    
            conn.addRequestProperty ("Authorization", new ApplicationCredentials().gettokenDropbox());
            conn.addRequestProperty ("Dropbox-API-Arg", parameters);
            conn.setRequestMethod("POST");
            
            
            conn.setDoOutput(true);

            Path pathFile = Paths.get(path);
            byte[] data = Files.readAllBytes(pathFile);

            DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
            /*
            writer.writeBytes(parameters);
            writer.flush();
            */
            writer.write(data);
            writer.flush();
            
            if (writer != null)
                writer.close();
                        
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

            String output;
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + parameters);
            System.out.println("Response Code : " + conn.getResponseMessage());
            System.out.println("Output : ");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

          } catch (MalformedURLException e) {

            e.printStackTrace();

          } catch (IOException e) {

            e.printStackTrace();

          }

        }
    
    public String getFile(String foldername) throws Exception {
        String fileDaImportare= "";
          try {

            URL url = new URL("https://content.dropboxapi.com/2/files/download");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String parameters = "{\"path\": \"" + foldername + "\"}";
            
            conn.addRequestProperty ("Authorization", new ApplicationCredentials().gettokenDropbox());
            conn.addRequestProperty ("Dropbox-API-Arg", parameters);
            conn.setDoOutput(true);
                                    
            if (conn.getResponseCode() != 200) {
                System.out.println(conn.getResponseMessage());
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

            String output;
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Post parameters : " + parameters);
            System.out.println("Response Code : " + conn.getResponseMessage());
            while ((output = br.readLine()) != null) {
                fileDaImportare = output;
                System.out.println(output);
                
            }

            conn.disconnect();

          } catch (MalformedURLException e) {

            e.printStackTrace();

          } catch (IOException e) {

            e.printStackTrace();

          }
          return fileDaImportare;
        }
    
 
}
