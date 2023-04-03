    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Borrowers List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Name</th><th>Date</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="borrower" items="${list}"> 
    <tr>
    <td>${borrower.id}</td>
    <td>${borrower.name}</td>
    <td>${borrower.date}</td>
    <td>${borrower.dept}</td>
    <td>${borrower.phone}</td>
    <td><a href="editborrower/${borrower.id}">Edit</a></td>
    <td><a href="deleteborrower/${borrower.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/><br>
    <a href="borrowerform">Add New Borrower</a>