package service;

import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.sun.accessibility.internal.resources.accessibility;

import Dao.DaoFactory;
import model.Course;
import model.EnrollmentStatus;
import model.Professor;
import model.Section;
import model.Student;

public class StudentService {
	
	
//查询已选课程	
	public JSONObject findselectedSection(String sssn) throws Exception{
		JSONObject json=new JSONObject();  
	    JSONArray jsonMembers = new JSONArray();
		HashMap<String , Section> sections=new HashMap<String , Section>(); 
			sections=DaoFactory.createPersonDao().findselectedSection(sssn);
			for(Section s:sections.values()){
				jsonMembers.put(s.WriteJson());
			}
		    json.put("rows", jsonMembers);
			return json;
	}
	
//选课	
		public EnrollmentStatus AddSection(String courseNo,String sectionNo,String sssn) throws Exception{
			Section section=DaoFactory.createSectioneDao().findAll().get(courseNo+"-"+sectionNo);
			Student student=DaoFactory.createPersonDao().findAllStudents().get(sssn);
			//判断是否已经选
			boolean a =false;
			if(!student.isEnrolledIn(section)){
			a=DaoFactory.createPersonDao().AddSection(sssn, courseNo, sectionNo);
				/*//判断是否满足先修条件	
			EnrollmentStatus a=section.enroll(student);
			if(a.equals(EnrollmentStatus.success)){
				//调用Dao持久化
				student.addSection(section);	
			}*/	
			
			}
			
			/*//先修课
			List<Course> precourses=DaoFactory.createCourseDao().findpreRequisites(section.getRepresentedCourse().getCourseNo());
			boolean a=false;
			for(int i=0;i<precourses.size();i++){
				if(precourses.get(i).getCourseNo()==section.getRepresentedCourse().getCourseNo()){
				a=true; //代表已经	
				}
			} */

			
			//			return a;
		if(a){
			return 	EnrollmentStatus.success;
		}else{
			return 	EnrollmentStatus.prevEnroll;
		}
		
					
		}	
	
		
		
}
