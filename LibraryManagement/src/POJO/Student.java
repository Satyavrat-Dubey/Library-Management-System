package POJO;

public class Student {
	private int studentId;
	private String name;
	private int issuedBookId;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int studentId, String name, int issuedBookId) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.issuedBookId = issuedBookId;
	}
	public Student(String name, int issuedBookId) {
		super();
		this.name = name;
		this.issuedBookId = issuedBookId;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIssuedBookId() {
		return issuedBookId;
	}
	public void setIssuedBookId(int issuedBookId) {
		this.issuedBookId = issuedBookId;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", issuedBookId=" + issuedBookId + "]";
	}
	
}
