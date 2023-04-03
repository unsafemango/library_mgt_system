    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Staff List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Name</th><th>Position</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="staff" items="${list}"> 
    <tr>
    <td>${staff.id}</td>
    <td>${staff.name}</td>
    <td>${staff.position}</td>
    <td><a href="editstaff/${staff.id}">Edit</a></td>
    <td><a href="deletestaff/${staff.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/><br>
    <a href="staffform">Add New Staff</a>