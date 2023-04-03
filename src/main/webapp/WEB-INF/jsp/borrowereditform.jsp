<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
		 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
<title>Library Application</title>
</head>
<body>
	<h1>Edit Borrower</h1>
       <form:form method="POST" action="/editsave">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="id" /></td>
         </tr> 
         <tr>  
          <td>Name : </td> 
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>  
          <td>Date :</td>  
          <td><form:input path="date" type="date" /></td>
         </tr> 
         
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form> 
	
	<img src="${pageContext.request.contextPath}/resources/img/klein.jpg" width="100px">
	
</body>
</html>
