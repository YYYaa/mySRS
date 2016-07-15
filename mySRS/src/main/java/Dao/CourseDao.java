package Dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import model.Course;
import model.CourseCatalog;

public interface CourseDao {
	public HashMap<String, Course> findAll() throws Exception;
	public Course findByNO(String CourseNo) throws Exception;
	public List<Course> findpreRequisites(String CourseNo) throws Exception;
	public boolean addCourse(Course Course) throws Exception;
	public boolean deleteCourse(String  CourseNo) throws Exception;
	public boolean updateCourse(Course course) throws Exception;
}
