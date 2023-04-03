    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Shelf List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>ISBN</th><th>Title</th><th>Year</th></tr>
    <c:forEach var="book" items="${list}"> 
    <tr>
    <td>${book.id}</td>
    <td>${book.isbn}</td>
    <td>${book.title}</td>
    <td>${book.year}</td>
    </tr>
    </c:forEach>
    </table>
    <br/><br>