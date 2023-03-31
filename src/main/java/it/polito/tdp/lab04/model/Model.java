package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	private CorsoDAO corsoDAO; //All'interno del modello richiamo il CorsoDAO che parla direttamente col database
	private StudenteDAO studenteDAO;
	
	public Model() {
		this.corsoDAO = new CorsoDAO();
		this.studenteDAO = new StudenteDAO();
	}
	
	public List<Corso> getTuttiICorsi(){ //Creo all'interno del model un metodo praticamente identico a quello presente in corsoDAO
		return this.corsoDAO.getTuttiICorsi();
	}
	
	public List<Corso> getCorsiStudente(Studente s){
		return this.corsoDAO.getCorsiStudente(s);
	}
	
	public Studente getStudente(int matricola) {
		return this.studenteDAO.getStudente(matricola);
	}
	
	
	public List<Studente> listaTuttiStudenti(){
		return this.studenteDAO.listaTuttiStudenti();
	}
	
	
	public List<Studente> getIscrittiCorso(Corso corso){
		return this.corsoDAO.getStudentiIscrittiAlCorso(corso);
	}
	
	public Corso getCorsoDaNome(String nomeCorso){
		return this.corsoDAO.getCorsoDaNome(nomeCorso);
	}
	
	public boolean studenteIscrittoCorso(Studente s,Corso c) {
		return this.corsoDAO.studenteIscrittoAlCorso(s, c);
	}
}
