package DaoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Dao.CourseDao;
import model.Course;
import util.DBUtil;
import util.DataConnection;


public class CourseDaoImpl implements CourseDao {

	//	测试初始化数据
		//	=========================
	/*@Override
	public HashMap<String,Course> findAll() {
		
		HashMap<String,Course> courses = new HashMap<String, Course>();
		Course c1,c2,c3,c4,c5;
		c1 = new Course("CMP101", "Beginning Computer Technology", 3.0);
		c2 = new Course("OBJ101", "Object Methods for Software Development", 3.0);
		c3 = new Course("CMP283", "Higher Level Languages (Java)", 3.0);
		c4 = new Course("CMP999", "Living Brain Computers", 3.0);
		c5 = new Course("ART101", "Beginning Basketweaving", 3.0);
		//修课顺序
		// Establish some prerequisites (c1 => c2 => c3 => c4).
		c2.addPrerequisite(c1);
		c3.addPrerequisite(c2);
		c4.addPrerequisite(c3);		
		courses.put(c1.getCourseNo(), c1);
		courses.put(c2.getCourseNo(), c2);
		courses.put(c3.getCourseNo(), c3);
		courses.put(c4.getCourseNo(), c4);
		courses.put(c5.getCourseNo(), c5);
		return courses;
	}*/

/*	@Override
	public Course findByNO(String CourseNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findpreRequisites(String CourseNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	
		
	
	//从数据库中找出并初始化数据
	//	=========================
	public HashMap<String,Course> findAll() throws Exception {
		HashMap<String,Course> courses = new HashMap<String, Course>();
		String sql = "select * from Course where 1=1 ;";
		Connection conn=DataConnection.getConnection("mysql");
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		Course course=null;
		while (rs.next()) {
			System.out.println(rs.getString("CourseNo"));
			course=new Course(rs.getString("CourseNo"),rs.getString("CourseName"),Double.parseDouble(rs.getString("credits")));
			ArrayList<Course> prerequisites=(ArrayList<Course>) findpreRequisites(rs.getString("CourseNo"));
			System.out.println(prerequisites.size()+"gagagagga");
			for( int i=0;i<prerequisites.size();i++){
				Course preCourse=(Course)prerequisites.get(i);
				course.addPrerequisite(preCourse);
			}
			courses.put(course.getCourseNo(), course);
		}
		conn.close();
		return courses;	
	}

	

	@Override
	public Course findByNO(String CourseNo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from Course where CourseNo="+CourseNo+" ;";
		Connection conn=DataConnection.getConnection("mysql");
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		Course course=null;
		while (rs.next()) {
			course=new Course(rs.getString("CourseNo"),rs.getString("CourseName"),Double.parseDouble(rs.getString("credits")));
		}
		conn.close();
		return course;
		
	}

	@Override
	public List<Course> findpreRequisites(String CourseNo) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Course> courses=new ArrayList<>();
		String sql = "select preCourseNo from PreRequisites where courseNo='"+CourseNo+"';";
		Connection conn;
		try {
			conn = DataConnection.getConnection("mysql");
			PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		Course course=null;
		while (rs.next()) {
			System.out.println(rs.getString("preCourseNo"));
			course=findByNO(rs.getString("preCourseNo"));
			courses.add(course);
		}
		ptmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return courses;
	}



	@Override
	public boolean addCourse(Course Course) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean deleteCourse(String CourseNo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean updateCourse(Course course) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
	
	
	
	
	
	/*@Override
	public Course findByNO(String CourseNo) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from Course where CourseNo="+CourseNo+" ;";
//		ptmt = Conn.prepareStatement(sql);
		Statement stat = Conn.createStatement();
		System.out.println("========1==========="+ptmt);
		ResultSet rs = stat.executeQuery(sql);
		ptmt.close();
		Course course=null;
		while (rs.next()) {
			course=new Course(rs.getString("CourseNo"),rs.getString("CourseName"),Double.parseDouble(rs.getString(2)));
		}
		return course;
	}

	@Override
	public ArrayList<Course> findpreRequisites(String CourseNo) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Course> courses=new ArrayList<>();
		String sql = "select preCourseNo from PreRequisites where courseNo='"+CourseNo+"';";
		ptmt = Conn.prepareStatement(sql);
		System.out.println("========2==========="+ptmt);
		ResultSet rs = ptmt.executeQuery();
		Course course=null;
		while (rs.next()) {
			System.out.println(rs.getString("preCourseNo"));
			course=findByNO(rs.getString("preCourseNo"));
			courses.add(course);
		}
		Conn.commit();
		ptmt.close();
		return courses;
		}*/
}
