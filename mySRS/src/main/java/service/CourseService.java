package service;

import java.sql.SQLException;

import Dao.CourseDao;
import Dao.DaoFactory;
import model.Course;
import model.CourseCatalog;

public class CourseService {
	
	private static CourseCatalog  courses;
	private CourseDao courseDao = null;
	
	//实例化的同时就给使得course对象初始化
	public CourseService(CourseDao dao) throws Exception{
		this.courseDao = dao;
			courses = new CourseCatalog(dao.findAll());
	}

	
	public CourseCatalog getCourseCatalog() {
		return courses;
	}
	
	public Course findCourse(String courseNo){
	   return courses.findCourse(courseNo);
	}
	
	public boolean addCourse(Course course) throws Exception{
		   return DaoFactory.createCourseDao().addCourse(course);
		}
	public boolean deleteCourse(Course course) throws Exception{
		   return DaoFactory.createCourseDao().deleteCourse(course.getCourseNo());
		}
	public boolean updateCourse(Course course) throws Exception{
		   return DaoFactory.createCourseDao().updateCourse(course);
		}
}
