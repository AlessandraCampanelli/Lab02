

package it.polito.tdp.alien;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.alien.traduttore.Traduttore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
 private Traduttore model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParole;

    @FXML
    private TextArea txtResult;

    @FXML
    void doReset(ActionEvent event) {
    	model.cancellaTutto();
    	txtResult.setText("Ripristinato");

    }

    @FXML
    void doTraslate(ActionEvent event) {
String parole =txtParole.getText();
 char p[]= parole.toCharArray();
 
 String par ="";
 String trad= "";
 int j=0;
 // TROVO QUANDO LE DUE PAROLE SONO SEPARATE DA UNO SPAZIO --> SIGNIFICA CHE HO LA TRADUZIONE 
    	for(int i=0;i<p.length;i++)
    		if(p[i]==' ')
    			j=i;
  //CONDIZIONI SUGLI >> E SULLO SPAZIO.. SE HO LO SPAZIO E TUTTI I <> ALLORA POSSA AGGIUNGERE LA PAROLA  
    	boolean trovato=false;
    //VERIFICO LA CORRETTEZZA DEL FORMATO  PAROLA-TRADUZIONE	
    if(j!=0) {
 if(p[0]=='<')
	 trovato=true;
 if(p[j-1]=='>' )
	 trovato=true;
	 if(p[j+1]=='<')
		 trovato=true;
		 if(p[p.length-1]=='>')
			 trovato=true;
 }	
    	//SE IL FORMATO E' GIUSTO SEPARO LE PAROLE 
    		if(trovato==true) {
    	for(int i=1;i<j-1;i++)
    	par=par+p[i];
    	for(int i=j+2;i<p.length-1;i++)
        	trad=trad+p[i];
    		}
    	 // SE HO SOLO UNA PAROLA E IL FORMATO E' GIUSTO ALLORA FORMO LA PAROLA 
    	if(j==0)
    		if(p[0]=='<' && p[p.length-1]=='>')
    		for(int i=1;i<p.length-1;i++)
    	    	par=par+p[i];	
    	//SE HO PAROLA-TRADUZIONE E SE E' STATA AGGIUNTA CORRETTAMENTE 
    	if(trad!="") {
    		
    	if(model.aggiuntaParole(par,trad)==true)	
    txtResult.setText("Parola aggiunta correttamente ");
    	else 
    		txtResult.setText("Parola NON  aggiunta correttamente ");
    	}
    	
    	//LinkedList <String >cP= new LinkedList<String>(model.cercaParola(par));
    	//SE HO SOLO LA PAROLA 
    	
    	if(trad=="" &&  model.cercaParola(par)==null)
    		 txtResult.setText("LA PAROLA NON è PRESENTE NELL'ELENCO O NON E' STATA INSERITA IN MODO CORRETTO" );
    	else if(trad=="" )
    		
    	 txtResult.setText("la traduzione è:"+model.cercaParola(par).toString());
    }
    public void setModel(Traduttore model) {
    	this.model=model;
    }
    @FXML
    void initialize() {
        assert txtParole != null : "fx:id=\"txtParole\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}