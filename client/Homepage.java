package client;

import client.classi.Progetto;
import client.connServer.ConnectionHTTP;
import client.classi.comboItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Zuccarello Federica
 */
public class Homepage extends ConnectionHTTP {

    /**
     * Creates new form Hompage
     */
    DefaultTableModel model;
    DefaultTableModel model1;
    DefaultTableModel model2;
    public Homepage(String idUtente) throws Exception {
        
        initComponents();
        
        //assegna l'id utente alla variabile globale
        idUtenteLoggato = idUtente;
        //rendere opachi i fogli del jTabbed
        JTabbed.setEnabledAt(2, false);
        JTabbed.setEnabledAt(3, false);
        JTabbed.setEnabledAt(4, false);
        JTabbed.setEnabledAt(5, false); //BLACKBOARD
        JTabbed.setEnabledAt(6, false); //Download
        
        //gestione project detail
        detailProject0.setText(nomeProgettoAttuale);
        detailProject1.setText(nomeProgettoAttuale);
        detailProject2.setText(nomeProgettoAttuale);
        detailProject3.setText(nomeProgettoAttuale);
        detailCity0.setText(cittaSelezionata);
        detailCity1.setText(cittaSelezionata);
        detailCity2.setText(cittaSelezionata);
        detailCity3.setText(cittaSelezionata);
        
        //gestione tabella note
        String colums [] = {"Nome", "Ultima modifica"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(colums);
        Tabella.setModel(model);
        Tabella.setRowHeight(30);
        //gestione tabella progetti
        String colums1 [] = {"Nome Progetto", "Città", "Stato", "Data Creazione"};
        model1 = new DefaultTableModel();
        model1.setColumnIdentifiers(colums1);
        tableProject.setModel(model1);
        tableProject.setRowHeight(30);
        
        //listner opzioni selezionate da tendina
        BindCombo();
        
        SetEmpty.setVisible(false);
        SalvaDB.setVisible(false);
        //link see more.. si renderà visibile quando si farà la ricerca
        linkWiki.setVisible(false);
        
        Cielo.setText("");
        latitudine.setText("");
        longitudine.setText("");
        timezone.setText("");
        
        MeteoView.setEditable(false);
        TemperaturaMassima.setEditable(false);
        TemperaturaMinima.setEditable(false);
        Vento.setEditable(false);
        Umidita.setEditable(false);
        
        ResetNota.setVisible(false);
        Delete.setVisible(false); 
        TextArea.setFont (new Font ("Serif", Font.ITALIC, 16));
        //fa andare a capo le parole senza spezzarle
        TextArea.setWrapStyleWord (true);
        descrizioneBigCitta.setWrapStyleWord (true);
        descBreveCitta.setWrapStyleWord (true);
        
        //fa andare a capo a fine texarea senza creare la barra di scroll
        TextArea.setLineWrap(true);
        descrizioneBigCitta.setLineWrap(true);
        descBreveCitta.setLineWrap(true);
        
        // Listen relativo ai cambiamenti del testo per il tasto Empty
        TextArea.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void changedUpdate(DocumentEvent e) {
            
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
            SetEmpty.setVisible(false);
        }
        @Override
        public void insertUpdate(DocumentEvent e) { 
            
            SetEmpty.setVisible(true);
        }  
      });
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

         //listner tabella note
        TextArea.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent arg0) {
            //Stampa il numero corrispondente ad ogni tasto premuto sulla tastiera
            //System.out.println(arg0.getExtendedKeyCode());
            if (arg0.getKeyCode()==KeyEvent.VK_ENTER) {
                String text = TextArea.getText();
                textNota = text;
                }
        }});

        //listner link wikipedia
        linkSito();
    
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InterfaceAfterLog = new javax.swing.JPanel();
        JTabbed = new javax.swing.JTabbedPane();
        TutorialPage = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Homepage = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        FolderName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        projectName = new javax.swing.JComboBox();
        jPanel22 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        detailCity0 = new javax.swing.JLabel();
        detailProject0 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Start = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        nomePrincproject = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        HEREmaps = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        Maps = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        descBreveCitta = new javax.swing.JTextArea();
        jPanel13 = new javax.swing.JPanel();
        StatoMaps = new javax.swing.JTextField();
        CittaMaps = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        SalvaDB = new javax.swing.JButton();
        CercaCitta = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        descrizioneBigCitta = new javax.swing.JTextArea();
        linkWiki = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        detailCity1 = new javax.swing.JLabel();
        detailProject1 = new javax.swing.JLabel();
        OpenWeather = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        Data0 = new javax.swing.JLabel();
        Data1 = new javax.swing.JLabel();
        Data2 = new javax.swing.JLabel();
        Data3 = new javax.swing.JLabel();
        Data4 = new javax.swing.JLabel();
        Data5 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        soleA0 = new javax.swing.JLabel();
        soleB0 = new javax.swing.JLabel();
        lunaA0 = new javax.swing.JLabel();
        lunaB0 = new javax.swing.JLabel();
        fase0 = new javax.swing.JLabel();
        descrizione0 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        soleA1 = new javax.swing.JLabel();
        soleB1 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        lunaA1 = new javax.swing.JLabel();
        lunaB1 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        fase1 = new javax.swing.JLabel();
        descrizione1 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        soleA2 = new javax.swing.JLabel();
        soleB2 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        lunaA2 = new javax.swing.JLabel();
        lunaB2 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        fase2 = new javax.swing.JLabel();
        descrizione2 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        soleA3 = new javax.swing.JLabel();
        soleB3 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        lunaA3 = new javax.swing.JLabel();
        lunaB3 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        fase3 = new javax.swing.JLabel();
        descrizione3 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        soleA4 = new javax.swing.JLabel();
        soleB4 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        lunaA4 = new javax.swing.JLabel();
        lunaB4 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        fase4 = new javax.swing.JLabel();
        descrizione4 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        soleA5 = new javax.swing.JLabel();
        soleB5 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        lunaA5 = new javax.swing.JLabel();
        lunaB5 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        fase5 = new javax.swing.JLabel();
        descrizione5 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        detailProject2 = new javax.swing.JLabel();
        detailCity2 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        MeteoView = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TemperaturaMinima = new javax.swing.JTextField();
        TemperaturaMassima = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Vento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Umidita = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Cielo = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        timezone = new javax.swing.JLabel();
        latitudine = new javax.swing.JLabel();
        longitudine = new javax.swing.JLabel();
        Dropbox = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        Salva = new javax.swing.JButton();
        NoteName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Delete = new javax.swing.JButton();
        SetEmpty = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ResetNota = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabella = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        detailCity3 = new javax.swing.JLabel();
        detailProject3 = new javax.swing.JLabel();
        Blackboard = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        detailCity4 = new javax.swing.JLabel();
        detailProject4 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableProject = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        Push = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        DownloadPanel = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        detailCity5 = new javax.swing.JLabel();
        detailProject5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        GetPDF = new javax.swing.JButton();
        detailProject6 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        codiceUnivoco = new javax.swing.JTextField();
        PostPDF = new javax.swing.JButton();
        StatisticsPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        VisualizzaStatistiche = new javax.swing.JButton();
        PanelGrafico = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTabbed.setBackground(new java.awt.Color(255, 255, 255));
        JTabbed.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        TutorialPage.setBackground(new java.awt.Color(255, 153, 102));

        jLabel11.setFont(new java.awt.Font("Tiranti Solid LET", 0, 48)); // NOI18N
        jLabel11.setText("Benvenuto in ");

        jLabel13.setFont(new java.awt.Font("Kristen ITC", 0, 36)); // NOI18N
        jLabel13.setText("TANGOapp");

        jPanel10.setBackground(new java.awt.Color(255, 230, 209));

        jLabel14.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Essa ti permetterà di:  ");

        jLabel16.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("-creare le tue note di viaggio in maniera semplice ed efficace;");

        jLabel17.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("-visualizzare ed eliminare le tue note da qualsiasi parte del mondo;");

        jLabel20.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("-consultare il meteo per avere le loro info dettagliate in tempo reale;");

        jLabel39.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("-creare il tuo progetto includento tutte le città del mondo che vorrai visitare;");

        jLabel41.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel41.setText("-visualizzare una mappa della città o dello stato selezionato;");

        jLabel42.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel42.setText("-accedere a delle curiosità riguardanti l'astronomia e le coordinate geografiche;");

        jLabel43.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel43.setText("-conoscere la loro storia ed approfondire con i contenuti tratti da Wikipedia;");

        jLabel65.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel65.setText("-tenere sempre sotto controllo tutti i tuoi progetti e le relative città;");

        jLabel69.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel69.setText("-scaricare il PDF del tuo progetto così da portarlo comodamente con te in viaggio;");

        jLabel71.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel71.setText("-visualizzare le statistiche in tempo reale dei progetti di tutti gli utenti registrati;");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel65)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel71)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Ti trovi nella pagina Tutorial di questa utile ed intuitiva applicazione...");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("... basta solo creare il tuo progetto selezionando la spunta Hompage in alto a sinistra.");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel19))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addContainerGap())
        );

        javax.swing.GroupLayout TutorialPageLayout = new javax.swing.GroupLayout(TutorialPage);
        TutorialPage.setLayout(TutorialPageLayout);
        TutorialPageLayout.setHorizontalGroup(
            TutorialPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TutorialPageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        TutorialPageLayout.setVerticalGroup(
            TutorialPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TutorialPageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        JTabbed.addTab("Tutorial", TutorialPage);

        Homepage.setBackground(new java.awt.Color(255, 51, 51));

        jButton1.setText("Crea un nuovo progetto");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddFolder(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Crea un nuovo progetto..");

        jLabel7.setText("Nome progetto:");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel36.setText("...oppure scegli tra i tuoi progetti");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel37.setText("esistenti.");

        projectName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        projectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(FolderName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(projectName, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel37))
                            .addComponent(jLabel36)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FolderName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(35, 35, 35)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addComponent(projectName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel67.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel67.setText("TANGOapp");

        jLabel68.setFont(new java.awt.Font("Tiranti Solid LET", 0, 24)); // NOI18N
        jLabel68.setText("Project detail");

        detailCity0.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        detailCity0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailCity0.setText("Country, State, City");

        detailProject0.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        detailProject0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailProject0.setText("Project Name");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(jLabel67))
                    .addComponent(detailCity0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(detailProject0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailProject0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detailCity0)
                .addGap(14, 14, 14))
        );

        Start.setFont(new java.awt.Font("Kristen ITC", 1, 11)); // NOI18N
        Start.setText("INIZIA");
        Start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                StartMousePressed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setText("Sei pronto per iniziare?");

        nomePrincproject.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nomePrincproject.setText("Project Name");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel40.setText("Il nome del tuo progetto è:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel40)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Start, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel38)
                                    .addGap(10, 10, 10)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(nomePrincproject)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nomePrincproject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38)
                .addGap(22, 22, 22)
                .addComponent(Start, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HomepageLayout = new javax.swing.GroupLayout(Homepage);
        Homepage.setLayout(HomepageLayout);
        HomepageLayout.setHorizontalGroup(
            HomepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomepageLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HomepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        HomepageLayout.setVerticalGroup(
            HomepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomepageLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(HomepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(HomepageLayout.createSequentialGroup()
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        JTabbed.addTab("Homepage", Homepage);

        HEREmaps.setBackground(new java.awt.Color(204, 0, 102));

        Maps.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel23.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        jLabel23.setText("Il segnalibro verde indica il luogo menzionato");

        jLabel66.setFont(new java.awt.Font("Tiranti Solid LET", 0, 24)); // NOI18N
        jLabel66.setText("Map");

        descBreveCitta.setBackground(new java.awt.Color(240, 240, 240));
        descBreveCitta.setColumns(20);
        descBreveCitta.setRows(2);
        descBreveCitta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        descBreveCitta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        descBreveCitta.setEnabled(false);
        descBreveCitta.setMargin(new java.awt.Insets(0, 0, 0, 0));
        descBreveCitta.setOpaque(false);
        jScrollPane4.setViewportView(descBreveCitta);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel23))
                            .addComponent(Maps, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Maps, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addGap(49, 49, 49))
        );

        jLabel21.setText("Stato");

        jLabel22.setText("Città");

        jLabel27.setFont(new java.awt.Font("Tiranti Solid LET", 0, 24)); // NOI18N
        jLabel27.setText("Search maps");

        SalvaDB.setText("Salva");
        SalvaDB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SalvaDBMousePressed(evt);
            }
        });

        CercaCitta.setText("Cerca");
        CercaCitta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CercaCittaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(28, 28, 28)
                                        .addComponent(CittaMaps))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(25, 25, 25)
                                        .addComponent(StatoMaps))))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(0, 190, Short.MAX_VALUE))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(SalvaDB, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CercaCitta, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatoMaps, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(CittaMaps, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SalvaDB)
                    .addComponent(CercaCitta))
                .addContainerGap())
        );

        jLabel28.setFont(new java.awt.Font("Tiranti Solid LET", 0, 24)); // NOI18N
        jLabel28.setText("Story");

        descrizioneBigCitta.setBackground(new java.awt.Color(240, 240, 240));
        descrizioneBigCitta.setColumns(20);
        descrizioneBigCitta.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        descrizioneBigCitta.setRows(5);
        descrizioneBigCitta.setBorder(null);
        descrizioneBigCitta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        descrizioneBigCitta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        descrizioneBigCitta.setEnabled(false);
        jScrollPane3.setViewportView(descrizioneBigCitta);
        descrizioneBigCitta.getAccessibleContext().setAccessibleDescription("text/html");

        linkWiki.setText("Click here to see more...");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(linkWiki, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linkWiki)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel60.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel60.setText("TANGOapp");

        jLabel61.setFont(new java.awt.Font("Tiranti Solid LET", 0, 24)); // NOI18N
        jLabel61.setText("Project detail");

        detailCity1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        detailCity1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailCity1.setText("Country, State, City");

        detailProject1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        detailProject1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailProject1.setText("Project Name");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel60))
                    .addComponent(detailCity1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(detailProject1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailProject1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailCity1)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout HEREmapsLayout = new javax.swing.GroupLayout(HEREmaps);
        HEREmaps.setLayout(HEREmapsLayout);
        HEREmapsLayout.setHorizontalGroup(
            HEREmapsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HEREmapsLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(HEREmapsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(HEREmapsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        HEREmapsLayout.setVerticalGroup(
            HEREmapsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HEREmapsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(HEREmapsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HEREmapsLayout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HEREmapsLayout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 395, Short.MAX_VALUE)))
                .addContainerGap())
        );

        JTabbed.addTab("Maps", HEREmaps);

        OpenWeather.setBackground(new java.awt.Color(61, 153, 77));

        jLabel24.setFont(new java.awt.Font("Tiranti Solid LET", 0, 24)); // NOI18N
        jLabel24.setText("Astronomy");

        Data0.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        Data0.setText("Data");

        Data1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        Data1.setText("Data");

        Data2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        Data2.setText("Data");

        Data3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        Data3.setText("Data");

        Data4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        Data4.setText("Data");

        Data5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        Data5.setText("Data");

        jLabel25.setText("Sole");

        jLabel34.setText("Luna");

        jLabel35.setText("Fase Lunare");

        jLabel50.setText("Sole");

        jLabel53.setText("Luna");

        jLabel56.setText("Fase Lunare");

        jLabel59.setText("Sole");

        jLabel64.setText("Luna");

        jLabel70.setText("Fase Lunare");

        jLabel73.setText("Sole");

        jLabel76.setText("Luna");

        jLabel79.setText("Fase Lunare");

        jLabel91.setText("Sole");

        jLabel94.setText("Luna");

        jLabel97.setText("Fase Lunare");

        jLabel100.setText("Sole");

        jLabel103.setText("Luna");

        jLabel106.setText("Fase Lunare");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Data3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel94)
                                    .addGap(30, 30, 30)
                                    .addComponent(lunaA4))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel91)
                                    .addGap(33, 33, 33)
                                    .addComponent(soleA4)))
                            .addComponent(jLabel97))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(soleB4)
                                    .addComponent(lunaB4))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(fase4)
                                .addGap(18, 18, 18)
                                .addComponent(descrizione4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Data1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Data5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(Data0, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel34)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lunaA0))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addGap(33, 33, 33)
                                        .addComponent(soleA0)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(fase0)
                                        .addGap(18, 18, 18)
                                        .addComponent(descrizione0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(soleB0)
                                            .addComponent(lunaB0))
                                        .addGap(100, 100, 100)
                                        .addComponent(jLabel24)
                                        .addGap(0, 99, Short.MAX_VALUE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel53)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lunaA1))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel50)
                                            .addGap(33, 33, 33)
                                            .addComponent(soleA1)))
                                    .addComponent(jLabel56))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(soleB1)
                                    .addComponent(lunaB1)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(fase1)
                                        .addGap(18, 18, 18)
                                        .addComponent(descrizione1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(Data2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Data4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lunaA2)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel59)
                                        .addGap(33, 33, 33)
                                        .addComponent(soleA2)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(soleB2)
                                    .addComponent(lunaB2)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(fase2)
                                        .addGap(18, 18, 18)
                                        .addComponent(descrizione2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel76)
                                            .addGap(30, 30, 30)
                                            .addComponent(lunaA3))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel73)
                                            .addGap(33, 33, 33)
                                            .addComponent(soleA3)))
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel79)
                                    .addComponent(jLabel64)
                                    .addComponent(jLabel70))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(soleB3)
                                            .addComponent(lunaB3))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(fase3)
                                        .addGap(18, 18, 18)
                                        .addComponent(descrizione3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel103)
                                            .addGap(30, 30, 30)
                                            .addComponent(lunaA5))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel100)
                                            .addGap(33, 33, 33)
                                            .addComponent(soleA5)))
                                    .addComponent(jLabel106))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(soleB5)
                                            .addComponent(lunaB5))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(fase5)
                                        .addGap(18, 18, 18)
                                        .addComponent(descrizione5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Data0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(soleA0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(soleB0))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(lunaA0)
                            .addComponent(lunaB0))))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(fase0)
                    .addComponent(descrizione0))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Data1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(soleA1)
                    .addComponent(soleB1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(lunaA1)
                    .addComponent(lunaB1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(fase1)
                    .addComponent(descrizione1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Data2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(soleA2)
                    .addComponent(soleB2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(lunaA2)
                    .addComponent(lunaB2))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(fase2)
                    .addComponent(descrizione2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Data3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(soleA3)
                    .addComponent(soleB3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(lunaA3)
                    .addComponent(lunaB3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(fase3)
                    .addComponent(descrizione3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Data4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel91)
                    .addComponent(soleA4)
                    .addComponent(soleB4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(lunaA4)
                    .addComponent(lunaB4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(fase4)
                    .addComponent(descrizione4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Data5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(soleA5)
                    .addComponent(soleB5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel103)
                    .addComponent(lunaA5)
                    .addComponent(lunaB5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel106)
                    .addComponent(fase5)
                    .addComponent(descrizione5))
                .addContainerGap())
        );

        soleA0.getAccessibleContext().setAccessibleDescription("");

        jLabel30.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel30.setText("TANGOapp");

        jLabel31.setFont(new java.awt.Font("Tiranti Solid LET", 0, 24)); // NOI18N
        jLabel31.setText("Project detail");

        detailProject2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        detailProject2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailProject2.setText("Project Name");

        detailCity2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        detailCity2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailCity2.setText("Country, State, City");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(detailProject2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(detailCity2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(jLabel30)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailProject2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailCity2)
                .addGap(19, 19, 19))
        );

        MeteoView.setBackground(new java.awt.Color(240, 240, 240));
        MeteoView.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        MeteoView.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MeteoView.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        MeteoView.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tiranti Solid LET", 0, 24)); // NOI18N
        jLabel3.setText("Weather now");

        TemperaturaMinima.setBackground(new java.awt.Color(240, 240, 240));
        TemperaturaMinima.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TemperaturaMinima.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TemperaturaMinima.setEnabled(false);

        TemperaturaMassima.setBackground(new java.awt.Color(240, 240, 240));
        TemperaturaMassima.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TemperaturaMassima.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TemperaturaMassima.setEnabled(false);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("min - max");

        Vento.setBackground(new java.awt.Color(240, 240, 240));
        Vento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Vento.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Vento.setEnabled(false);

        jLabel9.setText("Vento");

        Umidita.setBackground(new java.awt.Color(240, 240, 240));
        Umidita.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Umidita.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Umidita.setEnabled(false);

        jLabel10.setText("Umidità");

        Cielo.setText("descrizione meteo");

        jLabel29.setText("Latitudine");

        jLabel32.setText("Longitudine");

        jLabel33.setText("Timezone");

        timezone.setText("timezone");

        latitudine.setText("latitudine");

        longitudine.setText("longitudine");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(longitudine))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Vento, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                        .addComponent(Umidita, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10))
                                    .addComponent(Cielo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(0, 15, Short.MAX_VALUE)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(TemperaturaMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TemperaturaMassima, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(MeteoView, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel33)
                                                .addComponent(jLabel29))
                                            .addComponent(jLabel32))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(latitudine)
                                    .addComponent(timezone))))))
                .addGap(41, 41, 41))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(timezone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(latitudine))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(longitudine))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MeteoView, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TemperaturaMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TemperaturaMassima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cielo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Vento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Umidita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(48, 48, 48))))
        );

        javax.swing.GroupLayout OpenWeatherLayout = new javax.swing.GroupLayout(OpenWeather);
        OpenWeather.setLayout(OpenWeatherLayout);
        OpenWeatherLayout.setHorizontalGroup(
            OpenWeatherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpenWeatherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(OpenWeatherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        OpenWeatherLayout.setVerticalGroup(
            OpenWeatherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpenWeatherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OpenWeatherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(OpenWeatherLayout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        JTabbed.addTab("Meteo", OpenWeather);

        Dropbox.setBackground(new java.awt.Color(0, 153, 153));
        Dropbox.setPreferredSize(new java.awt.Dimension(800, 438));

        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);

        Salva.setText("Salva");
        Salva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveTxt(evt);
            }
        });

        NoteName.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel1.setText("Nome nota:");

        Delete.setText("Elimina Nota");
        Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteMouseClicked(evt);
            }
        });

        SetEmpty.setText("Svuota Testo");
        SetEmpty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SetEmptyMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tiranti Solid LET", 0, 24)); // NOI18N
        jLabel4.setText("Note");

        jLabel5.setText("Testo nota:");

        ResetNota.setText("Crea nuova nota");
        ResetNota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ResetNotaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(NoteName)
                                .addGap(18, 18, 18)
                                .addComponent(Salva, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SetEmpty, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ResetNota, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(NoteName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Salva, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(SetEmpty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResetNota, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Tabella.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(Tabella);

        jButton2.setText("Visualizza elementi ");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewPath(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tiranti Solid LET", 0, 24)); // NOI18N
        jLabel6.setText("Notes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel48.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel48.setText("TANGOapp");

        jLabel49.setFont(new java.awt.Font("Tiranti Solid LET", 0, 24)); // NOI18N
        jLabel49.setText("Project detail");

        detailCity3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        detailCity3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailCity3.setText("Country, State, City");

        detailProject3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        detailProject3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailProject3.setText("Project Name");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(jLabel48))
                    .addComponent(detailCity3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(detailProject3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailProject3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailCity3)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout DropboxLayout = new javax.swing.GroupLayout(Dropbox);
        Dropbox.setLayout(DropboxLayout);
        DropboxLayout.setHorizontalGroup(
            DropboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DropboxLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(DropboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        DropboxLayout.setVerticalGroup(
            DropboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DropboxLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(DropboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DropboxLayout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        JTabbed.addTab("Note", Dropbox);

        Blackboard.setBackground(new java.awt.Color(0, 0, 0));

        jLabel51.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel51.setText("TANGOapp");

        jLabel52.setFont(new java.awt.Font("Tiranti Solid LET", 0, 24)); // NOI18N
        jLabel52.setText("Project detail");

        detailCity4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        detailCity4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailCity4.setText("Country, State, City");

        detailProject4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        detailProject4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailProject4.setText("Project Name");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(jLabel51))
                    .addComponent(detailCity4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(detailProject4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailProject4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailCity4)
                .addGap(19, 19, 19))
        );

        tableProject.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tableProject);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );

        Push.setText("Push");
        Push.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PushMousePressed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setText("Visualizza i tuoi salvataggi...");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(Push, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(Push, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout BlackboardLayout = new javax.swing.GroupLayout(Blackboard);
        Blackboard.setLayout(BlackboardLayout);
        BlackboardLayout.setHorizontalGroup(
            BlackboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlackboardLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(BlackboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BlackboardLayout.createSequentialGroup()
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        BlackboardLayout.setVerticalGroup(
            BlackboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlackboardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BlackboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        JTabbed.addTab("Blackboard", Blackboard);

        DownloadPanel.setBackground(new java.awt.Color(153, 204, 255));

        jLabel54.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel54.setText("TANGOapp");

        jLabel55.setFont(new java.awt.Font("Tiranti Solid LET", 0, 24)); // NOI18N
        jLabel55.setText("Project detail");

        detailCity5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        detailCity5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailCity5.setText("Country, State, City");

        detailProject5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        detailProject5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailProject5.setText("Project Name");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(jLabel54))
                    .addComponent(detailCity5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(detailProject5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailProject5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailCity5)
                .addGap(19, 19, 19))
        );

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel44.setText("... visualizza e scarica il PDF del tuo progetto:");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel45.setText("Se non lo hai ancora fatto...");

        GetPDF.setText("Visualizza e scarica");
        GetPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GetPDFMousePressed(evt);
            }
        });

        detailProject6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        detailProject6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailProject6.setText("Project Name");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(detailProject6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(GetPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detailProject6)
                .addGap(18, 18, 18)
                .addComponent(GetPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel46.setText("Se hai già il numero identificativo del tuo ");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel47.setText("progetto, inseriscilo qui per scaricarlo");

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel57.setText("nuovamente:");

        codiceUnivoco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codiceUnivoco.setToolTipText("");

        PostPDF.setText("Cerca e scarica");
        PostPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PostPDFMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PostPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(codiceUnivoco, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codiceUnivoco, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PostPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DownloadPanelLayout = new javax.swing.GroupLayout(DownloadPanel);
        DownloadPanel.setLayout(DownloadPanelLayout);
        DownloadPanelLayout.setHorizontalGroup(
            DownloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownloadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(DownloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        DownloadPanelLayout.setVerticalGroup(
            DownloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DownloadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(DownloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(146, 146, 146))
        );

        JTabbed.addTab("Download", DownloadPanel);

        jPanel6.setBackground(new java.awt.Color(102, 0, 102));

        jLabel26.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel26.setText("TANGOapp");

        VisualizzaStatistiche.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VisualizzaStatistiche.setText("Visualizza Statistiche Globali");
        VisualizzaStatistiche.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                VisualizzaStatisticheMousePressed(evt);
            }
        });

        PanelGrafico.setBackground(new java.awt.Color(178, 121, 221));
        PanelGrafico.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel15.setText("che hanno aggiunto le loro città ai loro progetti. ");

        jLabel58.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel58.setText("Sono state calcolate contando tutte le città relative ad uno stato e ");

        jLabel62.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel62.setText("rappresentate su di un gradico ad Area.");

        jLabel63.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel63.setText("Le statistiche sono basate su tutti gli utenti iscritti a questa piattaforma");

        javax.swing.GroupLayout PanelGraficoLayout = new javax.swing.GroupLayout(PanelGrafico);
        PanelGrafico.setLayout(PanelGraficoLayout);
        PanelGraficoLayout.setHorizontalGroup(
            PanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGraficoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(PanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelGraficoLayout.setVerticalGroup(
            PanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGraficoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(18, 18, 18))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(VisualizzaStatistiche, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(PanelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(VisualizzaStatistiche, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout StatisticsPanelLayout = new javax.swing.GroupLayout(StatisticsPanel);
        StatisticsPanel.setLayout(StatisticsPanelLayout);
        StatisticsPanelLayout.setHorizontalGroup(
            StatisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        StatisticsPanelLayout.setVerticalGroup(
            StatisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JTabbed.addTab("Statistics", StatisticsPanel);

        Logout.setText("Logout");
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout InterfaceAfterLogLayout = new javax.swing.GroupLayout(InterfaceAfterLog);
        InterfaceAfterLog.setLayout(InterfaceAfterLogLayout);
        InterfaceAfterLogLayout.setHorizontalGroup(
            InterfaceAfterLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InterfaceAfterLogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InterfaceAfterLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Logout))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InterfaceAfterLogLayout.setVerticalGroup(
            InterfaceAfterLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InterfaceAfterLogLayout.createSequentialGroup()
                .addComponent(JTabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Logout))
        );

        JTabbed.getAccessibleContext().setAccessibleName("Dropbox");
        JTabbed.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InterfaceAfterLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(InterfaceAfterLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
Progetto progetto = new Progetto();
//id nota da inserire in DB
String idNota;
String textNota = "";
//idUtente loggato
String idUtenteLoggato;
//nome che compare in detail project
String nomeProgettoAttuale = "Project Name";
//città che compare in detail project
String cittaSelezionata= "Country, State, City";
//valori da inviare al DB
String statoSelezionatoDB;
String cittaSelezionataDB;
//idProgetto creato su DB
String idProgetto;
//luogo da cercare su wikipedia
String cittaStatoCercato;
    //rimuovi gli item dalla tendina e aggiornala con i nuovi valori
    private void updateTendina() throws Exception{
        //svuoto combobox
        for(int i=projectName.getItemCount()-1;i>=0;i--){
                projectName.removeItemAt(i);
            }
        try {
            BindCombo();
        } catch (Exception ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler tornare all'interfaccia di login?");
        //Ritorna  -1  se si chiude la finestra
        //0   se si preme  Sì
        //1   se si preme  No
        //2   se si preme  Annulla
        if(a == 0) {
            nomeProgettoAttuale = "Project Name";
            this.dispose();
            Client client = new  Client();
            client.setVisible(true);           
        }  
    }//GEN-LAST:event_LogoutMouseClicked
    private String RicercaMeteo(String nomeCitta){
            String ritorno = "404";
            ConnectionHTTP con = new ConnectionHTTP();
            try {
                String url1 = "/weather";
                String url2 = "/astronomy";
                String meteo = con.sendPost(nomeCitta, url1);
                String astronomy = con.sendPost(nomeCitta, url2);
                //System.out.println(meteo);

                //gestione validità città
                JSONObject jsonObject1 = new JSONObject(meteo);
                Double verificaStato = jsonObject1.getDouble("cod");
                if(verificaStato == 404 ){
                    SalvaDB.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Non sono disponibili tutti i servizi per questa città! \n controlla l'ortografia o la sua esistenza!");
                    ritorno = verificaStato.toString();
                }else{
                    //gestione meteo
                    JSONArray CieloT = jsonObject1.getJSONArray("weather");
                    JSONObject explrObject = null;
                    int i = 0;
                    String descrizioneMeteo = null;
                    while (i < CieloT.length()) {
                        explrObject = CieloT.getJSONObject(i);
                        descrizioneMeteo = explrObject.getString("description");
                        i++;
                    }

                    Cielo.setText(descrizioneMeteo);

                    Double temperatura , tempMin , tempMax, umidity ;
                    JSONObject Temperature = jsonObject1.getJSONObject("main");
                    temperatura = Temperature.getDouble("temp");
                    tempMin = Temperature.getDouble("temp_min");
                    tempMax = Temperature.getDouble("temp_max");
                    umidity = Temperature.getDouble("humidity");
                    //converto da Kelvin a Celsius
                    temperatura = toCelsius(temperatura);
                    //arrotondo alla prima cifra dopo la virgola
                    String tempArrot = arrotondo(temperatura);
                    //setto il valore della temperatura
                    MeteoView.setText(tempArrot + "°");
                    tempMin = toCelsius(tempMin);
                    String tempMinArrot = arrotondo(tempMin);
                    TemperaturaMinima.setText(tempMinArrot + "°");

                    tempMax = toCelsius(tempMax);
                    String tempMaxArrot = arrotondo(tempMax);
                    TemperaturaMassima.setText(tempMaxArrot + "°");

                    Umidita.setText(String.valueOf(umidity) + "%");

                    JSONObject velocitaVento = jsonObject1.getJSONObject("wind");
                    double vento = velocitaVento.getDouble("speed");
                    Vento.setText(String.valueOf(vento)+" Km/h");
                    
                    //GESTIONE ASTRONOMIA
                    //System.out.println(astronomy);
                    JSONObject jsonObject2 = new JSONObject(astronomy);
                    JSONObject coord = jsonObject2.getJSONObject("astronomy");
                    
                    Double latitud = coord.getDouble("latitude");
                    Double longitud = coord.getDouble("longitude");
                    Float timeZone = coord.getFloat("timezone");
                    latitudine.setText(latitud.toString());
                    longitudine.setText(longitud.toString());
                    timezone.setText(timeZone.toString());
                    
                    //project detail
                    String country = coord.getString("country");
                    String state = coord.getString("state");
                    statoSelezionatoDB = country;
                    String city = coord.getString("city");
                    
                    cittaSelezionata = country + ", " + state + ", " + city;
                    
                    JSONArray astronomia = jsonObject2.getJSONObject("astronomy").getJSONArray("astronomy");
                    JSONObject explrObject2 = null;
                    
                    List<String> listaSunrise = new ArrayList<>();
                    List<String> listaSunset = new ArrayList<>();
                    List<String> listaMoonrise = new ArrayList<>();
                    List<String> listaMoonset = new ArrayList<>();
                    List<String> listaDate = new ArrayList<>();
                    List<String> listaFasiLunari = new ArrayList<>();
                    List<String> listaDescrizione = new ArrayList<>();
                    
                    int j = 0;
                    while (j < astronomia.length()) {
                        explrObject2 = astronomia.getJSONObject(j);
                        //SUNRISE
                        String sunriseSingolo = explrObject2.getString("sunrise");
                        listaSunrise.add(sunriseSingolo);
                        //SUNSET
                        String sunsetSingolo = explrObject2.getString("sunset");
                        listaSunset.add(sunsetSingolo);
                        //MOONRISE
                        String moonriseSingolo = explrObject2.getString("moonrise");
                        listaMoonrise.add(moonriseSingolo);
                        //MOONSET
                        String moonsetSingolo = explrObject2.getString("moonset");
                        listaMoonset.add(moonsetSingolo);
                        //DATE
                        String dateSingolo = explrObject2.getString("utcTime");
                        String dataOrdinata = dateSingolo.substring(8,10) + dateSingolo.substring(4,8) +  dateSingolo.substring(0,4);
                        listaDate.add(dataOrdinata);
                        //FASILUNARI
                        Float fasiSingolo = explrObject2.getFloat("moonPhase");
                        listaFasiLunari.add(fasiSingolo.toString());
                        //DESCRIZIONE
                        String descrizioneSingolo = explrObject2.getString("moonPhaseDesc");
                        listaDescrizione.add(descrizioneSingolo);
                        
                        j++;
                    }
                    
                    Data0.setText(listaDate.get(0));
                    Data1.setText(listaDate.get(1));
                    Data2.setText(listaDate.get(2));
                    Data3.setText(listaDate.get(3));
                    Data4.setText(listaDate.get(4));
                    Data5.setText(listaDate.get(5));
                    lunaA0.setText(listaMoonrise.get(0));
                    lunaA1.setText(listaMoonrise.get(1));
                    lunaA2.setText(listaMoonrise.get(2));
                    lunaA3.setText(listaMoonrise.get(3));
                    lunaA4.setText(listaMoonrise.get(4));
                    lunaA5.setText(listaMoonrise.get(5));
                    lunaB0.setText(listaMoonset.get(0));
                    lunaB1.setText(listaMoonset.get(1));
                    lunaB2.setText(listaMoonset.get(2));
                    lunaB3.setText(listaMoonset.get(3));
                    lunaB4.setText(listaMoonset.get(4));
                    lunaB5.setText(listaMoonset.get(5));
                    soleA0.setText(listaSunrise.get(0));
                    soleA1.setText(listaSunrise.get(1));
                    soleA2.setText(listaSunrise.get(2));
                    soleA3.setText(listaSunrise.get(3));
                    soleA4.setText(listaSunrise.get(4));
                    soleA5.setText(listaSunrise.get(5));
                    soleB0.setText(listaSunset.get(0));
                    soleB1.setText(listaSunset.get(1));
                    soleB2.setText(listaSunset.get(2));
                    soleB3.setText(listaSunset.get(3));
                    soleB4.setText(listaSunset.get(4));
                    soleB5.setText(listaSunset.get(5));
                    fase0.setText(listaFasiLunari.get(0));
                    fase1.setText(listaFasiLunari.get(1));
                    fase2.setText(listaFasiLunari.get(2));
                    fase3.setText(listaFasiLunari.get(3));
                    fase4.setText(listaFasiLunari.get(4));
                    fase5.setText(listaFasiLunari.get(5));
                    descrizione0.setText(listaDescrizione.get(0));
                    descrizione1.setText(listaDescrizione.get(1));
                    descrizione2.setText(listaDescrizione.get(2));
                    descrizione3.setText(listaDescrizione.get(3));
                    descrizione4.setText(listaDescrizione.get(4));
                    descrizione5.setText(listaDescrizione.get(5));
                    ritorno = "OK";
                }
            } catch (Exception ex) {
                Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        return ritorno;
    }
    private void ViewPath(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewPath
        try{
//  INSERIMENTO DATI NELLA TABELLA
            //crea la tabella compilata appena apre l'interfaccia swing
            String colums [] = {"Nome", "Ultima modifica"};
            String folderName, lastModified;
            String url = "/dropbox/folder?folder="+idUtenteLoggato+"/"+nomeProgettoAttuale;
            String res = new ConnectionHTTP().sendGet(url);

            model = new DefaultTableModel();
            model.setColumnIdentifiers(colums);

            JSONObject jsonObject = new JSONObject(res);
            //System.out.println(jsonObject);
            JSONArray jsonArray = jsonObject.getJSONArray("entries");
            JSONObject explrObject = null;

            int i = 0;
            while (i < jsonArray.length()) {
                explrObject = jsonArray.getJSONObject(i);
                if("file".equals(explrObject.getString(".tag"))){
                    folderName = explrObject.getString("name");
                    idNota = explrObject.getString("id");
                    lastModified = explrObject.getString("client_modified");
                    //manipolazione della stringa ultima modifica
                    String dataUltimaModifica = lastModified.substring(8,10) + lastModified.substring(4,8) +  lastModified.substring(0,4);
                    String oraUltimaModifica = lastModified.substring(11,19);
                    String dataEOraUltimaModifica = dataUltimaModifica + " " + oraUltimaModifica;

                    Object data [] = {folderName, dataEOraUltimaModifica};
                    //System.out.println(Arrays.toString(data));
                    model.addRow(data);
                }
                i++;
            }
            Tabella.setModel(model);
            
//CREAZIONE LISTNER PER IL CLICK SULLE RIGHE
            
            Tabella.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(final MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        //ritorna l'oggetto interessato dall'evento
                        final JTable target = (JTable)e.getSource();
                        //ritorna la riga dell'oggetto interessato
                        final int row = target.getSelectedRow();

                        //ritorna la colonna dell'oggetto interessato
                        //final int column = target.getSelectedColumn();
                        //ritorna il valore contenuto nelle coordinate cliccate
                        //final String value = (String) target.getValueAt(row, column);

                        //prende il valore contenuto nelle coordinate inserite (riga.colonna)
                        //in questo caso prende sempre il primo valore a sinistra della riga
                        final String valueNameFile = (String) target.getValueAt(row, 0);

                              
        //SHOWOPTIONPANE PER SCELTA EVENTO 
                        
                        //esempi di valori attribuibili all'option dialog
                        //Integer[] options = {1, 3, 5, 7, 9, 11};
                        //Double[] options = {3.141, 1.618};
                        //Character[] options = {'a', 'b', 'c', 'd'};
                        String[] options = {"Visualizza", "Annulla"};
                        int valOptionDialog = JOptionPane.showOptionDialog(null, "Scegli cosa fare con: " + valueNameFile,
                                "\nScegli un'opzione",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        //System.out.println(valOptionDialog);
                    //VISUALIZZA***************************************************************
                        if(valOptionDialog == 0){
                            Salva.setVisible(false);
                            
                            //funzione che visualizza la nota senza farla modificare
                            ConnectionHTTP conn = new ConnectionHTTP();
                            try {
                            //bisogna recuperare l'id della nota selezionata
                                String json = "{nomeNota:'" + valueNameFile+ "', pathNota:'"+ idUtenteLoggato + "/" + nomeProgettoAttuale +"'}";
                                String url = "/dropbox/nota";
                                String response = conn.sendPost(json, url);
                                //System.out.println(response);
                                NoteName.setText(valueNameFile.replaceAll(".txt", ""));
                                TextArea.setText(response.substring(1, response.length()-1).replaceAll(",", "\n"));
                                NoteName.setEditable(false);
                                TextArea.setEditable(false);
                                Delete.setVisible(true);
                                SetEmpty.setVisible(false);
                                ResetNota.setVisible(true);
                            } catch (Exception ex) {
                                Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            });
        }catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ViewPath

    private void SetEmptyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetEmptyMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler svuotare il testo?");
        //Ritorna  -1  se si chiude la finestra
        //0   se si preme  Sì
        //1   se si preme  No
        //2   se si preme  Annulla
        if(a == 0) {
            TextArea.setText("");
        }
        SetEmpty.setVisible(false);
    }//GEN-LAST:event_SetEmptyMouseClicked

    private void DeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler eliminare la tua nota?");
        //Ritorna  -1  se si chiude la finestra
        //0   se si preme  Sì
        //1   se si preme  No
        //2   se si preme  Annulla
        if(a == 0) {
            //al click del mouse prendi il testo contenuto in NoteName
            String nomeFile = NoteName.getText();

            //trasformalo in oggetto json attribuendo il valore name
            JSONObject json = new JSONObject("{name:'"+ idUtenteLoggato + "/" + nomeProgettoAttuale + "/" + nomeFile + ".txt'}");
            String fileDaInviare = json.toString();
            ConnectionHTTP http = new ConnectionHTTP();
            //System.out.println("------------------------------------------------");
            //System.out.println("Invio: Http POST request: sto eliminando il file "+ nomeFile +" su dropbox.");
            try {
                String url = "/dropbox/delete/nota";
                String response = http.sendPost(fileDaInviare, url);
                if("Eliminato!".equals(response)){
                    JOptionPane.showMessageDialog(null, "La nota:"+ nomeFile + " è stata eliminata con successo!");
                }else{
                    JOptionPane.showMessageDialog(null, "La nota: "+ nomeFile + " non è stata eliminata. \n Potrebbe non esistere.\n Riprova con un altro nome!");
                }
            } catch (Exception ex) {
                Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            TextArea.setText("");
            NoteName.setText("");
            Delete.setEnabled(true); //lasciarlo true fino a quando non si mette il vincolo della comparsa toccando la tabella
            ViewPath(evt);
        }
    }//GEN-LAST:event_DeleteMouseClicked

    private void SaveTxt(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveTxt
        try {
            verifierValueNull();
            ViewPath(evt);

        } catch (Exception ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaveTxt
//funzione che converte da gradi kelvin a gradi celsius
    public Double toCelsius(Double num){
        Double celsius =num - 273.15;
        return celsius;
    }
//funzione che tronca ad un numero solo dopo la virgola
    public String arrotondo(Double num){
        double numeroArrotondato = new BigDecimal(num).setScale(1 , BigDecimal.ROUND_UP).doubleValue();
        String stringaArrotondata = null;
        stringaArrotondata = String.valueOf(numeroArrotondato);
        return stringaArrotondata;
    }
//se nomeNota e testo non sono inseriti non abilitare il pulsante di salvataggio    
   public void verifierValueNull() throws Exception {
        //se entrambi i campi sono vuoti
        if (NoteName.getText().trim().isEmpty() && TextArea.getText().trim().isEmpty()){
            Salva.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Inserisci il testo ed il nome alla nota!");
            Salva.setEnabled(true);
            //se il campo nome nota è vuoto
        }else if(NoteName.getText().trim().isEmpty()){
            Salva.setEnabled(false);
           JOptionPane.showMessageDialog(null, "Inserisci il nome alla nota!");
           Salva.setEnabled(true);
           //se solo il campo testo è vuoto
        }else if(TextArea.getText().trim().isEmpty()){
           Salva.setEnabled(false);
           JOptionPane.showMessageDialog(null, "Aggiungi un testo alla nota");
           Salva.setEnabled(true);
        }else {
            //al click del mouse prendi il testo contenuto in NoteName 
            String nomeFile = NoteName.getText();
//            textNota = TextArea.getText();
//            textNota.replaceAll(",", " -virgola- ");
//            textNota.replaceAll("'", " -virgoletta- ");
            String[] lines = TextArea.getText().split("\n");
            
            textNota = Arrays.toString(lines);
            //System.out.println("Il progetto attuale inviato: "+nomeProgettoAttuale);
            //trasformalo in oggetto json attribuendo il valore name
            String jsonDropBox = "{name:'" + nomeFile + "', text:'"+ textNota + "', directory:'"+ idUtenteLoggato +"/" + nomeProgettoAttuale + "/'}"; 
            //System.out.println(jsonDropBox);
            ConnectionHTTP http = new ConnectionHTTP();
            String url = "/dropbox/file";
            String response = http.sendPost(jsonDropBox, url);

            if( null != response)switch (response) {
                    case "1":
                        Salva.setEnabled(false);

                        String jsonDB = "{name:'" + nomeFile + "', id_progetto:'"+ idProgetto +"'}"; 
                        ConnectionHTTP con = new ConnectionHTTP();
                        String urlDB = "/DB/project/note";
                        //System.out.println(jsonDB);
                        con.sendPost(jsonDB, urlDB);

                        JOptionPane.showMessageDialog(null, "La Nota è stata aggiunta!");
                        TextArea.setText("");
                        NoteName.setText("");
                        break;
                    case "0":
                        Salva.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "Il nome della Nota è già stato utilizzato!");
                        NoteName.setText("");
                        break;
                    default:
                        Salva.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "Errore nel caricamento della nota");
                        break;
            }
            Salva.setEnabled(true);
        }            
    }
    @SuppressWarnings("empty-statement")
    public void wikiAPI(String citta){
        //DESCRIZIONE RICERCA (creare una funzione da richiamare in ogni else if, 
        //per ingresso la citta o lo stato ed in uscita il testo da visualizzare)
        ConnectionHTTP http = new ConnectionHTTP();
            try {

                String url = "/wikipedia";
                String response = http.sendPost(citta, url);
                JSONObject jsonObject = new JSONObject(response);
                JSONObject jsonArray = jsonObject.getJSONObject("query");
                JSONObject oggettoJson = jsonArray.getJSONObject("pages");
                //prendere il primo valore dell'oggetto json senza sapere la chiave
                Iterator<String> keys = oggettoJson.keys();
                String chiave = null;
                if( keys.hasNext() ){
                String key = (String)keys.next(); // First key in your json object
                chiave=key;
                }
                    //si utilizza la chiave trovata per avere il json dei dettagli
                    JSONObject dettagliRicerca = oggettoJson.getJSONObject(chiave);
                    String dettagliSmall = dettagliRicerca.getString("description");
                    descBreveCitta.setText(dettagliSmall);
                    
                    String dettagliLarge = dettagliRicerca.getString("extract");

                    descrizioneBigCitta.setText(dettagliLarge);
                    descrizioneBigCitta.setCaretPosition(0);
                } catch (Exception ex) {
                    Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
    } 
    private void linkSito(){
    //link del sito 
                linkWiki.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                linkWiki.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() > 0) {
                        if (Desktop.isDesktopSupported()) {
                            Desktop desktop = Desktop.getDesktop();
                            try {
                                URI uri = new URI("https://it.wikipedia.org/wiki/" + cittaStatoCercato);
                                desktop.browse(uri);
                            } catch (IOException | URISyntaxException ex) {
                                ex.printStackTrace();
                            }
                         }
                    }
                }
            }); 
    }
    public void setNomeDataProgetto(){
        //setto all'oggetto progetto i valori di data e nome
        progetto.setNomeProgetto(nomeProgettoAttuale);
        //gestione data attuale
        GregorianCalendar gc = new GregorianCalendar();
        int giorno = gc.get(Calendar.DAY_OF_MONTH) ;
        int mese = gc.get(Calendar.MONTH);
        //perche il calendario gregoriano parte da 0 = gennaio
        mese = mese +1;
        int anno = gc.get(Calendar.YEAR);
        progetto.setDataRicerca(String.valueOf(anno) + "-" + String.valueOf(mese) + "-" + String.valueOf(giorno));
    }
    private void AddFolder(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddFolder
        String nameFolder = FolderName.getText();
        nomeProgettoAttuale=nameFolder;
        nomePrincproject.setText(nomeProgettoAttuale);
        
        setNomeDataProgetto();
        
        String dati ="{nomeProgetto:'"+ progetto.getNomeProgetto()+"', dataRicerca:'"+progetto.getDataRicerca()+ "', id_utente:'" + idUtenteLoggato + "'}";
        String url = "/DB/project/salve";
        ConnectionHTTP con = new ConnectionHTTP();
        try {
            String risposta = con.sendPost(dati, url);
            //if (risposta.) {
               //System.out.println(risposta); 
            //}
            idProgetto = risposta;
            //creazione cartella di dropbox
            createFolder(); 
        } catch (Exception ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        Start.setEnabled(true);
        try {
            //aggiornare tendina
            updateTendina();
        } catch (Exception ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        FolderName.setText("");
    }//GEN-LAST:event_AddFolder
    public void createFolder(){
        JSONObject json = new JSONObject("{folder:'" + idUtenteLoggato+"/"+nomeProgettoAttuale + "'}");
        //System.out.println(json);
        String folderDaInviare = json.toString();
        ConnectionHTTP http = new ConnectionHTTP();
        //System.out.println("------------------------------------------------");
        //System.out.println("Invio: Http POST request: sto creando una cartella su dropbox...");
        try {
            String url = "/dropbox/folder";
            http.sendPost(folderDaInviare, url);
            //non ci sono ancora città aggiunte al progetto, quindi blocca le schede:
            JTabbed.setEnabledAt(5, false); //Brackboard
            JTabbed.setEnabledAt(6, false); //Download
        } catch (Exception ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void SalvaDBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalvaDBMousePressed
        //settare detail project
        detailCity0.setText(cittaSelezionata);
        detailCity1.setText(cittaSelezionata);
        detailCity2.setText(cittaSelezionata);
        detailCity3.setText(cittaSelezionata);
        detailCity4.setText(cittaSelezionata);
        detailCity5.setText(cittaSelezionata);
        
        //valori attribuiti all'oggetto progetto da inviare al DB
        
        progetto.setStato(statoSelezionatoDB);
        progetto.setCitta(cittaSelezionataDB);
        
        System.out.println("IdProgettoCorrente " + idProgetto);
        
        //salvataggio dati sul DB
        String dati ="{citta:'"+progetto.getCitta()+ "', id_progetto: '"+ idProgetto +"', stato:'"+progetto.getStato()+"'}";
        //System.out.println(dati);
        ConnectionHTTP con = new ConnectionHTTP();
        
        String url = "/DB";
        try {
            con.sendPost(dati, url);
        } catch (Exception ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        //sblocca altre 2 schede
        JTabbed.setEnabledAt(5, true); //Brackboard
        JTabbed.setEnabledAt(6, true); //Download
        
        FolderName.setText("");
        SalvaDB.setVisible(false);
    }//GEN-LAST:event_SalvaDBMousePressed

    private void StartMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartMousePressed
//verificare se il progetto esiste
     if(nomeProgettoAttuale.equals("Project Name")){
        //System.out.println("Valore idProgetto:" + idProgetto);
            Start.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Crea o scegli un progetto!");
            Start.setEnabled(true);
     }else{ 
        //settare in detail project il nome del progetto
        setNomeDataProgetto();
        //System.out.println("Il progetto corrente è: "+nomeProgettoAttuale);
        detailProject0.setText(nomeProgettoAttuale);
        detailProject1.setText(nomeProgettoAttuale);
        detailProject2.setText(nomeProgettoAttuale);
        detailProject3.setText(nomeProgettoAttuale);
        detailProject4.setText(nomeProgettoAttuale);
        detailProject5.setText(nomeProgettoAttuale);
        detailProject6.setText(nomeProgettoAttuale);//grande nella schermata downloads
        
        //sbloccare i fogli del jTabbed
        JTabbed.setEnabledAt(2, true);
        JTabbed.setEnabledAt(3, true);
        JTabbed.setEnabledAt(4, true); //NOTE
        
        //se ci sono città già salvate sblocca le altre due schede
        String url1 = "/DB/project/full";
        String res = null;
        try {
            res = new ConnectionHTTP().sendPost(idUtenteLoggato,url1);
        } catch (Exception ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!"0".equals(res)) {
            JTabbed.setEnabledAt(5, true); //Brackboard
            JTabbed.setEnabledAt(6, true); //Download
        }
        
         try {
             
             linkWiki.setVisible(false);
             Maps.setText("");
             
         } catch (Exception ex) {
             Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
         }
        //svuota campi di ricerca
        resetLabelMeteo();
        resetLabelNota();
        resetLabelMaps();
        resetBlackboard();
         
        //apri il panel indice 2
        JTabbed.setSelectedIndex(2);
        //JOptionPane.showMessageDialog(null, "Benvenuto con il tuo progetto:\n"+ nomeProgettoAttuale);
        }
    }//GEN-LAST:event_StartMousePressed
    public void resetLabelMaps(){
        Maps.setIcon(null);
        StatoMaps.setText("");
        CittaMaps.setText("");
        descBreveCitta.setText("");
        descrizioneBigCitta.setText("");               
        linkWiki.setVisible(false);  
    }
    public void resetLabelMeteo(){
        MeteoView.setText("");
        TemperaturaMinima.setText("");
        TemperaturaMassima.setText("");
        Umidita.setText("");
        Vento.setText("");
        latitudine.setText("");
        longitudine.setText("");
        timezone.setText("");
        lunaA0.setText("");
        lunaA1.setText("");
        lunaA2.setText("");
        lunaA3.setText("");
        lunaA4.setText("");
        lunaA5.setText("");
        lunaB0.setText("");
        lunaB1.setText("");
        lunaB2.setText("");
        lunaB3.setText("");
        lunaB4.setText("");
        lunaB5.setText("");
        soleA0.setText("");
        soleA1.setText("");
        soleA2.setText("");
        soleA3.setText("");
        soleA4.setText("");
        soleA5.setText("");
        soleB0.setText("");
        soleB1.setText("");
        soleB2.setText("");
        soleB3.setText("");
        soleB4.setText("");
        soleB5.setText("");
        fase0.setText("");
        fase1.setText("");
        fase2.setText("");
        fase3.setText("");
        fase4.setText("");
        fase5.setText("");
        descrizione0.setText("");
        descrizione1.setText("");
        descrizione2.setText("");
        descrizione3.setText("");
        descrizione4.setText("");
        descrizione5.setText("");
    }
    public void resetLabelNota(){
        ResetNota.setVisible(false);
        Delete.setVisible(false);
        Salva.setVisible(true);
        NoteName.setText("");
        NoteName.setEditable(true);
        TextArea.setText("");
        TextArea.setEditable(true);
        
        model.setRowCount(0);
    }
    public void resetBlackboard(){
        model1.setRowCount(0);
    }
    
    private void CercaCittaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CercaCittaMousePressed
        //reset delle componenti della ricerca precedente
        resetLabelMeteo();
        Maps.setIcon(null);
        descBreveCitta.setText("");
        descrizioneBigCitta.setText("");               
        linkWiki.setVisible(false);
        
        //se entrambi i campi sono vuoti invia un mess con richiesta di inserimento
        if (CittaMaps.getText().trim().isEmpty() & StatoMaps.getText().trim().isEmpty()){
            cittaSelezionata = "Inizializza città ";
            CercaCitta.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Inserisci la città o lo stato!");
            CercaCitta.setEnabled(true);
            SalvaDB.setVisible(false);
            
            //se il campo città è vuoto setta solo il campo stato
        }else if(CittaMaps.getText().trim().isEmpty()){
            String stato = StatoMaps.getText().trim();
            stato = stato.substring(0, 1).toUpperCase() + stato.substring(1).toLowerCase();
            
            progetto.setStato(stato);
            
            jsonInsertDataDB = new JSONObject("{citta:'null', stato:" + stato + ", ampiezza:'null'}");
            
            setAllRequest(stato);
            
            //se il campo di stato è vuoto setta solo il campo città
        }else if(StatoMaps.getText().trim().isEmpty()){
            String citta = CittaMaps.getText().trim();
            citta = citta.substring(0, 1).toUpperCase() + citta.substring(1).toLowerCase(); 
            
            progetto.setCitta(citta);
            jsonInsertDataDB = new JSONObject("{citta:" + citta + ", stato: 'null', ampiezza:'null'}");
            
            setAllRequest(citta);
            //se entrambi i campi sono settati
        }else{
            
            String stato = StatoMaps.getText().trim();
            stato = stato.substring(0, 1).toUpperCase() + stato.substring(1).toLowerCase();
            
            String citta = CittaMaps.getText().trim();
            citta = citta.substring(0, 1).toUpperCase() + citta.substring(1).toLowerCase();
            
            progetto.setCitta(citta);
            progetto.setStato(stato);
            jsonInsertDataDB = new JSONObject("{citta:" + citta + ", stato:" + stato + ", ampiezza:'null'}");
            
            setAllRequest(citta);
        }
    }//GEN-LAST:event_CercaCittaMousePressed
    
    JSONObject jsonInsertDataDB;
    //settare i valori di città stato meteo e astronomia
    private void setAllRequest(String luogo){
        //richiama funzione per il meteo
        String statoMeteo = RicercaMeteo(luogo);
        if(statoMeteo.equals("OK")){
            File tempFile = new File( "src/main/java/client/cache/mapsImage/"+ luogo + ".jpg" );
            //se è presente in cache:
            if(tempFile.exists()){
                ImageIcon mappa = new ImageIcon("src/main/java/client/cache/mapsImage/"+ luogo + ".jpg");
                Maps.setIcon(mappa);
                
                //se non è presente in cache invia la richiesta al server
            }else{

                String folderDaInviare = jsonInsertDataDB.toString();
                ConnectionHTTP http = new ConnectionHTTP();
                try {
                    String url = "/HEREmaps";
                    http.sendPost(folderDaInviare, url);
                } catch (Exception ex) {
                    Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
                    ImageIcon mappa = new ImageIcon("src/main/java/client/cache/mapsImage/"+ luogo + ".jpg");
                    Maps.setIcon(mappa);
            }
            wikiAPI(luogo);
            cittaStatoCercato = luogo;
            cittaSelezionataDB = luogo;
            SalvaDB.setVisible(true);
            linkWiki.setVisible(true);
        }else if(statoMeteo.equals("404.0")){
            SalvaDB.setVisible(false);
            linkWiki.setVisible(false);
        }else{
            System.out.println("Errore inaspettato");
        }
    }
    private void PushMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PushMousePressed
        //raccolta dati db progetti esistenti
        String url = "/DB/project/full";
        String res = null;
        try {
            res = new ConnectionHTTP().sendPost(idUtenteLoggato,url);
        } catch (Exception ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!"0".equals(res)) {
           JSONArray jsonArray = new JSONArray(res);
            JSONObject explrObject = null;
            //dichiarazione tabella
            String colums1 [] = {"Nome Progetto", "Città", "Stato", "Data Creazione"};
            model1 = new DefaultTableModel();
            model1.setColumnIdentifiers(colums1);
            int i = 0;
            Integer id = null;
            String nomeProgetto, citta, stato, dataCreazione;
            while (i < jsonArray.length()) {
                explrObject = jsonArray.getJSONObject(i);
                //non so l'id può sempre servire
                id = explrObject.getInt("id");
                nomeProgetto = explrObject.getString("nomeProgetto");
                citta = explrObject.getString("citta");
                stato = explrObject.getString("stato");
                dataCreazione = explrObject.getString("dataCreazione");
                
                Object data [] = {nomeProgetto, citta, stato, dataCreazione};
                    
                    model1.addRow(data);
                i++;
            }
            tableProject.setModel(model1);
        }else if("0".equals(res)){
            String colums1 [] = {"Nome Progetto", "Città", "Stato", "Data Creazione"};
            model2 = new DefaultTableModel();
            model2.setColumnIdentifiers(colums1);
        
        }
    }//GEN-LAST:event_PushMousePressed

    private void ResetNotaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetNotaMousePressed
        ResetNota.setVisible(false);
        Delete.setVisible(false);
        Salva.setVisible(true);
        NoteName.setText("");
        NoteName.setEditable(true);
        TextArea.setText("");
        TextArea.setEditable(true);
    }//GEN-LAST:event_ResetNotaMousePressed

    private void VisualizzaStatisticheMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VisualizzaStatisticheMousePressed
        String dati = null;
        String url = "/DB";
        try {
            dati = new ConnectionHTTP().sendGet(url);
        } catch (Exception ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultCategoryDataset barchartdata = new DefaultCategoryDataset();
        JSONArray array = new JSONArray(dati);
        String stato;
        Integer totale;
        for(int i = 0 ; i < array.length() ; i++){
            stato = array.getJSONObject(i).getString("stato");
            totale = array.getJSONObject(i).getInt("tot");
            barchartdata.setValue(totale, stato, stato);
        }
        
        JFreeChart barChart = ChartFactory.createAreaChart("Statistiche: stati più ricercati", "Stati", "Numero Città", barchartdata, PlotOrientation.VERTICAL, true, true, true);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.ORANGE);
        ChartPanel barPanel = new ChartPanel(barChart);
        JPanel grafico = new JPanel();
        grafico.removeAll();
        grafico.add(barPanel, BorderLayout.CENTER);
        grafico.validate();
        JFrame frame = new JFrame("Statistiche TANGOapp");
        frame.add(grafico);
        frame.pack();
        frame.setVisible(true);

    }//GEN-LAST:event_VisualizzaStatisticheMousePressed

    private void GetPDFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GetPDFMousePressed
        String url = "/generaPDF";
        try {
            new ConnectionHTTP().sendGetPDF(url + "?progetto=" + detailProject6.getText() + "&idUtente=" + idUtenteLoggato);
        } catch (Exception ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GetPDFMousePressed

    private void PostPDFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PostPDFMousePressed
        String url = "/generaPDF";
        String code = codiceUnivoco.getText().trim();
        String pdf = null;
        try {
            pdf = new ConnectionHTTP().sendPost(code,url);
        } catch (Exception ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(pdf);
    }//GEN-LAST:event_PostPDFMousePressed
//funzioni per avere l'ID dal menù a tendina
    private HashMap<String, Integer> datiPerTendina() throws Exception{
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("<seleziona un progetto>", 0);
        //raccolta dati db progetti esistenti
        String url = "/DB/project";
        String res = new ConnectionHTTP().sendPost(idUtenteLoggato,url);
        comboItem cmi;
        if(!"[Create a new project]".equals(res)) {
           JSONArray jsonArray = new JSONArray(res);
            JSONObject explrObject;
            int i = 0;
            Integer id;
            String nomePogetto;
            while (i < jsonArray.length()) {
                explrObject = jsonArray.getJSONObject(i);
                //System.out.println(explrObject);
                id = explrObject.getInt("id");
                nomePogetto = explrObject.getString("nomeProgetto");
                //gestione tendina scelta progetto
                cmi = new comboItem(id, nomePogetto);
                map.put(cmi.getCatName(), cmi.getCatId());
                
                i++;
            }
        }else{
            System.out.println("Non ci sono progetti!");
        }
        return map;
    } 
    //aggiunge i valori al Jcombobox
    private void BindCombo() throws Exception{
        
        HashMap<String, Integer> map = datiPerTendina();
        for(String s : map.keySet()){
            projectName.addItem(s);
        }
        
    }
    //listner per avere il nome relativo all'id della tendina selezionato col mouse
    private void projectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectNameActionPerformed
        String verifica = (String) projectName.getItemAt(1);
        //System.out.println(verifica);
        if(verifica != null){
            try {                                            

                HashMap<String, Integer> map;
                //prendo i valori della tendina
                map = datiPerTendina();
                /*
                System.out.println("\nStampo map in performed: "+ map+ 
                        "\n provo index 0: "+ projectName.getItemAt(0)+
                        "\n provo index 1: "+ projectName.getItemAt(1)+
                        "\n provo index 2: "+ projectName.getItemAt(2)+
                        "\n provo index 3: "+ projectName.getItemAt(3)+
                        "\n")*/
                //prendo l'id selezionato
                String id = map.get(projectName.getSelectedItem().toString()).toString();
                //cerco il nome corrispondente all'id dal DB
                String urlproject = "/DB/project?idProgetto="+ id;
                String res = null;
                try {
                    res = new ConnectionHTTP().sendGet(urlproject);
                } catch (Exception ex) {
                    Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
                }

                if(!"[Create a new project]".equals(res)) {
                    Start.setEnabled(true);
                    JSONArray jsonArray = new JSONArray(res);
                    JSONObject explrObject;
                    int i = 0;
                    String nomePogetto;
                    while (i < jsonArray.length()) {
                        explrObject = jsonArray.getJSONObject(i);
                        //System.out.println(explrObject);
                        nomePogetto = explrObject.getString("nomeProgetto");
                        nomeProgettoAttuale = nomePogetto;
                        i++;
                    }
                    idProgetto = id;
                    nomePrincproject.setText(nomeProgettoAttuale);
                    //System.out.println("IDPROGETTO: " + idProgetto + "\nNOMEPROGETTO SELEZIONATO: " + nomeProgettoAttuale);

                }else{
                    Start.setEnabled(false);
                    Start.setOpaque(true);
                }

            } catch (Exception ex) {
                Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_projectNameActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Blackboard;
    private javax.swing.JButton CercaCitta;
    private javax.swing.JLabel Cielo;
    private javax.swing.JTextField CittaMaps;
    private javax.swing.JLabel Data0;
    private javax.swing.JLabel Data1;
    private javax.swing.JLabel Data2;
    private javax.swing.JLabel Data3;
    private javax.swing.JLabel Data4;
    private javax.swing.JLabel Data5;
    private javax.swing.JButton Delete;
    private javax.swing.JPanel DownloadPanel;
    private javax.swing.JPanel Dropbox;
    private javax.swing.JTextField FolderName;
    private javax.swing.JButton GetPDF;
    private javax.swing.JPanel HEREmaps;
    private javax.swing.JPanel Homepage;
    private javax.swing.JPanel InterfaceAfterLog;
    private javax.swing.JTabbedPane JTabbed;
    private javax.swing.JButton Logout;
    private javax.swing.JLabel Maps;
    private javax.swing.JTextField MeteoView;
    private javax.swing.JTextField NoteName;
    private javax.swing.JPanel OpenWeather;
    private javax.swing.JPanel PanelGrafico;
    private javax.swing.JButton PostPDF;
    private javax.swing.JButton Push;
    private javax.swing.JButton ResetNota;
    private javax.swing.JButton Salva;
    private javax.swing.JButton SalvaDB;
    private javax.swing.JButton SetEmpty;
    private javax.swing.JButton Start;
    private javax.swing.JPanel StatisticsPanel;
    private javax.swing.JTextField StatoMaps;
    private javax.swing.JTable Tabella;
    private javax.swing.JTextField TemperaturaMassima;
    private javax.swing.JTextField TemperaturaMinima;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JPanel TutorialPage;
    private javax.swing.JTextField Umidita;
    private javax.swing.JTextField Vento;
    private javax.swing.JButton VisualizzaStatistiche;
    private javax.swing.JTextField codiceUnivoco;
    private javax.swing.JTextArea descBreveCitta;
    private javax.swing.JLabel descrizione0;
    private javax.swing.JLabel descrizione1;
    private javax.swing.JLabel descrizione2;
    private javax.swing.JLabel descrizione3;
    private javax.swing.JLabel descrizione4;
    private javax.swing.JLabel descrizione5;
    private javax.swing.JTextArea descrizioneBigCitta;
    private javax.swing.JLabel detailCity0;
    private javax.swing.JLabel detailCity1;
    private javax.swing.JLabel detailCity2;
    private javax.swing.JLabel detailCity3;
    private javax.swing.JLabel detailCity4;
    private javax.swing.JLabel detailCity5;
    private javax.swing.JLabel detailProject0;
    private javax.swing.JLabel detailProject1;
    private javax.swing.JLabel detailProject2;
    private javax.swing.JLabel detailProject3;
    private javax.swing.JLabel detailProject4;
    private javax.swing.JLabel detailProject5;
    private javax.swing.JLabel detailProject6;
    private javax.swing.JLabel fase0;
    private javax.swing.JLabel fase1;
    private javax.swing.JLabel fase2;
    private javax.swing.JLabel fase3;
    private javax.swing.JLabel fase4;
    private javax.swing.JLabel fase5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel latitudine;
    private javax.swing.JLabel linkWiki;
    private javax.swing.JLabel longitudine;
    private javax.swing.JLabel lunaA0;
    private javax.swing.JLabel lunaA1;
    private javax.swing.JLabel lunaA2;
    private javax.swing.JLabel lunaA3;
    private javax.swing.JLabel lunaA4;
    private javax.swing.JLabel lunaA5;
    private javax.swing.JLabel lunaB0;
    private javax.swing.JLabel lunaB1;
    private javax.swing.JLabel lunaB2;
    private javax.swing.JLabel lunaB3;
    private javax.swing.JLabel lunaB4;
    private javax.swing.JLabel lunaB5;
    private javax.swing.JLabel nomePrincproject;
    private javax.swing.JComboBox projectName;
    private javax.swing.JLabel soleA0;
    private javax.swing.JLabel soleA1;
    private javax.swing.JLabel soleA2;
    private javax.swing.JLabel soleA3;
    private javax.swing.JLabel soleA4;
    private javax.swing.JLabel soleA5;
    private javax.swing.JLabel soleB0;
    private javax.swing.JLabel soleB1;
    private javax.swing.JLabel soleB2;
    private javax.swing.JLabel soleB3;
    private javax.swing.JLabel soleB4;
    private javax.swing.JLabel soleB5;
    private javax.swing.JTable tableProject;
    private javax.swing.JLabel timezone;
    // End of variables declaration//GEN-END:variables
}
