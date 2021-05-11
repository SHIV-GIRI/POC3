<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%!Connection con = null;

	public void jspInit() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ojasdb", "root", "root");
			System.out.println("Conncted Successfully " + con);
		} catch (Exception e) {
			System.out.println(e);
		}
	}%>
<%
try {
	String name = request.getParameter("name");
	String upass = request.getParameter("upass");
	PreparedStatement pst = con.prepareStatement("insert into user(username,password)values(?,?)");
	pst.setString(1, name);
	pst.setString(2, upass);
	int num = pst.executeUpdate();
	if (num > 0) {
		out.println("<h1 style=color:blue> Insertd Successfully</h1>");

	} else {
		out.println("<h1 style=color:blue> Try again later</h1>");
	}
} catch (Exception e) {
	System.out.println(e);
}
%>