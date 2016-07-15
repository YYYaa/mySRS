package Dao;

import java.util.HashMap;
import java.util.List;

import model.Section;

public interface SectionDao {
	public HashMap<String,Section>  findAll() throws Exception;
	public HashMap<String,Section> findBySemester(String semester) throws Exception;
}
