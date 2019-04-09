



<div class="list-group">


	<h5>Carros</h5>
	<c:forEach items="${categories}" var="category">
	
		<a href="${contextRoot}/show/category/${category.id}/products"
		 class="list-group-item" id="a_${category.name}">${category.name}</a>
	
	</c:forEach>
	
	<h5>Casas</h5>
	<c:forEach items="${categorypropriets}" var="categorypropriet">
	
		<a href="${contextRoot}/show/category/${categorypropriet.id}/propriets"
		 class="list-group-item" id="a_${categorypropriet.name}">${categorypropriet.name}</a>
	
	</c:forEach>

	 
</div>