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
		<!-- Page Content -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		
		  <div class="container">
		      <div class="navbar-header">
		        <a class="navbar-brand" href="${contextRoot}/home">Home</a>
		      </div>
		  </div>
		
		</nav>
		<div class="content">
		    <div class="container">
		       <div class="row">
		         <div class="col-xs-12">
		            <div class="jumbotron">
		               <h1>${errorTitle}</h1>
		               <blockquote style="word-wrap:break-word">
		                 ${errordescription}
		               </blockquote>
		            </div>
		         </div>
		       </div>
		    </div>
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
