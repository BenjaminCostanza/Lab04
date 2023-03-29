package it.polito.tdp.lab04.model;

public class Studente {
	
	int matricola;
	String cognome;
	String nome;
	String CDS;
	
	public Studente(int matricola, String cognome, String nome, String cDS) {
		super();
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		CDS = cDS;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCDS(String cDS) {
		CDS = cDS;
	}

	public int getMatricola() {
		return matricola;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getCDS() {
		return CDS;
	}
	
	
	
	

}
