package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	LinkedList <String> tempi = new LinkedList<String>();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML // fx:id="btnCancella"
    private Button btnCancella; // Value injected by FXMLLoader

    @FXML // fx:id="txtTime"
    private TextArea txtTime; // Value injected by FXMLLoader
    
    @FXML
    void doInsert(ActionEvent event) {
    	// TODO
    
    	String parola = txtParola.getText().toLowerCase(); //se no quando scrivo in maiuscolo
    	// non mette in ordine
    	
    	if ( parola != "") { // altrimenti se premo inserisci, inserisce una linea vuota
	    	
    		elenco.addParola(parola);
	    	elenco.getElenco();
	    	txtResult.setText(""+elenco.toString());
	    	txtParola.setText("");
	    	
	    	
	    	/**
	    	 * ESERCIZIO 2.2
	    	 * CREO TEXT AREA --> SERVE LA LISTA SE VOGLIO MEMORIZZARE TUTTI I TEMPI
	    	 * IN REALTA' L'ES RICHIEDEVA SOLO IL SINGOLO TEMPO DELLA PAROLA OGNI VOLTA SCRITTA  
	    	 */
	    	// RICHIESTA BASE 
	    	Long t = System.nanoTime();
	    	txtTime.setText(t.toString());
	    	
	    	// SE VOGLIO MEMORIZZARE I TEMPI DI TUTTE LE PAROLE DELL'ELENCO
	    	/*Long t = System.nanoTime();
	    	tempi.add(t.toString());
	    	String risTempi = "";
	    	for (String s: tempi) {
	    		risTempi= risTempi+s+"\n";
	    	}
	    	txtTime.setText(risTempi);
	    	
	    	*/
    	}
    	
    }
   
	@FXML
    void doReset(ActionEvent event) {
    	// TODO
    	txtResult.clear(); // cancello l'area di testo
    	elenco.reset(); // azzero l'elenco
    }

	/**
	 * ESERCIZIO 2.1
	 * CREAZIONE TASTO CANCELLA CHE RIMUOVE LA PAROLA SELEZIONATA
	 * @param event
	 */
    @FXML
    void doCancella(ActionEvent event) {
    	
    	String parolaSelez = txtResult.getSelectedText(); // prendo la parola selezionata nel testo
  //   	txtResult.clear();
    	elenco.removeParola(parolaSelez); // la rimuovo dall'elenco
    	txtResult.setText(""+elenco.toString()); // aggiorno l'elenco risultato
    	txtParola.setText("");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
