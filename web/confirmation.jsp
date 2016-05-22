<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 17.05.2016
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
  out.println("<h3><center>Your LoginID,Login and Password</h3>");
  out.println("<form name=\"f1\" action=\"http://localhost:8080/index.jsp\" action=\"GET\" >");
  out.println("<br><br><br>Enter you Login  <input type=\"text\" name=\"login\"> ");
  out.println("<br>Enter you LoginID  <input type=\"text\" name=\"loginid\"> ");
  out.println("<br>Enter you Password  <input type=\"password\" name=\"passwd\"> ");
  out.println("<br><input type=\"submit\" Value=\"Confirm\"> ");
  out.println("</form>");
%>
</body>
</html>
