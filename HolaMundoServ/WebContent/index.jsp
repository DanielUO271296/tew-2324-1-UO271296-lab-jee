<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Hola Mundo!!</title>
</head>
<body>
<%
if (request.getParameter("NombreUsuario") != null) {
%>
<h1>Hola <%=request.getParameter("NombreUsuario")%>!</h1>
<br>
<%
}
%>
<h1>Bienvenido a mi primera página web!</h1>
<! -- http://localhost:8080/HolaMundoServ/index.jsp -->
<! -- http://localhost:8080/HolaMundoServ/index.jsp?NombreUsuario=Fulanito -->

</body>
</html>
