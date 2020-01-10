package client.classi;


/**
 *
 * @author Zuccarello Federica
 */
public class Anagrafica {
    private String nome, cognome;
    
    public Anagrafica(){
    }
    
    public Anagrafica(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }
    
    public String setNome(String nome){
        this.nome = nome;
        return nome;
    }
    public String setCognome(String cognome){
        this.cognome = cognome;
        return cognome;
    }
    public String getNome(){
        return this.nome;
    }
    public String getCognome(){
        return this.cognome;
    }
    
    @Override
    public String toString(){
        return this.nome + " " + this.cognome;
    }
}
