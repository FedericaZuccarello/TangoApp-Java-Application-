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
public class Progetto {
    private String nomeProgetto;
    private String dataRicerca;
    private String stato= null, citta= null;
    
    public Progetto(){
    }
    
    public Progetto(String nomeProgetto, String stato, String citta, String dataRicerca){
        this.nomeProgetto = nomeProgetto;
        this.stato = stato;
        this.citta = citta;
        this.dataRicerca = dataRicerca;
    }
    public String setNomeProgetto(String nomeProgetto){
        this.nomeProgetto = nomeProgetto;
        return nomeProgetto;
    }
    public String setStato(String stato){    
        this.stato = stato;
        return stato;
    }
    public String setCitta(String citta){
        this.citta = citta;
        return citta;
    }
    public String setDataRicerca(String dataRicerca){
        this.dataRicerca = dataRicerca;
        return dataRicerca;
    }
    
    public String getNomeProgetto(){
        return this.nomeProgetto;
    }
    public String getStato(){
        return this.stato;
    }
    public String getCitta(){
        return this.citta;
    }
    public String getDataRicerca(){
        return this.dataRicerca;
    }
    
}
