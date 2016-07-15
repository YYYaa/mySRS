package Dao;

import java.util.HashMap;

import model.Professor;
import model.Section;
import model.Student;;

public interface PersonDao {
	public HashMap<String, Professor> findAllProfessors() throws Exception;
	public HashMap<String, Student> findAllStudents() throws Exception;	
	//查询某学生已选课程。
	public HashMap<String, Section> findselectedSection(String sssn) throws Exception;
	//学生选课
	public boolean AddSection(String sssn,String courseNo,String sectionNo) throws Exception;
	public boolean AddProfessor(Professor professor) throws Exception;
	public boolean deleteProfessor(Professor professor) throws Exception;
	public boolean updateProfessor(Professor professor) throws Exception;

}
