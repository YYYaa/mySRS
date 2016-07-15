package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.Connection;

import Dao.DaoFactory;
import Dao.PersonDao;
import model.Course;
import model.Professor;
import model.Section;
import model.Student;
import servlet.SelectedSectionList;
import util.DataConnection;

public class PersonDaoImpl implements PersonDao {	

	@Override
	public HashMap<String, Professor> findAllProfessors() throws Exception {
		//连接数据库初始化对象
		HashMap<String, Professor> professors = new HashMap<String, Professor>();
		String sql = "select * from professor where 1=1 ;";
		Connection conn=(Connection) DataConnection.getConnection("mysql");
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("pssn"));
			Professor p=new Professor(rs.getString("professorName"),rs.getString("pssn"),rs.getString("title"),rs.getString("department"));
			professors.put(p.getSsn(), p);
		}
		return professors;
	}

		
		
		
		
		
		/*//		测试初始化数据
		HashMap<String, Professor> professors = new HashMap<String, Professor>();
		Professor p1, p2, p3;
		p1 = new Professor("Jacquie Barker", "123-45-6789", "Adjunct Professor", "Information Technology");
		professors.put(p1.getSsn(), p1);
		p2 = new Professor("John Smith", "567-81-2345", "Full Professor", "Chemistry");
		professors.put(p2.getSsn(), p2);
		p3 = new Professor("Snidely Whiplash", "987-65-4321", "Full Professor", "Physical Education");
		professors.put(p3.getSsn(), p3);	
		//�˴�Ӧ�ö�ȡ�������̵Ŀγ�
		return professors;
		}*/

	@Override
	public HashMap<String, Student> findAllStudents() throws Exception {
		// TODO Auto-generated method stub
		//连接数据库初始化对象  将学生的已选课程也初始化进去。之后才可以调用model中方法。
		HashMap<String, Student> students = new HashMap<String, Student>();
		HashMap<String, Section> sections = new HashMap<String, Section>();
		String sql = "select * from student where 1=1 ;";
		Connection conn=(Connection) DataConnection.getConnection("mysql");
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("sssn"));
			Student s=new Student(rs.getString("studentName"),rs.getString("sssn"),rs.getString("major"),rs.getString("degree"));
			sections=findselectedSection(rs.getString("sssn"));
			 for(Section section :sections.values()){
				 s.addSection(section);
			 }
		students.put(s.getSsn(), s);
		}
		return students;
			
		
		/*	测试初始化数据
		HashMap<String, Student> students = new HashMap<String, Student>();
		Student s1,s2,s3;
		s1 = new Student("Joe Blow", "111-11-1111", "Math", "M.S.");
		students.put(s1.getSsn(), s1);
		s2 = new Student("Fred Schnurd", "222-22-2222", 
				 "Information Technology", "Ph. D.");
		students.put(s1.getSsn(), s1);
		s3 = new Student("Mary Smith", "333-33-3333", "Physics", "B.S.");
		students.put(s1.getSsn(), s1);
		return students;
*/	}






	@Override
	public HashMap<String, Section> findselectedSection(String sssn) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Section> sections = new HashMap<String, Section>();
		String sql = "select * from student_section where 1=1 and sssn="+sssn+";";
		Connection conn=(Connection) DataConnection.getConnection("mysql");
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
//			System.out.println(rs.getString("sectionid"));
			Section section=DaoFactory.createSectioneDao().findAll().get(rs.getString("courseNo")+"-"+rs.getString("sectionNo"));
			sections.put(rs.getString("courseNo")+"-"+rs.getString("sectionNo"), section);
		}
		return sections;
	}

	@Override
	public boolean AddSection(String sssn, String courseNo, String sectionNo) throws Exception {
		// TODO Auto-generated method stub
		boolean a=false;
		String sql = "insert into student_section (sssn,sectionNo,courseNo) values (?,?,?) ";
		Connection conn=(Connection) DataConnection.getConnection("mysql");
		System.out.println(conn);
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, sssn);
		ptmt.setString(2, sectionNo);
		ptmt.setString(3, courseNo);
//		System.out.println(ptmt.executeUpdate()+"==========================");
		if (ptmt.executeUpdate()>0) {
		a=true;	
		}
		ptmt.close();
		return a;	
	}






	@Override
	public boolean AddProfessor(Professor professor) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}






	@Override
	public boolean deleteProfessor(Professor professor) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}






	@Override
	public boolean updateProfessor(Professor professor) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
