package it.polito.tdp.corsi.model;

import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDao;
import it.polito.tdp.corsi.db.StudenteDAO;

public class Model {
	
	private CorsoDao corsoDao;
	private StudenteDAO studenteDAO;

	
	public Model() {
		this.corsoDao = new CorsoDao();
		this.studenteDAO= new StudenteDAO();
	}


	public List<Corso> getCorsiByPeriodo (int periodo){
		return this.corsoDao.getCorsiByPeriodo(periodo);
		
	}
	
	public Map<Corso,Integer> getIscritti (int periodo){
		return this.corsoDao.getIscritti(periodo);
		
	}
	
	public List<Studente> getStudentibyCorso(String codins){
		return this.studenteDAO.getStudentibyCorso(codins);
		
	}

	
}
