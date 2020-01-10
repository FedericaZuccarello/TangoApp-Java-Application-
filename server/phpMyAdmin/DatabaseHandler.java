/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.phpMyAdmin;

import com.itextpdf.text.Document;
import java.sql.*;
import java.util.*;
import java.io.*;

public class DatabaseHandler {
    Statement cmd = null;
    ResultSet result  = null;
    
    public Connection ConnectionDB() throws ClassNotFoundException, IOException, SQLException{
        Connection con = null;
        
        Properties p = new Properties();
        p.load(new FileInputStream("config.properties"));
        String driver = p.getProperty("jdbcDriver");
        Class.forName(driver);
        String url = p.getProperty("jdbcUrl");
        con = DriverManager.getConnection (url);
       
        return con;
    }
    
    public Integer QueryRegistration(String username, String password) throws SQLException, ClassNotFoundException, IOException{
        Integer risultato  = null;
        Connection con = ConnectionDB();
        cmd = con.createStatement ();
        
        String qry = "SELECT * FROM utenti WHERE username = '"+ username+"' AND password = '"+password+"'";
        result = cmd.executeQuery(qry);
        int count = 0;
        while(result.next()){
            count = count+1;
        }
        if (count==1){
            risultato = 0;
        }else {
            String qry1 = "INSERT INTO `utenti`(`username`, `password`) "
                + "VALUES ('" + username + "','" + password + "')";
            System.out.println(qry1);
            int result1 = cmd.executeUpdate(qry1);
            
            risultato = 1;
        }
        cmd.close();
        con.close();
             
        return risultato;
   }
    
    public String QueryLogin(String username, String password) throws SQLException, ClassNotFoundException, IOException{
        Connection con = ConnectionDB();
        cmd = con.createStatement ();
        String qry = "SELECT * FROM utenti WHERE username = '"+ username+"' AND password = '"+password+"'";
        result = cmd.executeQuery(qry);
        String Risultato = "null";
        String idUtente;
        int count = 0;
        while(result.next()){
            idUtente = result.getString("id");
            Risultato = idUtente;
            count = count+1;
        }
        if (count==0){
            Risultato = "-1";
        }

             result.close();
             cmd.close();
             con.close();
        //questo result restituisce il numero di righe nella tabella     
        return Risultato;
   } 
    
    //inserimento nuovo progetto
    public String QuerypostProject(String nome, String data, String idUtente) throws ClassNotFoundException, IOException, SQLException{
        ResultSet result  = null;
        String idProgetto = null; 
        try (Connection con = ConnectionDB()) {
            cmd = con.createStatement ();
            //inserimento progetto
            String qry1 = "INSERT INTO `progetti`(`nome`, `data`, `id_utente`) "
                    + "VALUES ('" + nome + "','" + data +"','" + idUtente + "')";
            System.out.println("Query: "+qry1);
            cmd.executeUpdate(qry1);
            //restituire id progetto appena creato
            String qry2 = "SELECT `id` FROM `progetti` ORDER BY `id` DESC LIMIT 1";
            System.out.println("Query: "+qry2);
            result = cmd.executeQuery(qry2);
            while (result.next()) { 
                idProgetto = result.getString("id");
            }
            System.out.println("Risposta: "+idProgetto);
        }
        return idProgetto;
    }
    //inserimento luoghi visitati
    public String QuerypostCity(String stato, String citta, String id_progetto) throws ClassNotFoundException, IOException, SQLException{
            Integer result;
        
        try (Connection con = ConnectionDB()) {
            cmd = con.createStatement ();
            
            //inserimento luogo
            String qry3 = "INSERT INTO `luoghi`(`citta`, `stato`, `id_progetto`) "
                    + "VALUES ('" + citta + "','" + stato +"','" + id_progetto + "')";
            System.out.println("Query: "+qry3);
            result = cmd.executeUpdate(qry3);
            cmd.close();
        }
             
        return result.toString(); 
    }
    //inserimento note
    public String QuerypostNote(String nome, String id_progetto) throws ClassNotFoundException, IOException, SQLException{
            Integer result;
        
        try (Connection con = ConnectionDB()) {
            cmd = con.createStatement ();
            
            //inserimento luogo
            String qry = "INSERT INTO `note`(`nome`, `id_progetto`) "
                    + "VALUES ('" + nome +"','" + id_progetto + "')";
            System.out.println("Query: "+qry);
            result = cmd.executeUpdate(qry);
            cmd.close();
        }
             
        return result.toString(); 
    }
    //get tutto il progetto esistente
    public List<String> QuerygetFullProject(String idUtente) throws ClassNotFoundException, IOException, SQLException{
        String id, nomeProgetto, stato, citta, dataCreazione;
        List<String> data = new ArrayList<String>();
        try (Connection con = ConnectionDB()) {
            cmd = con.createStatement ();
            
            String qry = "SELECT DISTINCT progetti.id as id, progetti.nome as nomeProgetto, luoghi.citta as citta, luoghi.stato as stato, "
                    + "progetti.data as dataCreazione FROM progetti, luoghi, utenti "
                    + "WHERE progetti.id = luoghi.id_progetto AND progetti.id_utente ="+idUtente;
            result = cmd.executeQuery(qry);
            if (!result.next()) {
                
                String risposta = "0";
                data.add(risposta);
               return data;
           }else {
                do {
                    id = result.getString("id");
                    nomeProgetto = result.getString("nomeProgetto");
                    stato = result.getString("stato");
                    citta = result.getString("citta");
                    dataCreazione = result.getString("dataCreazione"); 
                    String json = "{id:"+id+ ",nomeProgetto:"+ nomeProgetto+ ",citta:"+
                            citta + ",stato:" + stato + ",dataCreazione:"+ dataCreazione +"}";
                    data.add(json);
               } while (result.next());
           }
            System.out.println("Query: "+qry);
            System.out.println("Risposta: "+data);
            cmd.close();
        }
             
        return data; 
    }
    //get tutto il progetto esistente
    public List<String> QuerygetProject(String idUtente) throws ClassNotFoundException, IOException, SQLException{
        ResultSet result  = null;
        String id, nomeProgetto, stato, citta, dataCreazione;
        List<String> data = new ArrayList<String>();
        try (Connection con = ConnectionDB()) {
            cmd = con.createStatement ();
            
            String qry = "SELECT progetti.id as id, progetti.nome as nomeProgetto FROM progetti WHERE progetti.id_utente ="+idUtente;
            result = cmd.executeQuery(qry);
            if (!result.next()) {
                String risposta = "Create a new project";
                data.add(risposta);
               return data;
           }else {
               do {
                    id = result.getString("id");
                    nomeProgetto = result.getString("nomeProgetto"); 
                    String json = "{id:"+id+ ",nomeProgetto:"+ nomeProgetto+ "}";
                    data.add(json);
               } while (result.next());
           }
            System.out.println("Query: "+qry);
            System.out.println("Risposta: "+data);
            cmd.close();
        }
             
        return data; 
    }
    //get tutto il progetto esistente
    public List<String> QuerygetProjectByID(String idProgetto) throws ClassNotFoundException, IOException, SQLException{
        ResultSet result  = null;
        String nomeProgetto;
        List<String> data = new ArrayList<>();
        try (Connection con = ConnectionDB()) {
            cmd = con.createStatement ();
            
            String qry = "SELECT progetti.nome as nomeProgetto FROM progetti WHERE progetti.id ="+idProgetto;
            result = cmd.executeQuery(qry);
            if (!result.next()) {
                String risposta = "Create a new project";
                data.add(risposta);
               return data;
           }else {
               do {
                    nomeProgetto = result.getString("nomeProgetto"); 
                    String json = "{nomeProgetto:"+ nomeProgetto+ "}";
                    data.add(json);
               } while (result.next());
           }
            System.out.println("Query: "+qry);
            System.out.println("Risposta: "+data);
            cmd.close();
        }
             
        return data; 
    }
    //get statistiche progetto
    public List<String> QuerygetStatistics() throws ClassNotFoundException, IOException, SQLException{
        ResultSet result  = null;
        String stato, tot;
        List<String> data = new ArrayList<String>();
        try (Connection con = ConnectionDB()) {
            cmd = con.createStatement ();
            
            String qry = "select luoghi.stato as stato, count(luoghi.stato) as tot from luoghi group by luoghi.stato";
            result = cmd.executeQuery(qry);
            if (!result.next()) {
                String risposta = "0";
                data.add(risposta);
               return data;
           }else {
               do {
                    stato = result.getString("stato");
                    tot = result.getString("tot");
                    String json = "{stato:"+stato+ ",tot:"+ tot +"}";
                    data.add(json);
               } while (result.next());
           }
            System.out.println("Query: "+qry);
            System.out.println("Risposta: "+data);
            cmd.close();
        }
             
        return data; 
    }
    //inserimento PDF
    public String QuerypostPDF(Document document, String uniCode, String idUtente, String nomeFile) throws ClassNotFoundException, IOException, SQLException{
        try (Connection con = ConnectionDB()) {
            cmd = con.createStatement ();
            //ricerca id docuemnto
            String qry2 = "SELECT `idUnivoco` FROM `pdf`";
            System.out.println("Query: "+qry2);
            result = cmd.executeQuery(qry2);
            while (result.next()) { 
                String id = result.getString("idUnivoco");
                if(id.equals(idUtente)) return "-1";            
            }
            //inserimento progetto
            String qry1 = "INSERT INTO `pdf`(`idUnivoco`, `nome_file`, `contenuto`, `id_utente`) "
                    + "VALUES ('" + uniCode + "','" + nomeFile +"','" + document +"','" + idUtente + "')";
            System.out.println("Query: "+qry1);
            int a = cmd.executeUpdate(qry1);
            
            System.out.println("Response: "+ a);
        }
        return "OK";
    }
    //inserimento PDF
    public String QuerygetPDF(String uniCode) throws ClassNotFoundException, IOException, SQLException{
        String nome;
        try (Connection con = ConnectionDB()) {
            cmd = con.createStatement ();
            //ricerca id docuemnto
            String qry = "SELECT `nome_file`  FROM `pdf` WHERE `idUnivoco`='" + uniCode+"'";
            System.out.println("Query: "+qry);
            result = cmd.executeQuery(qry);
            if (!result.next()) {
               return "0";
           }else {
               do {
                   nome = result.getString("nome_file");
               } while (result.next());
           }
            
            cmd.close();
        }
        return nome;
    }

    public String QueryLinkedin(String username, String id_linkedin) throws SQLException, ClassNotFoundException, IOException{
        String risultato  = null;
        Connection con = ConnectionDB();
        cmd = con.createStatement ();
        String id = null;
        String qry = "SELECT id FROM utenti WHERE id_linkedin = '"+ id_linkedin+"'";
        System.out.println("Query: "+qry);
        result = cmd.executeQuery(qry);
        
        int count = 0;
        while(result.next()){
            id = result.getString("id");
            count = count+1;
        }
        if (count==1){
            System.out.println(id);
            risultato = id;
        }else {
            //se non l'ho trovato lo aggiungo
            String qry1 = "INSERT INTO `utenti`(`username`, `id_linkedin`) "
                + "VALUES ('" + username + "','" + id_linkedin + "')";
            System.out.println("Query: "+qry1);
            cmd.executeUpdate(qry1);
            
            risultato = "-1";
        }
        cmd.close();
        con.close();
             
        return risultato;
   }
}