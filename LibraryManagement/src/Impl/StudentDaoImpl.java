package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.StudentDao;
import POJO.Student;
import Utility.DBUtility;

public class StudentDaoImpl implements StudentDao{

	
	@Override
	public boolean addStudent(Student s) {
		// TODO Auto-generated method stub
		Connection con=DBUtility.getConnection();
		String sql="insert into student (name,issuedBookId) values (?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setInt(2, s.getIssuedBookId());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateStudent(Student s) {
		// TODO Auto-generated method stub
		Connection con=DBUtility.getConnection();
		String sql="update student set name=?,issuedBookId=? where studentId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setInt(2, s.getIssuedBookId());
			ps.setInt(3, s.getStudentId());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		Connection con=DBUtility.getConnection();
		String sql="delete from student where studentId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, studentId);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Student> getallstudent() {
		// TODO Auto-generated method stub
		Connection con=DBUtility.getConnection();
		List<Student> list=new ArrayList<Student>();
		String sql="select * from student";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Student s=new Student();
				s.setStudentId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setIssuedBookId(rs.getInt(3));
				list.add(s);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Student> searchbyid(int studentId) {
		// TODO Auto-generated method stub
		Connection con=DBUtility.getConnection();
		String sql="select * from student where studentId=?";
		List <Student> list=new ArrayList<Student>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, studentId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Student s=new Student();
				s.setStudentId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setIssuedBookId(rs.getInt(3));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
