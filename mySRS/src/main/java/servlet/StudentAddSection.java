package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EnrollmentStatus;
import model.Student;
import service.StudentService;

/**
 * Servlet implementation class StudentAddSection
 */
@WebServlet("/StudentAddSection")
public class StudentAddSection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAddSection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
//		String courseNo=request.getParameter("courseNo");
//		String sectionNo=request.getParameter("sectionNo");
		String id=request.getParameter("id");
		String courseNo=id.substring(0,1);
		String sectionNo=id.substring(4,5);
//		System.out.print(courseNo+"========================================="+sectionNo+"=========================================");
		StudentService ss=new StudentService();
		try {
//			EnrollmentStatus s=	ss.AddSection(courseNo, sectionNo, "6666");
			EnrollmentStatus s=	ss.AddSection(courseNo,sectionNo, "5555");
			out.write(s.value());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
