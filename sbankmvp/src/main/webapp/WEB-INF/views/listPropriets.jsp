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

					<c:if test="${userClickAllPropriets == true}">
					
						<script>
							window.categoryId = '';
						</script>
					
						<ol class="breadcrumb">


							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>


						</ol>
					</c:if>
					
					
					<c:if test="${userClickCategoryPropriets == true}">
						<script>
							window.categoryproprietId = '${categorypropriet.id}';
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
						
							<table id="proprietListTables" 
							class="table table-striped table-borderd">
							
							
								<thead>
								
									<tr>
										<th></th>
										<th>Name</th>
										<th>Brand</th>
										<th>Price</th>
										<th>Qty. Available</th>
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