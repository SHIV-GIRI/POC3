package servelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextsDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext ctx = null;

	public void init(ServletConfig config) throws ServletException {
		ctx = config.getServletContext();
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String driver = ctx.getInitParameter("driver");
		String url = ctx.getInitParameter("url");
		String user = ctx.getInitParameter("user");
		String password = ctx.getInitParameter("password");
		pw.println("<h1 style=background-color:orange;color:silver;padding:20px; text-align:center;>Driver Name"+ driver+"<br></h1>");
		pw.println("<h2 style=background-color:white:;color:silver;padding:20px; text-align:center;>url =" + url+"<br></h1>");
		pw.println("<h1 style=background-color:green;color:silver;padding:20px; text-align:center;>user =" + user+"<br></h1>");
		pw.println("<h1 style=background-color:gold ;color:silver ;padding:20px; text-align:center;>password =" + password+"<br></h1>");
		

	}

}
