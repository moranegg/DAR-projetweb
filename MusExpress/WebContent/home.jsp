
<%@page import="java.util.List"%>
<%@page import="com.lmo.service.LoginService"%>
<%@page import="java.util.Date"%>
<%@page import="com.lmo.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 <title>Acceuil</title>	
	 
</head>
<body>
<center>
	 <div>
		 <h1>Result Page</h1>
			 <b>This is Sample Result Page</b><br/>
			 <%=new Date()%></br>
			 <%
				 //User user = (User) session.getAttribute("user");
			 %>		
			 <b>Welcome</b>		
			 <br/>
		 </p>

		 <table>
			 <thead>
				 <tr>
					 <th>email</th>					
				 </tr>
			 </thead>
			 <tbody>
				 <%
					 LoginService loginService = new LoginService();
					 List<User> list = loginService.getListOfUsers();
					 for (User u : list) {
				 %>
				 <tr>
 					 <td><%=u.getEmail()%></td>
				 </tr>
				 <%}%>
			 <tbody>
		 </table>		
		 <br/>
	 </div>
	</center>	
</body>
</html>