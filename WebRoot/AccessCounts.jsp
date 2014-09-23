<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<html>
  <head>
  		<title>
  				JSP Declarations
  		</title>
  </head>
  <body>
  		<h1>JSP Declarations</h1>
  		<%! int accessCount =0; %>
  		<% int accessCount2 =0; %>
  		<h2>Acesses to page since server reboot:
  		<%= ++accessCount %>
  		<br>
  		<%= ++accessCount2 %>
  		</h2>
  </body>
</html>
