<div class="container">

	<!-- Breadcrumb -->
	<div class="row">
		
		<div class="col-xs-12">
		
			
			<ol class="breadcrumb">
			
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>
			
			</ol>
		
		
		</div>
	
	
	</div>
	


	<div class="row">
	
		<!-- Display the product image -->
		<div class="col-xs-12 col-sm-4">
		
			<div class="thumbnail">
							
				<img src="${images}/${product.code}.jpg" class="img img-responsive"/>
						
			</div>
		
		</div>
		
		<input id = "price" type = "hidden" value = "${product.unitPrice}" />
		
		<script>function myFunction() {
			var price = parseFloat(document.getElementById("price").value);
			var salary = parseFloat(document.getElementById("salario").value) * 0.4;
			var participation = parseFloat(document.getElementById("participacao").value);
			var paymentPeriod = parseFloat(document.getElementById("meses").value);
			
			var validation = (price - participation) / paymentPeriod;
			
			if(validation > salary){
// 				
				 document.getElementById("demo").innerHTML = 'Lamentamos, nao podemos lhe financiar o leasing';
				 bootbox.alert({
						size: 'medium',
						title: 'Opps!',
						message: 'Infelizmente nao lhe podemos conceder o emprestimo!'
					});
			}
			else {
// 				
				 document.getElementById("demo").innerHTML = 'Parabens, O leasing lhe foi esta disponivel';

			}
		  document.getElementById("demo").innerHTML = x;
		}
		</script>

		<!-- Display the product description -->	
		<div class="col-xs-12 col-sm-8">
		
			<strong>Marca<h2>${product.name}</h2></strong>
			<hr/>
			
			<strong>Modelo<p>${product.description}</p></strong>
			<hr/>
			<strong><p>${product.motor}</p></strong>
			<hr/>
			<h2>Price: <strong > Mt ${product.unitPrice} </strong></h2>
			<hr/>
			<input id="price" type="hidden" value="${product.unitPrice} ">
			
			
			
			<c:choose>
			
				
				<c:when test="${product.quantity <1}">
				
					<h6>Qty. Available: <span style="color:red">Stock nao existente!</span></h6>
					
				</c:when>
				
				<c:otherwise>				
					
					<h6>Qty. Disponivel: ${product.quantity}</h6>
						
				</c:otherwise>
			
			</c:choose>
			
			
			<security:authorize access="isAnonymous() or hasAuthority('USER')">	

			<c:choose>
				
				<c:when test="${product.quantity < 1}">
				
				
					<a href="javascript:void(0)" class="btn btn-success disabled"><strike>
					<span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</strike></a>
				</c:when>
				<c:otherwise>				
				
				
				
				
						
				</c:otherwise>
			
			</c:choose>
			</security:authorize>
			
			
<!-- 			<security:authorize access="hasAuthority('ADMIN')"> -->
<%-- 				<a href="${contextRoot}/manage/${product.id}/product" class="btn btn-success"> --%>
<!-- 				<span class="glyphicon glyphicon-pencil"></span> Edit</a> -->
<!-- 			</security:authorize>	 -->
						
			

			<a href="${contextRoot}/show/all/products" class="btn btn-warning">
				Continue Shopping</a>
					
		</div>

	
	</div>

</div>
<c:set var="str" value="${product.category.name}" />
		<jsp:useBean id="str" type="java.lang.String" />
		<c:if test='<%=str.equalsIgnoreCase("Leasing")%>'>
		<div class="row">
		
		 <div class="form-group col-md-2">
		<label for="salario" class="col-sm-2 control-label">Salario</label>
		
			<input type="text"  id="salario" name="salario" class="form-control">
		</div> <div class="form-group col-md-2">
			<label for="participacao" class="col-sm-2 control-label">Participacao</label>
			<input type="text" id="participacao"  name="participacao" class="form-control">
			</div> <div class="form-group col-md-2">
			<label for="meses" class="col-sm-2 control-label">Meses</label>
			<input type="text" id="meses" name="meses" class="form-control" ></div>
			<br> <button onclick="myFunction()" class="btn btn-danger">Verificar</button>
			<div style="margin-left: 10%">
			<h2 id="demo" style="color: red"></h2></div>
			</div>
		</c:if>
		
		
