<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EL: Expression Language Example</title>
</head>
<body>

<form method="POST">
<label>First Name:</label><br>
<input type="text" name="firstName"><br>
<label>Last Name:</label><br>
<input type="text" name="lastName"><br>
<input type="submit" name="submit" value="Submit">
</form>

<!--
<jsp:useBean id="emp" class="fr.formation.inti.entity.Employee"></jsp:useBean>

<jsp:setProperty property="firstName" name="emp" value="Jo"/>
<jsp:setProperty property="lastName" name="emp" value="L"/>

<h1>Hello : ${emp.firstName } ${emp.lastName }</h1>
  -->

<!--  on récupère firstName & lastName dans les attributs de request -->
<h1>Hello : ${firstName } ${lastName }</h1>
<!--  on récupère directement l'objet employee en tant qu'attribut de request -->
<h1>Hello : ${employee.firstName } ${employee.lastName}</h1>

</body>
</html>