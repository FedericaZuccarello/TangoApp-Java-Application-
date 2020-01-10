
package server.generatorePDF;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.ws.rs.Produces;
import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import server.ApplicationCredentials;
import server.HERE.HEREweather.HEREweatherAPI;
import server.Wikipedia.WikipediaAPI;
import server.dropbox.DropboxAPI;
import server.phpMyAdmin.DatabaseHandler;
import server.weather.WeatherAPI;

/**
 *
 * @author Zuccarello Federica
 */
public class generatorePDF extends ServerResource {
    @Get
    @Produces("application/pdf")
    public String getPDF() throws Exception{
        
        
        //acquisizione dati del client
        String progetto = getQueryValue("progetto");
        String idUtente = getQueryValue("idUtente");
        
        //creazione codice univoco identificativo del PDF
        RandomString gen = new RandomString(12, ThreadLocalRandom.current());
        String uniqueCode = gen.nextString();
        //nome PDF con codice univoco
        String pdfFileName = progetto+"-"+uniqueCode+".pdf";
        //creazione PDF
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("src/main/java/server/cache/pdf/"+pdfFileName));
        
        //apertura documento
        document.open();
        
        //creazione informazioni di base PDF e prima pagina
        basedPDF(document, idUtente, progetto, uniqueCode);
        
        //conteggio degli elementi restituiti dalla query sul DB(città salvate relative al progetto voluto)
        Integer count = 1;
        //richiesta al DB per avere tutti i dati relativi al progetto selezionato
        List<String> res = new DatabaseHandler().QuerygetFullProject(idUtente);
        for (String dataString : res) {
            
            JSONObject object = new JSONObject(dataString);
            
            //se il campo cercato non è stato restituito dal DB: 
            if(!object.get("nomeProgetto").equals(progetto)){
                                
            //se il campo cercato 'progetto' è stato restituito dal DB nel campo 'nomeProgetto'
            //prendi i campi di ogni progetto ed inseriscili nel PDF.    
            }else if(object.get("nomeProgetto").equals(progetto)){
                
    //UTILIZZO DATI DB
                String citta = object.getString("citta");
                String data = object.getString("dataCreazione");
                String stato = object.getString("stato");
                
        //CREAZIONE CAPITOLO con titolo relativo ad ogni città.
                Paragraph title = new Paragraph(citta + ", " + stato, FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC));
                Chapter chapter = new Chapter(title, count);
                
            //creazione DATA creazione
                Paragraph dataCreazione = new Paragraph("DATA CREAZIONE PROGETTO: " + data, FontFactory.getFont(FontFactory.COURIER, 11, Font.ITALIC));
                dataCreazione.setAlignment(Paragraph.ALIGN_RIGHT);
                chapter.add(dataCreazione);
                
                //RICHIAMO API WIKIPEDIA
                String wiki = new WikipediaAPI().sendGet(citta.trim());
                JSONObject totDati = new JSONObject(wiki);
                
                JSONObject jsonArray = totDati.getJSONObject("query");
                //System.out.println("jsonArray: "+jsonArray);
                JSONObject oggettoJson = jsonArray.getJSONObject("pages");
                //prendere il primo valore dell'oggetto json senza sapere la chiave
                Iterator<String> keys = oggettoJson.keys();
                String chiave = null;
                if( keys.hasNext() ){
                String key = (String)keys.next(); // First key in your json object
                chiave=key;
                }
                //System.out.println("chiave:"+chiave);
                if("-1".equals(chiave)){
                    System.out.println("Non ho trovato l'oggetto desiderato!");
                }else{
                    //si utilizza la chiave trovata per avere il json dei dettagli
                    JSONObject dettagliRicerca = oggettoJson.getJSONObject(chiave);
                    String dettagliSmall = dettagliRicerca.getString("description");
                    String dettagliLarge = dettagliRicerca.getString("extract");
                //paragrafo relativo al capitolo
                    Paragraph someSectionText = new Paragraph(dettagliSmall);
                    chapter.add(someSectionText);
            //CREAZIONE SEZIONE WIKIPEDIA 
                    Paragraph titleSection1 = new Paragraph("Descrizione", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD));
                    //inserisco descrizione di Wikipedia nella sezione 
                    Paragraph testoSection = new Paragraph(dettagliLarge);
                    
                    //aggiungo link Wikipedia 
                    Paragraph linkWiki = new Paragraph();
                    linkWiki.add(new Phrase("\n"+"Se vuoi continuare a leggere "));
                    Anchor anchor = new Anchor("clicca qui!");
                    anchor.setReference("https://it.wikipedia.org/wiki/" + citta);
                    linkWiki.add(anchor);
                    
                    //aggiungo linkwiki a testoSection
                    testoSection.add(linkWiki);
                    //aggiungo il testo alla sezione
                    titleSection1.add(testoSection);
                    //aggiungo la sezione al capitolo
                    chapter.addSection(titleSection1);
                    
            // CREAZIONE SEZIONE MAPPA    
                    Paragraph titleSection2 = new Paragraph("Mappa", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD));
                    Paragraph descMappa = new Paragraph("Di seguito viene rappresentata la mappa relativa a: " + citta);
                    //RICHIAMO API HEREmaps 
                    Image image = Image.getInstance(new URL("https://image.maps.api.here.com/mia/1.6/mapview?i=1&app_id="+new ApplicationCredentials().getAPP_ID()+"&app_code="+new ApplicationCredentials().getAPP_CODE()+"&ci="+citta));
                    
                    //aggiungo il paragrafo e la mappa
                    titleSection2.add(descMappa);
                    titleSection2.add(image);
                   
                    //aggiungo la sezione al capitolo
                    chapter.addSection(titleSection2);
            // CREAZIONE SEZIONE METEO E ASTRONOMIA
                    
                    String weather = new WeatherAPI().sendGet(citta);
                    String astronomy = new HEREweatherAPI().sendGet(citta);
                    Paragraph titleSection3 = meteoTab(weather, astronomy);   
                    
                    chapter.addSection(titleSection3);
            
                    
                    
                //Aggiungi tutti i capitoli al documento
                    document.add(chapter);
                    
                }
                count ++;
            }else{
                System.out.println("Errore inaspettato!");
            }
        }
        // CREAZIONE SEZIONE NOTE       
            Chapter chapter2 = capNote(idUtente, progetto, count);
            document.add(chapter2);
        
        //chiudi il documento PDF e la sua scrittura 
        document.close();
        writer.close();
        //inserire nel DB il PDF con il codice indentificativo
        new DatabaseHandler().QuerypostPDF(document, uniqueCode, idUtente, pdfFileName);
        
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("src/main/java/server/cache/pdf/"+pdfFileName);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                System.out.println("Installa un'applicazione che supporti i file con estensione .pdf");
            }
        }
        
        return "{nomePDF:"+ pdfFileName+"}";
    }
    //CREAZIONE INFORMAZIONI DI BASE PDF (PRIMAPAGINA)
    public void basedPDF(Document document, String idUtente, String progetto, String uniqueCode) throws DocumentException{
        
        //Settaggio attributi relativi al PDF
        document.addAuthor("Federica Zuccarello");
        document.addCreationDate();
        document.addCreator("ProgettoJavaEsame");
        document.addTitle("Prospettiva progetto: " + progetto);
        document.addSubject("In questo PDF troverai tutto il materiale relativo al tuo progetto: " + progetto);
        //creazione titolo documento
        Paragraph chapterTitle = new Paragraph("Itinerario informativo TANGOapp", FontFactory.getFont(FontFactory.HELVETICA, 19, Font.BOLDITALIC));
        chapterTitle.setAlignment(Paragraph.ALIGN_CENTER);
        Chapter chapterBig = new Chapter(chapterTitle, 1);
        chapterBig.setNumberDepth(0);
        document.add(chapterBig);
        
        //creazione sottotitolo
        Paragraph chapterSubTitle = new Paragraph("\nNOME PROGETTO: "+ progetto, FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL));
        chapterSubTitle.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(chapterSubTitle);
        //creazione Paragrafo idUtente
        Paragraph idUtentePar = new Paragraph("COD.ID.UTENTE: "+ idUtente, FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL));
        idUtentePar.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(idUtentePar);
        //creazione Paragrafo codiceUnivocoProgetto
        
        Paragraph univCode = new Paragraph("COD.ID.PDF: "+ uniqueCode, FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL));
        univCode.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(univCode);
        //creazione data
        Paragraph chapterData = new Paragraph("DATA CREAZIONE PDF: "+ setDataOdierna(), FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL));
        chapterData.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(chapterData);
        //creazione testo pagina principale
        Paragraph text = new Paragraph("\n"+"Questo PDF è stato generato dall'applicazione TANGOapp."
                + "\nEssa ti permette di:"
                + "\n- creare il tuo progetto includento tutte le città del mondo che vorrai visitare;"
                + "\n- visualizzare una mappa della città o dello stato selezionato;"
                + "\n- conoscere la loro storia ed approfondire con i contenuti tratti da Wikipedia;"
                + "\n- consultare il meteo per avere le loro info dettagliate in tempo reale;"
                + "\n- accedere a delle curiosità riguardanti l'astronomia e le coordinate geografiche;"
                + "\n- creare le tue note di viaggio in maniera semplice ed efficace;"
                + "\n- visualizzare ed eliminare le tue note da qualsiasi parte del mondo;"
                + "\n- tenere sempre sotto controllo tutti i tuoi progetti e le relative città;"
                + "\n- visualizzare le statistiche in tempo reale dei progetti di tutti gli utenti registrati;"
                + "\n- scaricare il PDF del tuo progetto così da portarlo comodamente con te in viaggio;"
                + "\n"
                + "\nDi seguito troverai:"
                + "\n- la lista delle città relative al progetto: "+progetto
                + " con i relativi dettagli, quali:"
                + "\n   * descrizione dettagliata e storia della città con link di approfondimento;"
                + "\n   * mappa della città formato jpeg;"
                + "\n   * meteo attuale con relativa temperatura massima, minima, umidità, vento e descrizione;"
                + "\n   * coordinate geografiche quali latitudine longitudine e timezone;"
                + "\n   * astronomia per 8 giorni con: fasi lunari e descrizione, orari dell'alba e tramonto solare e lunare;"
                + "\n- tutte le note relative al progetto;");
        document.add(text);
        
    }
    //CREAZIONE TABELLA METEO
    public Paragraph meteoTab(String meteo, String astronomia) throws DocumentException{
        JSONObject meteoObject = new JSONObject(meteo);
        JSONObject astronomiaObject = new JSONObject(astronomia);
    
        Integer verificaStato = meteoObject.getInt("cod");
        if(verificaStato == 404 ){
            return null; 
        }else{
            Paragraph titleSection3 = new Paragraph("Curiosità", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD));
            Paragraph subTitleSection3 = new Paragraph("Meteo attuale", FontFactory.getFont(FontFactory.HELVETICA, 13, Font.ITALIC));
    //settaggio tabella
            PdfPTable table = new PdfPTable(2); // 2 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(10f); //Space before table
            table.setSpacingAfter(10f); //Space after table

            //Set Column widths
            float[] columnWidths = {1f, 1f};
            table.setWidths(columnWidths);
    //inseriemnto valori
            Double temperatura , tempMin , tempMax, umidity ;
            JSONObject Temperature = meteoObject.getJSONObject("main");
            temperatura = Temperature.getDouble("temp");
            tempMin = Temperature.getDouble("temp_min");
            tempMax = Temperature.getDouble("temp_max");
            umidity = Temperature.getDouble("humidity");
            
    //RIGA TEMPERATURA ATTUALE
            //converto da Kelvin a Celsius
            temperatura = toCelsius(temperatura);
            //arrotondo alla prima cifra dopo la virgola
            String tempArrot = arrotondo(temperatura);
            
            PdfPCell cell1A = new PdfPCell(new Paragraph("Temperatura"));
            cell1A.setBorderColor(BaseColor.BLACK);
            cell1A.setPaddingLeft(10);
            cell1A.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1A.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell2A = new PdfPCell(new Paragraph(tempArrot + "°"));
            cell2A.setBorderColor(BaseColor.GREEN);
            cell2A.setPaddingLeft(10);
            cell2A.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2A.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table.addCell(cell1A);
            table.addCell(cell2A);
            
    //RIGA TEMPERATURA MINIMA
            tempMin = toCelsius(tempMin);
            String tempMinArrot = arrotondo(tempMin);
            
            PdfPCell cell1B = new PdfPCell(new Paragraph("Temperatura Minima"));
            cell1B.setBorderColor(BaseColor.BLACK);
            cell1B.setPaddingLeft(10);
            cell1B.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1B.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell2B = new PdfPCell(new Paragraph(tempMinArrot + "°"));
            cell2B.setBorderColor(BaseColor.BLUE);
            cell2B.setPaddingLeft(10);
            cell2B.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2B.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table.addCell(cell1B);
            table.addCell(cell2B);
            
    //RIGA TEMPERATURA MASSIMA
            tempMax = toCelsius(tempMax);
            String tempMaxArrot = arrotondo(tempMax);
                       
            PdfPCell cell1C = new PdfPCell(new Paragraph("Temperatura Massima"));
            cell1C.setBorderColor(BaseColor.BLACK);
            cell1C.setPaddingLeft(10);
            cell1C.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1C.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell2C = new PdfPCell(new Paragraph(tempMaxArrot + "°"));
            cell2C.setBorderColor(BaseColor.RED);
            cell2C.setPaddingLeft(10);
            cell2C.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2C.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table.addCell(cell1C);
            table.addCell(cell2C);        
            
    //RIGA UMIDITA'        
            PdfPCell cell1D = new PdfPCell(new Paragraph("Umidità"));
            cell1D.setBorderColor(BaseColor.BLACK);
            cell1D.setPaddingLeft(10);
            cell1D.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1D.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell2D = new PdfPCell(new Paragraph(String.valueOf(umidity) + "%"));
            cell2D.setBorderColor(BaseColor.BLACK);
            cell2D.setPaddingLeft(10);
            cell2D.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2D.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table.addCell(cell1D);
            table.addCell(cell2D);         

    //RIGA VENTO
            JSONObject velocitaVento = meteoObject.getJSONObject("wind");
            double vento = velocitaVento.getDouble("speed");
            
            PdfPCell cell1E = new PdfPCell(new Paragraph("Vento"));
            cell1E.setBorderColor(BaseColor.BLACK);
            cell1E.setPaddingLeft(10);
            cell1E.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1E.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell2E = new PdfPCell(new Paragraph(String.valueOf(vento)+" Km/h"));
            cell2E.setBorderColor(BaseColor.BLACK);
            cell2E.setPaddingLeft(10);
            cell2E.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2E.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table.addCell(cell1E);
            table.addCell(cell2E);   
        
    //RIGA DESCRIZIONE METEO
            JSONArray CieloT = meteoObject.getJSONArray("weather");
            PdfPCell cell2F = null;
            JSONObject explrObject = null;
            int i = 0;
            while (i < CieloT.length()) {
                explrObject = CieloT.getJSONObject(i);
                cell2F = new PdfPCell(new Paragraph(explrObject.getString("description")));
                i++;
            }
            
            PdfPCell cell1F = new PdfPCell(new Paragraph("Descrizione"));
            cell1F.setBorderColor(BaseColor.BLACK);
            cell1F.setPaddingLeft(10);
            cell1F.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1F.setVerticalAlignment(Element.ALIGN_MIDDLE);

            
            cell2F.setBorderColor(BaseColor.BLACK);
            cell2F.setPaddingLeft(10);
            cell2F.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2F.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table.addCell(cell1F);
            table.addCell(cell2F);        
            
            //aggiungo la tabella alla sottosezione
            subTitleSection3.add(table);
            //aggiungo la sottosezione alla sezione
            titleSection3.add(subTitleSection3);
          
            Paragraph subTitle2Section3 = new Paragraph("Coordinate Geografiche", FontFactory.getFont(FontFactory.HELVETICA, 13, Font.ITALIC));
            //settaggio tabella
            PdfPTable table2 = new PdfPTable(2); // 2 columns.
            table2.setWidthPercentage(100); //Width 100%
            table2.setSpacingBefore(10f); //Space before table
            table2.setSpacingAfter(10f); //Space after table

            //Set Column widths
            float[] columnWidths2 = {1f, 1f};
            table2.setWidths(columnWidths2);
 
        //GESTIONE ASTRONOMIA
            
            JSONObject coord = astronomiaObject.getJSONObject("astronomy");

            Double latitud = coord.getDouble("latitude");
            Double longitud = coord.getDouble("longitude");
            Float timeZone = coord.getFloat("timezone");
            
            PdfPCell cellA1 = new PdfPCell(new Paragraph("Latitudine"));
            cellA1.setBorderColor(BaseColor.BLACK);
            cellA1.setPaddingLeft(10);
            cellA1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellA1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cellB1 = new PdfPCell(new Paragraph(latitud.toString()));
            cellB1.setBorderColor(BaseColor.BLACK);
            cellB1.setPaddingLeft(10);
            cellB1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellB1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table2.addCell(cellA1);
            table2.addCell(cellB1);
            
            PdfPCell cellA2 = new PdfPCell(new Paragraph("Longitudine"));
            cellA2.setBorderColor(BaseColor.BLACK);
            cellA2.setPaddingLeft(10);
            cellA2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellA2.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cellB2 = new PdfPCell(new Paragraph(longitud.toString()));
            cellB2.setBorderColor(BaseColor.BLACK);
            cellB2.setPaddingLeft(10);
            cellB2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellB2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table2.addCell(cellA2);
            table2.addCell(cellB2);
            
            PdfPCell cellA3 = new PdfPCell(new Paragraph("Timezone"));
            cellA3.setBorderColor(BaseColor.BLACK);
            cellA3.setPaddingLeft(10);
            cellA3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellA3.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cellB3 = new PdfPCell(new Paragraph(timeZone.toString()));
            cellB3.setBorderColor(BaseColor.BLACK);
            cellB3.setPaddingLeft(10);
            cellB3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellB3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table2.addCell(cellA3);
            table2.addCell(cellB3);
            
            //aggiungo la tabella alla sottosezione
            subTitle2Section3.add(table2);
            //aggiungo la sottosezione alla sezione
            titleSection3.add(subTitle2Section3);
            
            
            JSONArray astronomiaArray = astronomiaObject.getJSONObject("astronomy").getJSONArray("astronomy");
            
            Paragraph subTitle3Section3 = new Paragraph("Astronomia", FontFactory.getFont(FontFactory.HELVETICA, 13, Font.ITALIC));
            //settaggio tabella
            PdfPTable table3 = new PdfPTable(3); // 2 columns.
            table3.setWidthPercentage(100); //Width 100%
            table3.setSpacingBefore(10f); //Space before table
            table3.setSpacingAfter(10f); //Space after table

            //Set Column widths
            float[] columnWidths3 = {1f, 1f, 1f};
            table3.setWidths(columnWidths3);
 
        //GESTIONE ASTRONOMIA
                        
            JSONObject explrObject2 = null;
            int j = 0;
            while (j < astronomiaArray.length()) {
                explrObject2 = astronomiaArray.getJSONObject(j);
                //SUNRISE
                String sunriseSingolo = explrObject2.getString("sunrise");
               
                //SUNSET
                String sunsetSingolo = explrObject2.getString("sunset");
                
                //MOONRISE
                String moonriseSingolo = explrObject2.getString("moonrise");
                
                //MOONSET
                String moonsetSingolo = explrObject2.getString("moonset");
                
                //DATE
                String dateSingolo = explrObject2.getString("utcTime");
                String dataOrdinata = dateSingolo.substring(8,10) + dateSingolo.substring(4,8) +  dateSingolo.substring(0,4);
                
                //FASILUNARI
                Float fasiSingolo = explrObject2.getFloat("moonPhase");
                
                //DESCRIZIONE
                String descrizioneSingolo = explrObject2.getString("moonPhaseDesc");
                

                PdfPCell cellA4 = new PdfPCell(new Paragraph(dataOrdinata));
                cellA4.setBorderColor(BaseColor.RED);
                cellA4.setPaddingLeft(10);
                cellA4.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellA4.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cellB4 = new PdfPCell(new Paragraph("Rise"));
                cellB4.setBorderColor(BaseColor.RED);
                cellB4.setPaddingLeft(10);
                cellB4.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellB4.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cellC4 = new PdfPCell(new Paragraph("Set"));
                cellC4.setBorderColor(BaseColor.RED);
                cellC4.setPaddingLeft(10);
                cellC4.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellC4.setVerticalAlignment(Element.ALIGN_MIDDLE);

                table3.addCell(cellA4);
                table3.addCell(cellB4);
                table3.addCell(cellC4);
                
                PdfPCell cellA5 = new PdfPCell(new Paragraph("Sun"));
                cellA5.setBorderColor(BaseColor.BLACK);
                cellA5.setPaddingLeft(10);
                cellA5.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellA5.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cellB5 = new PdfPCell(new Paragraph(sunriseSingolo));
                cellB5.setBorderColor(BaseColor.BLACK);
                cellB5.setPaddingLeft(10);
                cellB5.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellB5.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cellC5 = new PdfPCell(new Paragraph(sunsetSingolo));
                cellC5.setBorderColor(BaseColor.BLACK);
                cellC5.setPaddingLeft(10);
                cellC5.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellC5.setVerticalAlignment(Element.ALIGN_MIDDLE);

                table3.addCell(cellA5);
                table3.addCell(cellB5);
                table3.addCell(cellC5);
                
                PdfPCell cellA6 = new PdfPCell(new Paragraph("Moon"));
                cellA6.setBorderColor(BaseColor.BLACK);
                cellA6.setPaddingLeft(10);
                cellA6.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellA6.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cellB6 = new PdfPCell(new Paragraph(moonriseSingolo));
                cellB6.setBorderColor(BaseColor.BLACK);
                cellB6.setPaddingLeft(10);
                cellB6.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellB6.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cellC6 = new PdfPCell(new Paragraph(moonsetSingolo));
                cellC6.setBorderColor(BaseColor.BLACK);
                cellC6.setPaddingLeft(10);
                cellC6.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellC6.setVerticalAlignment(Element.ALIGN_MIDDLE);

                table3.addCell(cellA6);
                table3.addCell(cellB6);
                table3.addCell(cellC6);
                
                PdfPCell cellA7 = new PdfPCell(new Paragraph("Moon Phase"));
                cellA7.setBorderColor(BaseColor.BLACK);
                cellA7.setPaddingLeft(10);
                cellA7.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellA7.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cellB7 = new PdfPCell(new Paragraph(fasiSingolo.toString()));
                cellB7.setBorderColor(BaseColor.BLACK);
                //cellB7.setPaddingLeft(10);
                cellB7.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellB7.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cellC7 = new PdfPCell(new Paragraph(descrizioneSingolo));
                cellC7.setBorderColor(BaseColor.BLACK);
                cellC7.setPaddingLeft(10);
                cellC7.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellC7.setVerticalAlignment(Element.ALIGN_MIDDLE);

                table3.addCell(cellA7);
                table3.addCell(cellB7);
                table3.addCell(cellC7);
                
                j++;
            }
            //aggiungo la tabella alla sottosezione
            subTitle3Section3.add(table3);
            //aggiungo la sottosezione alla sezione
            titleSection3.add(subTitle3Section3);
            
            return titleSection3;
        }
    }
    //gestione data attuale
    public String setDataOdierna(){
        //gestione data attuale
        GregorianCalendar gc = new GregorianCalendar();
        int giorno = gc.get(Calendar.DAY_OF_MONTH) ;
        int mese = gc.get(Calendar.MONTH);
        //perche il calendario gregoriano parte da 0 = gennaio
        mese = mese +1;
        int anno = gc.get(Calendar.YEAR);
        return(String.valueOf(giorno) + "-" + String.valueOf(mese) + "-" + String.valueOf(anno));
    }
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
    //CREAZIONE CAPITOLO NOTE
    public Chapter capNote(String idUtente, String progetto, Integer count) throws Exception{
        Paragraph titleNote = new Paragraph("Note", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD));
        
        String folderName, lastModified;
        //chiamata per restituire tutte le note relative al progetto
        String responso = new DropboxAPI().listFolder("/ProgettoJava/"+idUtente+"/"+progetto+"/");
        JSONObject jsonObject = new JSONObject(responso);
        //System.out.println(jsonObject);
        JSONArray jsonArray1 = jsonObject.getJSONArray("entries");
        JSONObject explrObject = null;

        int i = 0;
        while (i < jsonArray1.length()) {
            explrObject = jsonArray1.getJSONObject(i);
            if("file".equals(explrObject.getString(".tag"))){
                folderName = explrObject.getString("name");
                lastModified = explrObject.getString("client_modified");
                //manipolazione della stringa ultima modifica
                String dataUltimaModifica = lastModified.substring(8,10) + lastModified.substring(4,8) +  lastModified.substring(0,4);
                String oraUltimaModifica = lastModified.substring(11,19);
                String dataEOraUltimaModifica = dataUltimaModifica + " " + oraUltimaModifica;
                //chiamata per restituire il contenuto di ogni nota relativa al progetto
                String nota = new DropboxAPI().getFile("/ProgettoJava/"+idUtente+"/"+progetto+"/"+folderName);
                Paragraph subTitleSection4 = new Paragraph("NOME NOTA: "+ folderName+"\n", FontFactory.getFont(FontFactory.COURIER, 13, Font.BOLDITALIC));
                subTitleSection4.setAlignment(Paragraph.ALIGN_MIDDLE);
                Paragraph testoNota = new  Paragraph(nota.substring(1, nota.length()-1).replaceAll(",", "\n"));
                Paragraph dataeora = new  Paragraph("ULTIMA MODIFICA: "+dataEOraUltimaModifica+"\n", FontFactory.getFont(FontFactory.COURIER, 11, Font.ITALIC));
                dataeora.setAlignment(Paragraph.ALIGN_RIGHT);
                titleNote.add(subTitleSection4);                
                titleNote.add(testoNota);
                titleNote.add(dataeora);
            }
            i++;
        }
        Chapter chapter2 = new Chapter(titleNote, count);
        return chapter2;
    }
    @Post
    public String postPDF(String codice) throws Exception{
        String res = new DatabaseHandler().QuerygetPDF(codice);
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("src/main/java/server/cache/pdf/"+ res);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                System.out.println("Installa un'applicazione che supporti i file con estensione .pdf");
            }
        }
        return "Ecco il PDF con il codice: " + codice;
    }
}

           