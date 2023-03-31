package it.polito.tdp.lab04;

import java.net.URL;

import java.util.*;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonCercaCorsi;

    @FXML
    private Button ButtonCercaIscritti;

    @FXML
    private Button ButtonIscrivi;

    @FXML
    private Button ButtonReset;

    @FXML
    private Button ButtonVai;

    @FXML
    private ComboBox<String> TendinaCorsi;

    @FXML
    private TextArea TextAreaRisultati;

    @FXML
    private TextField TextFiedlCognome;

    @FXML
    private TextField TextFieldMatricola;

    @FXML
    private TextField TextFieldNome;

    @FXML
    void DoCercaCorsi(ActionEvent event) {
    	TextAreaRisultati.clear();
    	int matricola=0;
    	try {
    	matricola = Integer.parseInt(TextFieldMatricola.getText());
    	}catch(NumberFormatException e) {
    		TextAreaRisultati.setText("La matricola è composta da soli interi");
    		return;
    	}
    	List<Corso> listaCorsiStudente = new LinkedList<Corso>();
    	Studente s = this.model.getStudente(matricola);
    	if(this.model.listaTuttiStudenti().contains(s)==false) { //Se lo studente non è presente notifico con messaggio di errore
    		TextAreaRisultati.setText("La matricola inserita non è presente");
    		return;
    	}
    	else {
    		listaCorsiStudente = this.model.getCorsiStudente(s);
    		if(listaCorsiStudente.size()==0) {
    			TextAreaRisultati.setText("Lo studente non è iscritto a nessun corso");
    		}
    		else {
    		for(Corso co : listaCorsiStudente) {
    			TextAreaRisultati.appendText("" +co + "\n");
    		 }
    		}
    	}
    }

    @FXML
    void DoCercaIscritti(ActionEvent event) {
    	TextAreaRisultati.clear();
    	TextFieldNome.clear();
    	TextFiedlCognome.clear();
    	List<Studente> listaStudentiIscritti = new LinkedList<Studente>();
    	List<Studente> listaStudentiIscrittiCorso = new LinkedList<Studente>();
    	String s = this.TendinaCorsi.getValue();
    	if(s==null) {
    		TextAreaRisultati.setText("Selezionare un corso!");
    	}
    	if(s.compareTo(" ")==0) { //Caso in cui non si seleziona nessun corso in particolare
    		for(Corso c : this.model.getTuttiICorsi())
    		listaStudentiIscrittiCorso = this.model.getIscrittiCorso(c);  //Prendo studenti iscritti a ogni singolo corso
    		listaStudentiIscritti.addAll(listaStudentiIscrittiCorso); //Restituisco quindi tutti gli studenti
    	}
    	else { //Normale corso selezionato
    		Corso c = this.model.getCorsoDaNome(s);
    		listaStudentiIscritti= this.model.getIscrittiCorso(c);
    	}
    	if(listaStudentiIscritti.size()==0) {
    		TextAreaRisultati.setText("Il corso non ha iscritti");
    	}
    	else {
    	for(Studente st : listaStudentiIscritti) {
    		TextAreaRisultati.appendText("" +st + "\n");
    	 }
    	}

    }

    @FXML
    void DoIscrivi(ActionEvent event) {

    }

    @FXML
    void DoReset(ActionEvent event) {
      TextAreaRisultati.clear();
      TextFiedlCognome.clear();
      TextFieldNome.clear();
      TextFieldMatricola.clear();
    }

    @FXML
    void DoVai(ActionEvent event) {
    	TextFieldNome.clear();
    	TextFiedlCognome.clear();
    	int matricola = 0;
    	try {
    	matricola = Integer.parseInt(TextFieldMatricola.getText());
    	}catch(NumberFormatException e) {
    		TextAreaRisultati.setText("La matricola è composta da soli interi");
    	}
    	Studente s = model.getStudente(matricola);
    	TextFieldNome.setText(s.getNome());
    	TextFiedlCognome.setText(s.getCognome());
    	if(TendinaCorsi.getValue()!=null) {
    	Corso c = this.model.getCorsoDaNome(TendinaCorsi.getValue());
        if(c != null) {
    	 if(this.model.studenteIscrittoCorso(s, c)==true) {
    		TextAreaRisultati.setText("Lo studente è già iscritto al corso");
    	 }
    	 else {
    		 TextAreaRisultati.setText("Lo studente non è iscritto al corso");
    	 }
        }
    	}
    }

    public void setModel(Model model){
    	this.model = model;
    }
    
    @FXML
    void initialize() {
        assert ButtonCercaCorsi != null : "fx:id=\"ButtonCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert ButtonCercaIscritti != null : "fx:id=\"ButtonCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert ButtonIscrivi != null : "fx:id=\"ButtonIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert ButtonReset != null : "fx:id=\"ButtonReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert ButtonVai != null : "fx:id=\"ButtonVai\" was not injected: check your FXML file 'Scene.fxml'.";
        assert TendinaCorsi != null : "fx:id=\"TendinaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert TextAreaRisultati != null : "fx:id=\"TextAreaRisultati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert TextFiedlCognome != null : "fx:id=\"TextFiedlCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert TextFieldMatricola != null : "fx:id=\"TextFieldMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert TextFieldNome != null : "fx:id=\"TextFieldNome\" was not injected: check your FXML file 'Scene.fxml'.";
        model = new Model();
        for(Corso c : model.getTuttiICorsi()) {
        	TendinaCorsi.getItems().add(c.getNome());
        }
        TendinaCorsi.getItems().add(" ");
        TextFieldNome.setEditable(false);
        TextFiedlCognome.setEditable(false);
        TextAreaRisultati.setEditable(false);
    }

}
