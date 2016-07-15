package testservice;

import Dao.PersonDao;
import DaoImpl.PersonDaoImpl;
import service.ProfessorService;

public class testprofessor {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  PersonDao dao=new PersonDaoImpl();
	  ProfessorService ps;
	try {
		ps = new ProfessorService(dao);
		  ps.displayAll();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 		
	
	}
}
