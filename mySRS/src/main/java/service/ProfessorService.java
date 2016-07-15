package service;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Dao.CourseDao;
import Dao.DaoFactory;
import Dao.PersonDao;
import model.Course;
import model.Professor;

public class ProfessorService {

	private static HashMap<String , Professor> professors;
	private PersonDao personDao = null;
	
	public ProfessorService (PersonDao dao) throws Exception{
		this.personDao = dao;
		professors= dao.findAllProfessors();
	}
	public  HashMap<String , Professor> getProfessors() {
		return professors;
	}
	
	public void displayAll() {
		for (Professor professor : professors.values()) {
			professor.display();
			System.out.println();
		}	
	}
	
	public JSONObject WriteJson() throws JSONException {
		JSONObject json=new JSONObject();  
	    JSONArray jsonMembers = new JSONArray();  
	    for (Professor p : professors.values()) {
			jsonMembers.put(p.writeJson());
		}
	    json.put("rows", jsonMembers);
		return json;
	}
	
	
	
	public boolean addProfessor(Professor Professor) throws Exception{
		   return DaoFactory.createPersonDao().AddProfessor(Professor);
		}
	public boolean deleteProfessor(Professor Professor) throws Exception{
		   return DaoFactory.createPersonDao().deleteProfessor(Professor);
		}
	public boolean updateProfessor(Professor Professor) throws Exception{
		   return DaoFactory.createPersonDao().updateProfessor(Professor);
		}
	
	
	
	
}
