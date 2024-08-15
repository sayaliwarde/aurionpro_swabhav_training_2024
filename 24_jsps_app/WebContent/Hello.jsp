<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.Date" import= "javax.servlet.http.HttpServletRequest" %>
<%@ include file = "insert.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<b>This is JSP demo</b>

<br>

<%-- Scripting Elements --%>
<%
java.util.Date date = new java.util.Date();
out.print(date);
%>

<br>
<%= new java.util.Date() %>

<br>
<%! String message="Welcome";
%>
<%= message %>

</body>
</html>