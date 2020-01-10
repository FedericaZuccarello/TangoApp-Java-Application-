package server;

public class ApplicationCredentials {
    //AES
    private static final String secretKey = "0yA731AAd7AAAAAAAAAACeZOUcgQdW3KCtacQzq2hJXPlcvPwsP6q9vLXwxOzf4z";
    //DROPBOX
    private static final String tokenDropbox = "Bearer 0yA731AAd7AAAAAAAAAACeZOUcgQdW3KCtacQzq2hJXPlcvPwsP6q9vLXwxOzf4z";
    //HERE
    private static final String APP_ID = "dYOpUJN2TFsWXoh8vuZZ";
    private static final String APP_CODE = "hBUhVZsg6gHhH-f9NEoeYA";
    //OPEN WETHER MAPS
    private static final String KEY = "006d58c4560b501d6e8e48d772fef25b";
    //TRELLO
    private static final String KEYtrello = "fc3f6082c1c014ee9056776d51c0f434";
    private static final String TOKENtrello = "1625be7c8417e9092db98a147df41d26f7359231629dad47adfac140764c396e";
    //LINKEDIN
    private static final String client_id = "86l7lj453im09i";
    private static final String redirect_url = "http://localhost:4000/mioServer/login/linkedin/success";
    private static final String  client_secret = "smNeUCtoLHDu7tSF";
    private static final String  state = "fdfdfdfd";
    
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
