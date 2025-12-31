package Test;

import java.util.List;
import java.util.Scanner;

import Impl.LibraryDaoImpl;
import POJO.Book;

public class LibraryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int bookId;
		 String title;
		 String author;
		 int availableCopies;
		Scanner sc=new Scanner (System.in);
		LibraryDaoImpl bimpl=new LibraryDaoImpl();
		
		System.out.println(" 1.AddBook\n 2.UpdateBook\n 3.SearchBook\n 4.Total Books list\n 5.IssueBook\n 6.ReturnBook\n 7.Search Book by name");
		System.out.println("Enter your choice");
		int choice=sc.nextInt();
		switch (choice) {
			case 1:
			{
				 System.out.println("Enter Book Id:");
				     bookId = sc.nextInt();
				    sc.nextLine();   

				    System.out.println("Enter Book Title:");
				     title = sc.nextLine();

				    System.out.println("Enter Author Name:");
				     author = sc.nextLine();

				    System.out.println("Enter Available Copies:");
				     availableCopies = sc.nextInt();

				   Book b=new Book(bookId,title,author,availableCopies);
				   boolean flag = bimpl.addbook(b);
		            if (flag) {
		               System.out.println("Successfully Inserted");
		            } else {
		               System.out.println("Fail to insert");
		            }
		            
		}
			break;
			case 2:
			{
				System.out.println("Enter the id which you have to Update");
				bookId=sc.nextInt();
			    sc.nextLine();   

			    System.out.println("Enter Book Title:");
			     title = sc.nextLine();

			    System.out.println("Enter Author Name:");
			     author = sc.nextLine();

			    System.out.println("Enter Available Copies:");
			     availableCopies = sc.nextInt();

			   Book b=new Book(bookId,title,author,availableCopies);
			   boolean flag = bimpl.updatebook(b);
	            if (flag) {
	               System.out.println("Successfully Updated");
	            } else {
	               System.out.println("Fail to Updated");
	            }
				
			}
			break;
			case 3:
			{
				System.out.println("Enter the id which you want to view");
				bookId=sc.nextInt();
				sc.nextLine();
			    Book b = bimpl.searchbook(bookId);
			    if (b != null) {
			        System.out.println(b);
			    } else {
			        System.out.println("Book not found");
			    }
			}
			break;
			case 4:
			{
				List<Book> list = bimpl.getallBook();

	            if (list.isEmpty()) {
	                System.out.println("No books available in library");
	            } else {
	                System.out.println("----- Book List -----");
	                for (Book b : list) {
	                    System.out.println(b);
	                }
	            }
	        }
	        break;
			
	case 5:   // Issue Book
	{
	    System.out.println("Enter Student ID:");
	    int sid = sc.nextInt();

	    System.out.println("Enter Book ID:");
	    int bid = sc.nextInt();

	    boolean issued = bimpl.issuebook(bid, sid);

	    if (issued) {
	        System.out.println("Book Issued Successfully");
	    } else {
	        System.out.println("Book Issue Failed");
	    }
	}
	break;
	case 6:   // Return Book
	{
	    System.out.println("Enter Student ID:");
	    int sid = sc.nextInt();

	    System.out.println("Enter Book ID:");
	    int bid = sc.nextInt();

	    boolean returned = bimpl.returnbook(bid, sid);

	    if (returned) {
	        System.out.println("Book Returned Successfully");
	    } else {
	        System.out.println("Return Failed");
	    }
	}
	break;
	case 7:
	{
		sc.nextLine(); // buffer clear
	    System.out.println("Enter Book Name:");
	    String name = sc.nextLine();

	    List<Book> list = bimpl.searchBookByname(name);

	    if (list.isEmpty()) {
	        System.out.println("No books found");
	    } else {
	        for (Book b : list) {
	            System.out.println(b);
	        }
	    }
	}
	break;
	}
			
			
			}
	
		}


	


