<div class="container">

	<div class="row">


		<!-- Would be to display sidebar -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- to display the actual products -->
		<div class="col-md-9">

			<!-- Added breadcrumb component -->
			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true}">
					
						<script>
							window.category_id = '';
						</script>
					
						<ol class="breadcrumb">


							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>


						</ol>
					</c:if>
					
					
					<c:if test="${userClickCategoryProducts == true}">
						<script>
							window.category_id = '${category.id}';
						</script>
					
						<ol class="breadcrumb">


							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>


						</ol>
					</c:if>
					

				</div>


			</div>

			
			<div class="row">
			
				<div class="col-xs-12">
				
				
					<div class="container-fluid">
					
						<div class="table-responsive">
						
							<table id="productsListTables" 
							class="table table-striped table-borderd">
							
							
								<thead>
								
									<tr>
										<th></th>
										<th>Marca</th>
										<th>Modelo</th>
										<th>preco</th>
										<th>Quantidade disponivel</th>
										<th></th>
									
									</tr>
								
								</thead>
							
		
													
						
						</div>
					
					</div>
					

				
				</div>
			
			</div>


		</div>



	</div>






</div>