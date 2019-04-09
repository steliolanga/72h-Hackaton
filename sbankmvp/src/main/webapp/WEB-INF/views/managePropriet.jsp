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
 
  <div class="col-md-offset-2 col-md-8">
   <div class="panel panel-primary">
    <div class="panel-heading">
     <h4>Propriet Management</h4>
    </div>
    <div class="panel-body">
     <!--  FORM ELEMENTS -->
     <sf:form class="form-horizontal" modelAttribute="propriet"
      action="${contextRoot}/manage/propriets"
      method="POST"
      enctype="multipart/form-data"
     >
      
      <div class="form-group">
       <label class="control-label col-md-4" for="neightbourhood">Enter Product Name: </label>
       <div class="col-md-8">
        <sf:input type="text" path="neightbourhood" id="neightbourhood" placeholder="Bairro" class="form-control"/>
  <sf:errors path="neightbourhood" cssClass="help-block" element="em"/>
       </div>
      </div>
      
      <div class="form-group">
       <label class="control-label col-md-4" for="roofMaterial">Enter Brand Name: </label>
       <div class="col-md-8">
        <sf:input type="text" path="roofMaterial" id="roofMaterial" placeholder="Tipo de teto" class="form-control"/>
  <sf:errors path="roofMaterial" cssClass="help-block" element="em"/>
       </div>
      </div> 

      
  <!-- File element for image upload -->
      <div class="form-group">
       <label class="control-label col-md-4" for="file">Select an Image: </label>
       <div class="col-md-8">
        <sf:input type="file" path="file" id="file" class="form-control"/>
        <sf:errors path="file" cssClass="help-block" element="em"/>
       </div>
      </div> 

      <div class="form-group"> 						 						
 						<div class="col-md-offset-4 col-md-8"> 		
        <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary"/>
 						</div> 						 					
 					</div>	
           
     
       
     </sf:form>
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
 				<h4 class="modal-title">Add New Category</h4>
 			</div>
 			<div class="modal-body">
 				<!-- Category Form -->
 				<sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category"
 					method="POST" class="form-horizontal">
					 					
 					<div class="form-group"> 						
 						<label for="category_name" class="control-label col-md-4">Category Name</label>
 						<div class="col-md-8"> 		
 							<sf:input type="text" path="name" id="category_name" class="form-control"/>  						
 						</div> 						 					
 					</div>

 					<div class="form-group"> 						
 						<label for="category_description" class="control-label col-md-4">Category Description</label>
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