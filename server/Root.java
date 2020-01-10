package server;

import server.phpMyAdmin.SalvaDatiDB;
import server.linkedin.LinkedinSuccess;
import server.phpMyAdmin.Registrazione;
import server.phpMyAdmin.Login;
import server.weather.Weather;
import server.dropbox.DropboxGetNota;
import server.dropbox.DropboxFileTxt;
import server.dropbox.DropboxFolder;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import server.HERE.HEREmaps.HEREmaps;
import server.HERE.HEREweather.HEREweather;
import server.Wikipedia.Wikipedia;
import server.dropbox.DropboxDeleteNota;
import server.generatorePDF.generatorePDF;
import server.linkedin.Linkedin;
import server.phpMyAdmin.GetFullProject;
import server.phpMyAdmin.GetProject;
import server.phpMyAdmin.SalvaNoteDB;
import server.phpMyAdmin.SalvaProjectDB;

public class Root extends Application {

    /**
     * Crea un Restlet di root che riceverà tutte le chiamate in arrivo.
     * @return 
     */
    @Override
    public synchronized Restlet createInboundRoot() {
        // Crea un router Restlet che instrada ogni chiamata alla relativa risorsa.
        Router router = new Router(getContext());

        // Definizioni risorse a cui instradare la richiesta
        router.attach("/registrazione", Registrazione.class);
        router.attach("/login", Login.class);
        router.attach("/dropbox/folder", DropboxFolder.class);
        router.attach("/dropbox/file", DropboxFileTxt.class);
        router.attach("/dropbox/nota", DropboxGetNota.class);
        router.attach("/dropbox/delete/nota", DropboxDeleteNota.class);
        router.attach("/weather", Weather.class);
        router.attach("/HEREmaps", HEREmaps.class);
        router.attach("/astronomy", HEREweather.class);
        router.attach("/wikipedia", Wikipedia.class);
        router.attach("/login/linkedin", Linkedin.class);
        router.attach("/login/linkedin/success", LinkedinSuccess.class);
        router.attach("/DB", SalvaDatiDB.class);
        router.attach("/DB/project/full", GetFullProject.class);
        router.attach("/DB/project", GetProject.class);
        router.attach("/DB/project/salve", SalvaProjectDB.class); 
        router.attach("/DB/project/note", SalvaNoteDB.class); 
        router.attach("/generaPDF", generatorePDF.class);
        
        return router;
    }

}

