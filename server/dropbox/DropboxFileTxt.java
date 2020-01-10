package server.dropbox;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 * Resource which has only one representation.
 */
public class DropboxFileTxt extends ServerResource {
    
    
    String folderDefault = "/ProgettoJava/";
    
    @Post
    public String postRequest(String file) throws SQLException, ClassNotFoundException, IOException, Exception {
        //converti nomeFile in file jsonObject
        JSONObject json = new JSONObject(file); 
        
        //leggi i campi chiave:valore
        String nomeFileDaCreare = json.getString("name");
        String directoryCorrente = json.getString("directory");
        
        //creare un oggetto dalla classe DropboxAPI
        DropboxAPI drop = new DropboxAPI();
        //utilizzail metodo della classe listFolder
        //che legge i file da Dropbox nella cartella folderDefault e nella cartella del progetto selezionato
        String fileImportato = drop.listFolder(folderDefault + directoryCorrente + "/");
        
        // RENDERE UNA STRINGA (fileImportato) UN OGGETTO JSON
        JSONObject jsonObject = new JSONObject(fileImportato);
        //prendi dall'oggettoJSON, l'array entries 
        JSONArray jsonArray = jsonObject.getJSONArray("entries");
        JSONObject explrObject = null;
        //inizializzo la variabile a 0 (non ci sono doppioni) per sovrascriverla
        //nel while con 1 (se ci sono doppioni)
        String variabileProva = "0"; 
        int i = 0;
        //leggi i valori dell'array e prendi quelli con valore:nome
        while (i < jsonArray.length()) {                       
            explrObject = jsonArray.getJSONObject(i);
            String folderName = explrObject.getString("name");
            Object data [] = {folderName};
            System.out.println(Arrays.toString(data));
            String nomeFileArray = "["+ nomeFileDaCreare + ".txt]";
            System.out.println(nomeFileArray);
            if(Arrays.toString(data).equals(nomeFileArray)){
                variabileProva = "1";
            }
            i++;
        }
        String variabileDaRestituire;
        switch (variabileProva) {
            //se il while ha restituito 1, ci sono doppioni, quindi ritorna 0(Nota non Creata);
            case "1":
                System.out.println("l'if ha restituito" + variabileProva);
                variabileDaRestituire = "0";
            //se il while ha restituito 0, non ci sono doppioni, quindi ritorna 1(Nota Creata);
            case "0":
                System.out.println("l'if ha restituito" + variabileProva);
                //attribuisco al file l'estensione
                String nomeFileComplete = nomeFileDaCreare + ".txt";
                //creare il file txt in NoteDiProva temporaneamente per caricarlo su Dropbox
                PrintWriter fileTxt = new PrintWriter("NoteDiProva/" + nomeFileComplete);
                //prendi il testo
                String text = json.getString("text");
                //inseriscilo nel file
                fileTxt.print(text); //salva prima nella RAM
                fileTxt.close();// salva nel documento
                //inserisco il file su dropbox
                DropboxAPI fileD = new DropboxAPI();
                fileD.putFile(folderDefault + directoryCorrente + nomeFileComplete, "NoteDiProva/" + nomeFileComplete);
                //Cancello il file creato
                deleteFileTxt("NoteDiProva/" + nomeFileComplete);
                System.out.println("Ho eliminato il file che ho salvato");
                variabileDaRestituire = "1";
                break;
            default:
            System.out.println("l'if ha restituito" + variabileProva);  
            variabileDaRestituire= "-1";    
        }
        return variabileDaRestituire;
    
    }
     
    //metodo che fa i controlli necessari per l'eliminazione del file txt su locale
    public void deleteFileTxt(String fileName){
        File f = new File(fileName);
            // Mi assicuro che il file esista
            if (!f.exists())
              throw new IllegalArgumentException("Il File o la Directory non esiste: " + fileName);

            // Mi assicuro che il file sia scrivibile
            if (!f.canWrite())
              throw new IllegalArgumentException("Non ho il permesso di scrittura: " + fileName);

            // Se e' una cartella verifico che sia vuota
            if (f.isDirectory()) {
              String[] files = f.list();
              if (files.length > 0)
                throw new IllegalArgumentException("La Directory non e' vuota: " + fileName);
            }

            // Provo a cancellare
            boolean success = f.delete();

             // Se si e' verificato un errore...
            if (!success)
              throw new IllegalArgumentException("Cancellazione fallita");
        }

}