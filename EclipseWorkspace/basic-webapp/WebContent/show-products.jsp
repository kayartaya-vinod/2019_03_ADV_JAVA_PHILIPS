<%@page import="training.entity.Product"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>List of products</h3>
<hr />

<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>	
		
			<th>Name</th>
			<th>Category</th>
			<th>Quantity per unit</th>
			<th>Unit price (USD)</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${requestScope.products}" var="p">
		<tr>
			<td>${p.productName}</td>
			<td>${p.category.categoryName}</td>
			<td>${p.quantityPerUnit}</td>
			<td>${p.unitPrice}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>



<%@ include file="footer.jsp" %>





