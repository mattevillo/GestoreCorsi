package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.model.Studente;


public class StudenteDAO {
	
	
	public List<Studente> getStudentibyCorso(String codins) {
		
		String sql= "SELECT s.matricola, s.cognome, s.nome, s.cds "
				+ "FROM studente s, iscrizione i "
				+ "WHERE s. matricola = i.matricola and i.codins = ?";
		
		List<Studente> result = new ArrayList<Studente>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, codins);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Studente s = new Studente(rs.getInt("matricola"),rs.getString("cognome"),rs.getString("nome"),rs.getString("CDS"));
				result.add(s);
			}
			
			st.close();
			rs.close();
			conn.close();
			
			return result;
			
		} catch (SQLException e) {
			System.out.println("Errore nel DAO");
			e.printStackTrace();
			return null;	
		}
	}

}
