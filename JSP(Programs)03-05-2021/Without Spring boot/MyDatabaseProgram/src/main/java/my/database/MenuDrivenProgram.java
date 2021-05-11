package my.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class Student1 {
	int sno;
	String sname;
	int marks;

	public Student1() {
		System.out.println("Defult Constuctor");
	}

	public Student1(int sno, String sname, int marks) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.marks = marks;
	}

}

// Operations class 
class Operations {
	Connection getConnect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/records", "root", "root");
			System.out.println("Connected" + con);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}

		return con;
	} // getConnect method closing

// menu Display Method
	void menu() {
		String Refobj = "Menu Driven Application\n";
		Refobj += "1.Add Student\n";
		Refobj += "2.Delete Student\n";
		Refobj += "3.Update Student\n";
		Refobj += "4.List Students\n";
		Refobj += "5.Exit \n";
		Refobj += "select any option...?";
		System.out.println(Refobj);
	} // menu Display Method close

// addStudent method
	boolean addStudent() {
		boolean b = false;
		try {
			Connection con = getConnect();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the sno,sname,marks");
			int sno = sc.nextInt();
			String sname = sc.next();
			int marks = sc.nextInt();

			PreparedStatement pst = con.prepareStatement("insert into Student1 values(?,?,?)");
			pst.setInt(1, sno);
			pst.setString(2, sname);
			pst.setInt(3, marks);
			int result = pst.executeUpdate();
			if (result > 0) {
				b = true;
			}
			if (b) {
				System.out.println("Record Inserted Successfuly" + result);
			} else {
				System.out.println("Record is Not Inserted Please Check onces again" + result);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	} // addStudent method closing

	boolean DeleteStudent() {
		boolean b = false;
		try {
			Connection con = getConnect();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the sno");
			int sno = sc.nextInt();

			PreparedStatement pst = con.prepareStatement("delete from Student1 where sno = ?");
			pst.setInt(1, sno);
			int result = pst.executeUpdate();
			if (result > 0) {
				b = true;
			}
			if (b) {
				System.out.println("Delete  Successfuly" + result);
			} else {
				System.out.println("Record is Not Deleted Please Check onces again" + result);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	} // DeleteStudent method closing
		// UpdateStudent method

	boolean UpdateStudent() {
		boolean b = false;
		try {
			Connection con = getConnect();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter sname and marks");
			String sname = sc.next();
			int marks = sc.nextInt();
			int sno = sc.nextInt();

			PreparedStatement pst = con.prepareStatement("update Student1 set sname=?" + ",Marks =? where sno=?");
			pst.setString(1, sname);
			pst.setInt(2, marks);
			pst.setInt(3, sno);
			int result = pst.executeUpdate();
			if (result > 0) {
				b = true;
			}
			if (b) {
				System.out.println("Update  Successfuly" + result);
			} else {
				System.out.println("Record is Not Update Please Check onces again" + result);
			}
			pst.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}// UpdateStudent method closing

	// DeleteStudent method

	// ListStudent method
	boolean ListStudent() {
		boolean b = false;
		try {
			Connection con = getConnect();

			PreparedStatement pst = con.prepareStatement("select * from Student1");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int sno = rs.getInt(1);
				String sname = rs.getString(2);
				int marks = rs.getInt(3);
				System.out.println("sno = " + sno + " sname = " + sname + " marks = " + marks + "");
			}

			rs.close();
			pst.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}// ListStudent method
}// Operations class closing

public class MenuDrivenProgram {
	// main method start
	public static void main(String args[]) {
		try {
			Operations op = new Operations();
			while (true) {
				Scanner sc = new Scanner(System.in);
				op.menu();

				System.out.println("Enter Your Choice :");
				int ch = sc.nextInt();
				switch (ch) {
				case 1:
					op.addStudent();
					break;
				case 2:
					op.DeleteStudent();
					break;
				case 3:
					op.UpdateStudent();
					break;
				case 4:
					op.ListStudent();
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Please Enter valid Options");
				}// switch closing

			} // while closing
		} catch (Exception e) {
			System.out.println(e);
		} // catch block closing
	}// main method closing
}// MenuDrivenProgram Class closing
