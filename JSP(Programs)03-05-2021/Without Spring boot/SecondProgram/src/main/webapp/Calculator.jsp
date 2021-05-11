
<%
int fno = Integer.parseInt(request.getParameter("fno"));
int sno = Integer.parseInt(request.getParameter("sno"));

String value = request.getParameter("bl");
if (value.equalsIgnoreCase("ADD")) {
	out.println("sum = " + (fno + sno));
} else if (value.equalsIgnoreCase("SUB")) {
	out.println("sub = " + (fno - sno));
} else if (value.equalsIgnoreCase("MUL")) {
	out.println("mul = " + (fno * sno));
} else {
	out.println("div = " + (fno / sno));
}
%>