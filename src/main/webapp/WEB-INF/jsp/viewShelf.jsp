    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Shelf List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Book Count</th><th>Floor</th></tr>
    <c:forEach var="shelf" items="${list}"> 
    <tr>
    <td>${shelf.id}</td>
    <td>${shelf.bookCount}</td>
    <td>${shelf.floor}</td>
    </tr>
    </c:forEach>
    </table>
    <br/><br>