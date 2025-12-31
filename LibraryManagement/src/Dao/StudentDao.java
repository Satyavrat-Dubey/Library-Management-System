package Dao;

import java.util.List;

import POJO.Student;

public interface StudentDao {
	boolean addStudent(Student s);
	boolean updateStudent(Student s);
	boolean deleteStudent(int studentId);
	List <Student> getallstudent();
	List<Student> searchbyid(int studentId);

}
