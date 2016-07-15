package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Dao.CourseDao;
import Dao.DaoFactory;
import DaoImpl.CourseDaoImpl;
import model.CourseCatalog;
import service.CourseService;

/**
 * Servlet implementation class LoadAllCourse
 */
@WebServlet("/LoadAllCourse")
public class LoadAllCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadAllCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		//找到所有的课程
				response.setContentType("text/x-json;charset=utf-8");
				CourseDao CourseDao=DaoFactory.createCourseDao();
				DaoFactory.createCourseDao();
				CourseService courseService = null;
				try {
					courseService = new CourseService(CourseDao);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				CourseCatalog CourseCatalog=courseService.getCourseCatalog();
				CourseCatalog.display();
				PrintWriter out=response.getWriter();
				try {
					out.write(CourseCatalog.WriteJson().toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out.close();
	}
				
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
