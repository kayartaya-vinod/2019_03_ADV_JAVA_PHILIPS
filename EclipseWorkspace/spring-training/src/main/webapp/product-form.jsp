<%@ include file="header.jsp" %>

<h3>Search products by price range</h3>

<form method="GET" action="./view-products-by-price-range" class="form">
	
	<div class="form-group">
		<label for="t1">Enter minimum price: </label>
		<input class="form-control" name="min_price" id="t1">
	</div>

	<div class="form-group">
		<label for="t2">Enter maximum price: </label>
		<input class="form-control" name="max_price" id="t2">
	</div>
	
	<button class="btn btn-primary">Search...</button>

</form>

<%@ include file="footer.jsp" %>