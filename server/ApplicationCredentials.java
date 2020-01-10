package server;

public class ApplicationCredentials {
    //AES
    private static final String secretKey = "*****************************";
    //DROPBOX
    private static final String tokenDropbox = "Bearer **********************************************";
    //HERE
    private static final String APP_ID = "********************";
    private static final String APP_CODE = "**********************";
    //OPEN WETHER MAPS
    private static final String KEY = "*********************";
    //TRELLO
    private static final String KEYtrello = "****************";
    private static final String TOKENtrello = "*****************************************";
    //LINKEDIN
    private static final String client_id = "*********************";
    private static final String redirect_url = "http://localhost:4000/mioServer/login/linkedin/success";
    private static final String  client_secret = "*************";
    private static final String  state = "**********";
    
    public String getsecretkey(){
        return secretKey;
    }
    public String getclient_id(){
        return client_id;
    }
    public String getredirect_url(){
        return redirect_url;
    }
    public String getclient_secret(){
        return client_secret;
    }
    public String getstate(){
        return state;
    }
    public String gettokenDropbox(){
        return tokenDropbox;
    }
    public String getAPP_ID(){
        return APP_ID;
    }
    public String getAPP_CODE(){
        return APP_CODE;
    }
    public String getKEY(){
        return KEY;
    }
    public String getKEYtrello(){
        return KEYtrello;
    }
    public String getTOKENtrello(){
        return TOKENtrello;
    }
}
