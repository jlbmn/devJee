<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UseBean Example</title>
</head>
<body>

<jsp:useBean id="personne" class="fr.formation.inti.entity.Employee"></jsp:useBean>
<h2>Hello : </h2>

<jsp:setProperty property="firstName" name="personne" value="Jo"/>
<jsp:getProperty property="firstName" name="personne" />


</body>
</html>