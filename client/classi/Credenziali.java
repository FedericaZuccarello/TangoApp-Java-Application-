/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.classi;

/**
 *
 * @author Zuccarello Federica
 */
public class Credenziali {

    private String username, password;
    
    public Credenziali(){
    }
      
    public String setUsername(String username){
        this.username = username;
        return username;
    }
    public String setPassword(String password){
        this.password = password;
        return password;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return password;
    }
    
    @Override
    public String toString(){
        return this.username + " " + this.password;
    }
    
}   

