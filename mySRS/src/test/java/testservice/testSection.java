package testservice;

import Dao.CourseDao;
import Dao.DaoFactory;
import Dao.SectionDao;
import DaoImpl.CourseDaoImpl;
import DaoImpl.SectionDaoImpl;
import model.Course;
import model.CourseCatalog;
import model.ScheduleOfClasses;
import service.CourseService;
import service.ScheduleOfClassesService;

public class testSection {
	public static void main(String[] args) throws Exception {
		ScheduleOfClassesService SectionService=new ScheduleOfClassesService("2", DaoFactory.createSectioneDao());
		SectionService.getScheduleOfClasses().display();
	}
}
