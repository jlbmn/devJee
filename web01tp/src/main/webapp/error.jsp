<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template alert alert-danger">
                <h2>
                    Oops! </h2>
                <div class="error-details">
                    Sorry, an error has occured, Requested page not found!
                </div>
				<div class="error-details">
					Message : <%= exception.getMessage()%>
					<h3>StackTrace : </h3>
					<%
						StringWriter sw = new StringWriter();
						PrintWriter pw = new PrintWriter(sw);
						
						exception.printStackTrace(pw);
						out.println("<pre>");
						out.println(sw);
						out.println("</pre>");
						pw.close();
						sw.close();
					%>

                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>