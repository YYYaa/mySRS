package testservice;

import Dao.DaoFactory;
import model.Course;
import model.Section;
import model.Student;

/**
 * @author zhang
 * @date  2016年7月3日 下午6:00:45
 * @doing TODO
 */
public class testAddsection {
public static void main(String[] args) throws Exception {
	Section section=DaoFactory.createSectioneDao().findAll().get("CMP283-1");
	Student s=DaoFactory.createPersonDao().findAllStudents().get("111-11-1111");
	System.out.println("============选课前=================");
	s.display();
	System.out.println(section.getSectionNo());
	s.addSection(section);
	System.out.println("============选课后=================");
	s.display();
}
}
