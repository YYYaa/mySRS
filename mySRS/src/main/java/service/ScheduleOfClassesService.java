package service;

import Dao.SectionDao;
import model.ScheduleOfClasses;
import model.Section;

public class ScheduleOfClassesService {
	private static ScheduleOfClasses sc;
	private SectionDao sectionDao = null;
    
    public ScheduleOfClasses getScheduleOfClasses() {
		return sc;
	}    
    public ScheduleOfClassesService(String semester, SectionDao dao) throws Exception{
    	sc = new ScheduleOfClasses(semester, dao.findBySemester(semester));
    }
    

}
