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

    }

    @FXML
    void DoCercaIscritti(ActionEvent event) {
    	

    }

    @FXML
    void DoIscrivi(ActionEvent event) {

    }

    @FXML
    void DoReset(ActionEvent event) {

    }

    @FXML
    void DoVai(ActionEvent event) {
    	int matricola = Integer.parseInt(TextFieldMatricola.getText());
    	model.getStudente(matricola);
    	TextFieldNome.setText(model.getStudente(matricola).getNome());
    	TextFiedlCognome.setText(model.getStudente(matricola).getCognome());

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
    }

}
