<h4 style="color: orange"><%="Welcome  to ojas"%></h4>
<hr />
<%!java.text.SimpleDateFormat st = new java.text.SimpleDateFormat("yyyy-mm-dd");
	java.util.Date d = new java.util.Date();%>

Date =
<%=st.format(d)%>

<%
for (int i = 1; i <= 10; i++) {
%>

<%=i%><br>
<%
}
%>
