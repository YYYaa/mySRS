package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Dao.DaoFactory;
import Dao.TranscriptDao;
import model.Course;
import model.TranscriptEntry;
import util.DataConnection;

public class TranscriptDaoIpml implements TranscriptDao {
	Connection conn;
	@Override
	public ArrayList<TranscriptEntry> findAll() {
		// TODO Auto-generated method stub
		ArrayList<TranscriptEntry> transcriptEntries=new ArrayList<>();
		String sql = "select * from grade ;";
		try {
			conn = DataConnection.getConnection("mysql");
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			TranscriptEntry transcriptEntry=null;
			while (rs.next()) {
				String grade=rs.getString("grade");
				String sssn=rs.getString("sssn");
				String id=rs.getString("courseNO")+rs.getString("sectionNO");
			transcriptEntry=new TranscriptEntry(DaoFactory.createPersonDao().findAllStudents().get(sssn), grade, DaoFactory.createSectioneDao().findAll().get(id));
			//sec1.postGrade(s1, "C+");
			//给分
			DaoFactory.createSectioneDao().findAll().get(id).postGrade(DaoFactory.createPersonDao().findAllStudents().get(sssn), grade);
			transcriptEntries.add(transcriptEntry);
		}
		ptmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transcriptEntries;
		}

}
