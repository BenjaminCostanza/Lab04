package it.polito.tdp.lab04.model;

import java.util.Objects;

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

	@Override
	public String toString() {
		return "matricola=" + matricola + ", cognome=" + cognome + ", nome=" + nome + ", CDS=" + CDS + "";
	}

	@Override
	public int hashCode() {
		return Objects.hash(CDS, cognome, matricola, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		return Objects.equals(CDS, other.CDS) && Objects.equals(cognome, other.cognome) && matricola == other.matricola
				&& Objects.equals(nome, other.nome);
	}
	
	

}
