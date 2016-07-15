package testservice;

import Dao.DaoFactory;

public class testStudent {
public static void main(String[] args) throws Exception {
	System.out.println(	DaoFactory.createPersonDao().findAllStudents().get("5555").getAttends().toString()+"=======查看学生已选课是否初始化===========");
}
}
