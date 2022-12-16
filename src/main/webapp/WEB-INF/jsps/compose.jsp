 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ include file="menu.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compose</title>
</head>
<body>
<h2>welcome</h2>
<div>
${msg}
</div>
<form action="sendEmail" method="post">
<table>
<tr>
<td> To<input type="text" name="to" value="${email}"/></td>
</tr>
<tr>
<td> Subject<input type="text" name="subject"/></td>
</tr>
<tr>
<td><textarea name="message" rows="4" cols="50"></textarea></td>
</tr>
</table>
<input type="submit" value="send"/>
</form>
</body>
</html>