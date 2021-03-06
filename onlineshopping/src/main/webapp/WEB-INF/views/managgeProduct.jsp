<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row">

		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&time;</button>
					${message}
				</div>
			</div>
		</c:if>
		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product management</h4>

				</div>
				<div class="panel-body">
					<!--From Elements  -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/management/controller/handle/addProduct"
						method="POST" enctype="multipart/form-data">

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="emclass" element="em" />
								<!-- <em style="color:red;">Please Enter Product Name</em>     -->
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" cssClass="emclass" element="em" />
								<!-- <em style="color:red;">Please Enter Brand Name</em>     -->
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="description">Enter
								Description:</label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description"
									class="form-control"></sf:textarea>
								<sf:errors path="description" cssClass="emclass" element="em" />
								<!-- <em style="color:red;">Please Enter Product Description</em>     -->
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="unitprice">Enter
								Unit Price:</label>
							<div class="col-md-8">
								<sf:input type="number" path="unit_price" id="unitprice"
									placeholder="Unit Price in" class="form-control" />
								<sf:errors path="unit_price" cssClass="emclass" element="em" />
								<!-- <em style="color:red;">Please Enter Unit Price</em> -->
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity
								Available:</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Available Contity" class="form-control" />
								<sf:errors path="quantity" cssClass="emclass" element="em" />
								<!-- <em style="color:red;">Please Enter Available Quantity</em> -->
							</div>

						</div>
						<!-- File Element for image Upload  -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select
								File:</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" cssClass="emclass" element="em" />
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="category_id">Select
								Category:</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="category_id"
									path="category_id" style="height:40px;">
									<c:forEach items="${categories}" var="category_id">
										<option value="${category_id.id}">${category_id.name}</option>
									</c:forEach>
								</sf:select>

								<!--   <em style="color:red;">Please Enter Available Quantity</em>  -->
								<c:if test="${product.id==0}">
									<div class="text-right">
										<br />
										<button type="button" data-toggle="modal"
											data-target="#myCategoryModal" class="btn btn-warning btn-xs">Add
											Category</button>
											</div>
								</c:if>
							</div>
						</div>
				
				<br>
				<div class="form-group">
					<div class="col-md-offset-4 col-md-8">
						<input type="submit" name="submit" id="submit" Value="Submit"
							placeholder="Select Product" class="btn btn-primary" />
					</div>
				</div>
				<sf:hidden path="id" />
				<sf:hidden path="code" />
				<sf:hidden path="supplier_id" />
				<sf:hidden path="purchases" />
				<sf:hidden path="views" />
				<sf:hidden path="is_active" />
			</div>
			
			</sf:form>
            </div>
		</div>

	
<!-- Showing Products Table -->

    <div class="col-md-12">
	<table id="adminProductTable"
		class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Id</th>
				<th>&#160;</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Quantity</th>
				<th>Unit Price</th>
				<th>Active</th>
				<th>Edit</th>
			</tr>
		</thead>

		<%--   ddummy table body <tr>
                 <td>1</td>
                 <td>
                   <img class="adminProductTableImg" alt="Image Not Loaded" src="${contextRoot}/resources/images/PRDIPHONE123.jpg">
                 </td>
                 <td>iPhone6s</td>
                 <td>5</td>
                 <td>&#8377; 3000/-</td>
                 <td>
                    <!-- Toggle Switch -->
                    <label class="switch">
                        <input type="checkbox" checked="checked" value="4"/>
                        <span class="slider round"></span>
                    </label>
                 </td>
                 <td>
                    <a href="${contextRoot}/manage/1/product" class="btn btn-warning">
                       <span class="glyphicon glyphicon-pencil"></span>
                    </a>
                 </td>
              </tr>
              <tr>
                 <td>1</td>
                 <td>
                   <img class="adminProductTableImg" alt="Image Not Loaded" src="${contextRoot}/resources/images/PRDIPHONE123.jpg">
                 </td>
                 <td>iPhone6s</td>
                 <td>5</td>
                 <td>&#8377; 3000/-</td>
                 <td>
                    <!-- Toggle Switch -->
                    <label class="switch">
                        <input type="checkbox"  value="4"/>
                        <span class="slider round"></span>
                    </label>
                 </td>
                 <td>
                    <a href="${contextRoot}/manage/1/product" class="btn btn-warning">
                       <span class="glyphicon glyphicon-pencil"></span>
                    </a>
                 </td>
              </tr> --%>

		<tfoot>
			<tr>
				<th>Id</th>
				<th>&#160</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Quantity</th>
				<th>Unit Price</th>
				<th>Active</th>
				<th>Edit</th>
			</tr>

		</tfoot>
	</table>
</div>

</div>
 <div class="row">
    <div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
        <div class="modal-dialog" role="document">
           <div class="modal-content">
           <!-- Modal header -->
             <div class="model-header">
             
                <button type="button" class="close" style="padding-top:35px;" data-dismiss="modal">
                   <span>&times;</span>
                </button>
                <h4 class="modal-title" style="padding-top:35px;">Add New Category</h4>
             </div>
           <!-- Modal body -->
                <!--Category Form  -->
                <div class="modal-body">
                <sf:form id="categoryForm" modalAttribute="category" action="${contextRoot}/management/controller/handle/category"
                   method="POST" class="form-horizontal">
                    <div class="form-group">
                      <label for="category_name" class="col-md-4">Category Name</label>
                      <div class="col-md-8">
                        <input type="text" name="name" class="form-control" />
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="category_description" class="col-md-4">Description</label>
                      <div class="col-md-8">
                        <textarea rows="2"  name="description" placeholder="Enter Description" class="form-control"></textarea>
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <div class="col-md-offset-4 col-md-8 ">
                        <input type="submit" value="Add Category" class="btn btn-primary"/>
                      </div>
                    </div>
                    
                </sf:form>
                </div>
           </div>
        </div>
    </div>
 </div>
</div>
