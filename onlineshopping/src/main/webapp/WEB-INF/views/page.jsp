<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="popper" value="/resources/popper" />
<c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online-Shopping-${title}</title>
    <script>
    window.menu='${title}';
    window.contextRoot='${contextRoot}';
    </script>
    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme readable -->
     <link href="${css}/bootswatch-theme.css" rel="stylesheet">
    
     <!--data table bootstrap  -->
   <%--  <link src="${css}/dataTables.bootstrap.css" rel="stylesheet"> --%>
   
    <!-- Custom styles for this template -->
    
    <link href="${css}/shop-homepage.css" rel="stylesheet">
    
		
		  
  </head>  

<body style="margin-top: -60px;">
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>
		<!-- Page Content -->
		<div class="content">
			<!-- load when clicked on Home tab -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- load when clicked on About tab -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>
             
			<!-- load when clicked on Home page -->
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<!-- load when clicked on Home page -->
			<c:if test="${userClickAllProduct == true or userClickCategoryProduct==true}">
				<%@include file="listProduct.jsp"%>
			</c:if>
			
			<!-- load when Single image is clicked -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
			<!-- load when manage product is clicked -->
			<c:if test="${userClickManageProducts == true}">
			    
				<%@include file="managgeProduct.jsp"%>
			</c:if>
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		<!-- Bootstrap core JavaScript -->
        <script src="${js}/jquery-3.1.1.js"></script>
		
		<script src="${popper}/popper.min.js"></script>
		<script src="${js}/bootstrap.min.js"></script>
		<!--  data table plugin-->
        <script src="${js}/jquery.dataTables.js"></script>
        
        		<!--  data table bootstrap plugin-->
       <%--  <script src="${js}/dataTables.bootstrap.js"></script> --%>
        
        
        <!-- self coded jQuery  -->
		<script src="${js}/myapp.js"></script>
		
	    </div>
</body>

</html>
