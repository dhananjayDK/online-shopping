<div class="container">
	<div class="row">
		<!--would br display sidebar  -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<!--would be display products  -->
		<div class="col-md-9">
			<!--Adding breadcrumb  -->
			<div class="row">
				<div class="col-md-12">

					<c:if test="${userClickAllProduct == true}">
					    <script>
					       window.categoryId = '';
					    </script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProduct == true}">
					     <script>
					       window.categoryId = '${category.id}';
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
			    <div class="col-md-12">
			        <table id="listTable" class="table table-striped table-borderd">
			            <thead>
			               <tr>
			                  <td></td>
			                  <td>Name</td>
			                  <td>Brand</td>
			                  <td>Price</td>
			                  <td>Quantity</td>
			                  <td></td>
			               </tr>
			            </thead>
			            <tfoot>
			               <tr>
			                  <td></td>
			                  <td>Name</td>
			                  <td>Brand</td>
			                  <td>Price</td>
			                  <td>Quantity</td>
			                  <td></td>
			               </tr>
			            </tfoot>
			        </table>
			    </div>
			</div>
		</div>
	</div>
</div>