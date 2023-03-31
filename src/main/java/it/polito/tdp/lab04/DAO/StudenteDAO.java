package it.polito.tdp.lab04.DAO;
import java.sql.*;
import java.util.*;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	List<Studente> listaStudenti = new LinkedList<Studente>(); //Non si tratta della soluzione migliore
	                                                           //Sarebbe più efficiente avere la lista nel model o eseguire la query nellla funzione getStudente
	public StudenteDAO() {                                     //Per database piccoli come in questo caso si può richiamare la funzione getTuttiStudneit nelle varie funzioni, se il database è invece di dimensioni maggiori è preferibile salvare la lista nel model
		this.getTuttiStudenti();
	}
	
	private void getTuttiStudenti(){
		
		final String sql = "SELECT * FROM studente";
		//List<Studente> listaStudenti = new LinkedList<Studente>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				int matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String CDS = rs.getString("CDS");
				listaStudenti.add(new Studente(matricola, cognome, nome, CDS));
			 }
			conn.close();
			//this.listaStudenti = listaStudenti;
			} catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException("Errore Db", e);
			}
	}
	
	/*
	 * Restituisce una lista di tutti gli studenti
	 */
public List<Studente> listaTuttiStudenti(){
	
	final String sql = "SELECT * FROM studente";
	//List<Studente> listaStudenti = new LinkedList<Studente>();
	
	try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			
			int matricola = rs.getInt("matricola");
			String cognome = rs.getString("cognome");
			String nome = rs.getString("nome");
			String CDS = rs.getString("CDS");
			listaStudenti.add(new Studente(matricola, cognome, nome, CDS));
		 }
		conn.close();
		return listaStudenti;
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
}

	/*
	 * Data la matricola restituisce lo studente corrispondente
	 */
	
	public Studente getStudente(int matricola) {
		Studente daRestituire = null;
		for(Studente s : listaStudenti) {
			if(s.getMatricola()==matricola) {
				daRestituire = s;
				break;
			}
		}
		return daRestituire;
	}
}
