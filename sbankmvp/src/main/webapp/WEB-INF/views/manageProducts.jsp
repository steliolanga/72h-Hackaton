<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="container">
 <div class="row">
  
  <c:if test="${not empty message}">    
   <div class="col-xs-12">   
  <div class="alert alert-success alert-dismissible">   
   <button type="button" class="close" data-dismiss="alert">&times;</button>   
   ${message}  
  </div>      
   </div> 
 </c:if>
 
  <div >
   <div >
    <div >
     <h4>Cadastrar carros</h4>
    </div>
    <div class="panel-body">
     <!--  FORM ELEMENTS -->
     <sf:form class="form-horizontal" modelAttribute="product"
      action="${contextRoot}/manage/products"
      method="POST"
      enctype="multipart/form-data"
     >
      
      <div class="form-group">
       <label class="control-label col-md-4" for="name">Marca: </label>
       <div class="col-md-8">
        <sf:input type="text" path="name" id="name" placeholder="Escreva a Marca" class="form-control"/>
  <sf:errors path="name" cssClass="help-block" element="em"/>
       </div>
      </div>
      
      <div class="form-group">
       <label class="control-label col-md-4" for="brand">modelo: </label>
       <div class="col-md-8">
        <sf:input type="text" path="brand" id="brand" placeholder="Escreva o modelo" class="form-control"/>
  <sf:errors path="brand" cssClass="help-block" element="em"/>
       </div>
      </div> 

      <div class="form-group">
       <label class="control-label col-md-4" for="description">Ano: </label>
       <div class="col-md-8">
        <sf:textarea path="description" id="description" rows="4" placeholder="Escreva o ano" class="form-control" />
        <sf:errors path="description" cssClass="help-block" element="em"/>
       </div>
      </div> 

<div class="form-group">
       <label class="control-label col-md-4" for="description">Cilindragem: </label>
       <div class="col-md-8">
        <sf:textarea path="motor" id="motor" rows="4" placeholder="Cilindragem do motor" class="form-control" />
        <sf:errors path="motor" cssClass="help-block" element="em"/>
       </div>
      </div> 

      <div class="form-group">
       <label class="control-label col-md-4" for="unitPrice">Preco: </label>
       <div class="col-md-8">
        <sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Escreva o preco;" class="form-control"/>
        <sf:errors path="unitPrice" cssClass="help-block" element="em"/>
       </div>
      </div> 
      
      <div class="form-group">
       <label class="control-label col-md-4" for="quantity">Quantidade: </label>
       <div class="col-md-8">
        <sf:input type="number" path="quantity" id="quantity" placeholder="Quantity Available" class="form-control"/>
       </div>
      </div> 
 
  <!-- File element for image upload -->
      <div class="form-group">
       <label class="control-label col-md-4" for="file">Selecione a imagem: </label>
       <div class="col-md-8">
        <sf:input type="file" path="file" id="file" class="form-control"/>
        <sf:errors path="file" cssClass="help-block" element="em"/>
       </div>
      </div> 

      <div class="form-group">
       <label class="control-label col-md-4" for="categoryId">Escreva a Categoria: </label>
       <div class="col-md-8">
        <sf:select class="form-control" id="categoryId" path="category.id" 
         items="${categories}"
         itemLabel="name"
         itemValue="id"
        />
        <c:if test="${product.id == 0}">
        	<div class="text-right">
	        	<br/>
	        	<button type="button" data-toggle="modal" 
	        	data-target="#myCategoryModal" 
	        	class="btn btn-warning btn-xs">Categoria</button>
        	</div>
        </c:if>
        
       </div>
      </div> 
           
      <div class="form-group">
       <div class="col-md-offset-4 col-md-8">
        <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary"/>
        <!-- Hidden fields for products -->
        <sf:hidden path="id"/>
        <sf:hidden path="code"/>
        <sf:hidden path="supplierId"/>
        <sf:hidden path="active"/>
        <sf:hidden path="purchases"/>
        <sf:hidden path="views"/>
       </div>
      </div>
       
     </sf:form>
    </div>
   </div>
  </div>
 </div>


 <div class="row">
  <div class="col-xs-12">
   <h3>Carros Disponiveis</h3>
   <hr/>
  </div>
  
  <div class="col-xs-12">
  	<div class="container-fluid">
  		
  		<div class="table-responsive">
		     <!-- Products table for Admin -->
		    <table id="adminProductsTable" class="table table-striped table-bordered">
		     <thead>
		      <tr>
		       <th>Id</th>
		       <th>&#160;</th>
		       <th>Marca</th>
		       <th>Modelo</th>
		       <th>Ano</th>
		       		       <th>Motor</th>
		       
		       <th>Preco</th>
		       <th>Active</th>
		       <th>Edit</th>        
		      </tr>
		     </thead>
		      
		    </table> 		
  		
  		</div>
  	
  	</div>
 
  
  </div>
 </div>

 <div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
 	<div class="modal-dialog" role="document">
 		<div class="modal-content">
 			<!-- Modal Header -->
 			<div class="modal-header">
 				<button type="button" class="close" data-dismiss="modal">
 					<span>&times;</span>
 				</button>
 				<h4 class="modal-title">Adicionar nova Categoria</h4>
 			</div>
 			<div class="modal-body">
 				<!-- Category Form -->
 				<sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category"
 					method="POST" class="form-horizontal">
					 					
 					<div class="form-group"> 						
 						<label for="category_name" class="control-label col-md-4">Nome da Categoria</label>
 						<div class="col-md-8"> 		
 							<sf:input type="text" path="name" id="category_name" class="form-control"/>  						
 						</div> 						 					
 					</div>

 					<div class="form-group"> 						
 						<label for="category_description" class="control-label col-md-4">Descricao da Categoria</label>
 						<div class="col-md-8"> 		
 							<sf:textarea cols="" rows="5" path="description" id="category_description" class="form-control"/>  						
 						</div> 						 					
 					</div>
 				
  					<div class="form-group"> 						 						
 						<div class="col-md-offset-4 col-md-8"> 		
 							<input type="submit" value="Add Category" class="btn btn-primary"/>	  						
 						</div> 						 					
 					</div>				
 				
 				</sf:form>
 			</div>
 		</div> 		
 	</div>
 
 </div>


</div>