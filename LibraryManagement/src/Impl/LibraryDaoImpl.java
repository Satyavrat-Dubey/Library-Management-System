package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.LibraryDao;
import POJO.Book;
import Utility.DBUtility;

public class LibraryDaoImpl implements LibraryDao {
	
		Book b=null;

	@Override
	public boolean addbook(Book b) {
		// TODO Auto-generated method stub
		try {
			
			Connection con=DBUtility.getConnection();
			String sql="insert into book(title,author,availableCopies) values (?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
//			ps.setInt(1, b.getBookId());
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
		    ps.setInt(3,b.getAvailableCopies());
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
	public boolean updatebook(Book b) {
		// TODO Auto-generated method stub
		try {
		Connection con=DBUtility.getConnection();
		String sql="update book set title=?,author=?,availableCopies=? where bookId=?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, b.getTitle());
		ps.setString(2, b.getAuthor());
	    ps.setInt(3,b.getAvailableCopies());
	    ps.setInt(4, b.getBookId());
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
	public Book searchbook(int bookId) {
		// TODO Auto-generated method stub
		Connection con=DBUtility.getConnection();
		String sql="select * from book where bookId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, bookId);
			ResultSet rs=ps.executeQuery();
			  if (rs.next()) {
		            b = new Book(
		                    rs.getInt("bookId"),
		                    rs.getString("title"),
		                    rs.getString("author"),
		                    rs.getInt("availableCopies")
		            );
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	@Override
	public List<Book> getallBook() {
		// TODO Auto-generated method stub
		

		    List<Book> list = new ArrayList<>();

		    try (Connection con = DBUtility.getConnection();
		         PreparedStatement ps =
		             con.prepareStatement("SELECT * FROM book");
		         ResultSet rs = ps.executeQuery()) {

		        while (rs.next()) {
		            Book b = new Book(
		                    rs.getInt("bookId"),
		                    rs.getString("title"),
		                    rs.getString("author"),
		                    rs.getInt("availableCopies")
		            );
		            list.add(b);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return list;
		}
	
	

	@Override
	public boolean issuebook(int bookId, int studentId) {
		// TODO Auto-generated method stub
		try (Connection con = DBUtility.getConnection()) {

	        // 1. Check available copies
	        PreparedStatement ps1 =
	            con.prepareStatement("SELECT availableCopies FROM book WHERE bookId=?");
	        ps1.setInt(1, bookId);
	        ResultSet rs = ps1.executeQuery();

	        if (rs.next()) {
	            int copies = rs.getInt("availableCopies");

	            if (copies > 0) {

	                // 2. Update book copies
	                PreparedStatement ps2 =
	                    con.prepareStatement(
	                        "UPDATE book SET availableCopies=availableCopies-1 WHERE bookId=?");
	                ps2.setInt(1, bookId);
	                ps2.executeUpdate();

	                // 3. Update student table
	                PreparedStatement ps3 =
	                    con.prepareStatement(
	                        "UPDATE student SET issuedBookId=? WHERE studentId=?");
	                ps3.setInt(1, bookId);
	                ps3.setInt(2, studentId);
	               int updated= ps3.executeUpdate();
	                if (updated == 0) {
	                    System.out.println("Student ID not found");
	                    return false;
	                }

	                return true;
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}

	@Override
	public boolean returnbook(int bookId, int studentId) {
		// TODO Auto-generated method stub
		try (Connection con = DBUtility.getConnection()) {

	        // 1. Check student issued book
	        PreparedStatement ps1 =
	            con.prepareStatement(
	                "SELECT issuedBookId FROM student WHERE studentId=?");
	        ps1.setInt(1, studentId);
	        ResultSet rs = ps1.executeQuery();

	        if (rs.next() && rs.getInt("issuedBookId") == bookId) {

	            // 2. Increase book copies
	            PreparedStatement ps2 =
	                con.prepareStatement(
	                    "UPDATE book SET availableCopies=availableCopies+1 WHERE bookId=?");
	            ps2.setInt(1, bookId);
	            ps2.executeUpdate();

	            // 3. Remove book from student
	            PreparedStatement ps3 =
	                con.prepareStatement(
	                    "UPDATE student SET issuedBookId=0 WHERE studentId=?");
	            ps3.setInt(1, studentId);
	            ps3.executeUpdate();

	            return true;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}

	

	@Override
	public List<Book> searchBookByname(String bookname) {
		// TODO Auto-generated method stub
		 List<Book> list = new ArrayList<>();

		    try (Connection con = DBUtility.getConnection();
		         PreparedStatement ps =
		             con.prepareStatement(
		                 "SELECT * FROM book WHERE title LIKE ?")) {

		        ps.setString(1, "%" + bookname + "%");
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            Book b = new Book(
		                    rs.getInt("bookId"),
		                    rs.getString("title"),
		                    rs.getString("author"),
		                    rs.getInt("availableCopies")
		            );
		            list.add(b);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return list;
		}



	}



