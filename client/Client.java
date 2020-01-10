package client;

import client.classi.Credenziali;
import client.connServer.ConnectionHTTP;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import org.json.JSONObject;
import server.linkedin.LinkedinSuccess;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zuccarello Federica
 */
public class Client extends ConnectionHTTP {

    /**
     * Creates new form Form
     */
    //JFrame frame;
    public Client() {
        //this.frame = new JFrame("Login");
        initComponents();
    }
    
    public String utente;
   /* public Client nomeClient;
    public void closeWindowsLogin(){
        new Client().setVisible(false);
    }*/
     
    public static void main(String[] args) throws Exception {
            
            /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Client client = new Client();
                String title = "Login";
                client.setTitle(title);
                client.setVisible(true);
                }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Username = new java.awt.TextField();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        SalvaButton = new java.awt.Button();
        Password = new javax.swing.JPasswordField();
        LoginButton = new java.awt.Button();
        LinkedinLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        Username.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        label2.setText("Username");

        label3.setText("Password");

        SalvaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SalvaButton.setLabel("Registrati");
        SalvaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClickSalvaDati(evt);
            }
        });

        LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LoginButton.setLabel("Login");
        LoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClicked(evt);
            }
        });

        LinkedinLogin.setBackground(new java.awt.Color(0, 80, 122));
        LinkedinLogin.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        LinkedinLogin.setForeground(new java.awt.Color(255, 255, 255));
        LinkedinLogin.setText("Sign in with Linkedin");
        LinkedinLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LinkedinLoginMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tiranti Solid LET", 0, 36)); // NOI18N
        jLabel4.setText("Login");

        jLabel13.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel13.setText("TANGOapp");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(SalvaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13))
                            .addComponent(LinkedinLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Username, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(Password))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SalvaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(LinkedinLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        SalvaButton.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
            //CLICK DI REGISTRAZIONE   
    private void ClickSalvaDati(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClickSalvaDati
        Credenziali user = new Credenziali();        //instanzio un utente
        user.setUsername(Username.getText());        //setto username
        user.setPassword(Password.getText());       //setto password
        //System.out.println("user: " + user);
        JSONObject json = new JSONObject(user);
        utente = json.toString();
        try {
            verifierCredentialSalva();

        } catch (Exception ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ClickSalvaDati
    //se username e password non sono inseriti entrambi non abilitare il pulsante di salvataggio o login
    public void verifierCredentialSalva() throws Exception {
        if (Username.getText().trim().isEmpty() & Password.getText().trim().isEmpty()){
            LoginButton.setEnabled(false);
            SalvaButton.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Inserisci Username e Password!");
            LoginButton.setEnabled(true);
            SalvaButton.setEnabled(true);
        }else if(Username.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Inserisci Username!");
        }else if(Password.getText().trim().isEmpty()){
           JOptionPane.showMessageDialog(null, "Inserisci Password!");
        }
        else {
            SalvaButton.setEnabled(true);
            LoginButton.setEnabled(true);
            ConnectionHTTP http = new ConnectionHTTP();
            String url = "/registrazione";
            String response = http.sendPost(utente, url);
            if("1".equals(response)){
                
                JOptionPane.showMessageDialog(null, "Registrato");
                                           
            } else{
                //System.out.println(response);
                JOptionPane.showMessageDialog(null, "Ci sono stati problemi nella registrazione, \nRiprova con altre credenziali!");
                        
            }
            Username.setText("");
            Password.setText("");
        }

    }    
 
//CLICK DI LOGIN
    private void MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseClicked
      Credenziali user = new Credenziali();        //instanzio un utente
        user.setUsername(Username.getText());        //setto username
        user.setPassword(Password.getText());       //setto password
        //System.out.println("user: " + user);
        JSONObject json = new JSONObject(user);
        utente = json.toString();            
	
        try {
            verifierCredentialLogin();
        } catch (Exception ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_MouseClicked

String nome;
String cognome;

    public void getPersona() throws Exception{
        String persona = new LinkedinSuccess().getPersona();
        JSONObject json = new JSONObject(persona);
        String idUtenteLinkedin = json.getString("id");
        nome = json.getString("nome");
        cognome = json.getString("cognome");
        //aggiunta account Linkedin su DB
        ConnectionHTTP http = new ConnectionHTTP();
        String usernameNoTrim = nome + cognome;
        String username = usernameNoTrim.replaceAll(" ", "");
        String url = "/login?id_linkedin=" + idUtenteLinkedin + "&username=" + username;
        String result = http.sendGet(url);
        String idUtenteDB;
        //se ha restituito '-1' l'account era nuovo 
        if("-1".equals(result)){
            //prendiamo l'id dell'utente appena registrato su DB
            idUtenteDB = http.sendGet(url);
            
            openHomepage(idUtenteDB);
            
        } else{
            
            idUtenteDB = result;
            openHomepage(idUtenteDB);
        }
        
}
    public void openHomepage(String id) throws Exception{
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //JOptionPane.showMessageDialog(null, "Ciao " + nome + " " + cognome + "! \n"+" Benvenuto in TANGOapp!");
        //Chiudi l'interfaccia Client di login 
        this.setVisible(false);
        this.dispose();
        // AVVIA DA QUI L'INTERFACCIA Homepage!
        Homepage a = new Homepage(id);
        String title = "TANGOapp";
        a.setTitle(title);
        a.setVisible(true);
    }
    private void LinkedinLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LinkedinLoginMousePressed
        ConnectionHTTP con = new ConnectionHTTP();
        String urlLinkedin = "/login/linkedin";
        
        try {
            //invio richiesta autenticazione
            con.sendGet(urlLinkedin);
            
        } catch (Exception ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_LinkedinLoginMousePressed

//se username e password non sono inseriti entrambi non abilitare il pulsante di salvataggio o login
    public void verifierCredentialLogin() throws Exception {
        if (Username.getText().trim().isEmpty() & Password.getText().trim().isEmpty()){
            LoginButton.setEnabled(false);
            SalvaButton.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Inserisci Username e Password!");
            LoginButton.setEnabled(true);
            SalvaButton.setEnabled(true);
        }else if(Username.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Inserisci Username!");
        }else if(Password.getText().trim().isEmpty()){
           JOptionPane.showMessageDialog(null, "Inserisci Password!");
        }
        else {
            SalvaButton.setEnabled(true);
            LoginButton.setEnabled(true);
            ConnectionHTTP http = new ConnectionHTTP();
            String url = "/login";
            String result = http.sendPost(utente, url);
            
            if(!"-1".equals(result)){        
            Username.setText("");
            Password.setText("");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            //dispose();
            //frame.setVisible(false);
                    //System.out.println("Autenticato: " + new String(responseBody));
                    JOptionPane.showMessageDialog(null, "Autenticato!");
                    //Chiudi l'interfaccia Client di login  
                    this.dispose();
                    // AVVIA DA QUI L'INTERFACCIA Homepage!
                        
                        Homepage a = new  Homepage(result);
                        a.setVisible(true);
                        
                    } else{
                        //System.out.println("Password o Username sbagliati!");
                        JOptionPane.showMessageDialog(null, "Username o password errati!");
                        
                    }
            Username.setText("");
            Password.setText("");
        }

    }    
 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LinkedinLogin;
    private java.awt.Button LoginButton;
    private javax.swing.JPasswordField Password;
    private java.awt.Button SalvaButton;
    private java.awt.TextField Username;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private java.awt.Label label2;
    private java.awt.Label label3;
    // End of variables declaration//GEN-END:variables
}