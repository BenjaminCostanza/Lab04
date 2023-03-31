package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

//import it.polito.tdp.lab04.DAO.ConnectDB;
import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {
	
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				//System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				corsi.add(new Corso(codins, numeroCrediti, nome, periodoDidattico));
			}

			conn.close();
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	/*
	 * Dato uno studente restituisce la lista dei corsi cui è iscritto
	 */
	public List<Corso> getCorsiStudente(Studente s) {
		int matricola = s.getMatricola();
		final String sql = "SELECT * "
				+ "FROM corso c, iscrizione i "
				+ "WHERE c.codins=i.codins AND i.matricola=? ";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");
				
				corsi.add(new Corso(codins, numeroCrediti, nome, periodoDidattico));
			}

			conn.close();
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public Corso getCorsoDaCodice(String codins) {
		List<Corso> listaCorsi = getTuttiICorsi();
		Corso daRestituire = null;
		for(Corso c : listaCorsi) {
			if(c.getCodins().compareTo(codins)==0) {
				daRestituire=c;
				break;
			}
		}
		return daRestituire;	
	}
	
	
	/*
	 * Dato il nome di un corso ottengo il corso 
	 */
	public Corso getCorsoDaNome(String nomeCorso) {
		List<Corso> listaCorsi = getTuttiICorsi();
		Corso daRestituire = null;
		for(Corso c : listaCorsi) {
			if(c.getNome().compareTo(nomeCorso)==0) {
				daRestituire=c;
				break;
			}
		}
		return daRestituire;	
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		String codice = corso.getCodins();
		final String sql = "SELECT s.matricola, s.cognome, s.nome, s.CDS "
				+ "FROM studente s, iscrizione i "
				+ "WHERE s.matricola=i.matricola AND i.codins = ? ";
		
		List<Studente> studentiIscrittiCorso= new LinkedList<Studente>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, codice);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				int matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String CDS = rs.getString("CDS");
				studentiIscrittiCorso.add(new Studente(matricola, cognome, nome, CDS));
			}
			
			st.close();
			rs.close();
			conn.close();
			return studentiIscrittiCorso;
					
			}
			catch(SQLException e) {
				System.out.println("Errore in CorsoDAO");
				e.printStackTrace();
				return null;
			}
	}

	/*
	 * Dato uno studente e un corso restituisce true se lo studente è iscritto al corso, false altrimenti
	 */
	public boolean studenteIscrittoAlCorso(Studente s, Corso c) {
		List<Studente> studentiIscrittiCorso = new LinkedList<Studente>();
		studentiIscrittiCorso = getStudentiIscrittiAlCorso(c);
		if(studentiIscrittiCorso.contains(s)) {
			return true;
		}
		else {
			return false;
		 }
		}
	
	
	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}

}
