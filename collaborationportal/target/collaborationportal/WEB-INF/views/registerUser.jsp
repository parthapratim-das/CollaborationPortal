<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
  <head>
    <title>My Web Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 
   <link href="/twitter-bootstrap/twitter-bootstrap-v2/docs/assets/css/bootstrap2.2.css" rel="stylesheet">  
	<link rel="stylesheet" href="demo.css">
	<link rel="stylesheet" href="footer-distributed.css">
	
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  </head>
  <body>
 
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">

                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>

            </button>
            <a class="navbar-brand" href="home">
                <img src="https://www.news-pr.in/wp-content/uploads/diginxt_48232.jpg" height="70" width="250" alt="">
            </a>
        </div>
    </div>
</nav>
<!-- ======== Header part ends here ========= -->

<!-- ======== Form body ========== -->
<br><br><br>
<center><h1>
    Register Yourself
</h1></center>
 
<form:form action="newuserdetails" modelAttribute="niituser" enctype="multipart/form-data" method="POST">
<table class="table">
    <c:if test="${!empty name}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8" />
           <!--  <form:hidden path="id" /> -->
        </td> 
    </tr>
    </c:if> 
    <tr>
        <td>
            <form:label path="firstname">First Name
                 <spring:message text="First Name"/> 
            </form:label>
        </td>
        <td>
            <form:input path="firstname" />
        </td> 
        
    </tr>
     <tr>
        <td>
            <form:label path="lastname">Product Name
                 <spring:message text="Last Name"/> 
            </form:label>
        </td>
        <td>
            <form:input path="lastname" />
        </td> 
       
    </tr>
    <tr>
        <td>
            <form:label path="addressline1">
                <spring:message text="Address Line 1"/>
            </form:label>
        </td>
        <td>
            <form:input path="addressline1" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="addressline2">
                <spring:message text="Address Line 2"/>
            </form:label>
        </td>
        <td>
            <form:input path="addressline2" />
        </td>
    </tr>
    <tr>
    <tr>
        <td>
            <form:label path="contact">
                <spring:message text="contact"/>
            </form:label>
        </td>
        <td>
            <form:input path="contact" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="uid">
                <spring:message text="Employee Id"/>
            </form:label>
        </td>
        <td>
            <form:input path="uid" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="password">
                <spring:message text="Password"/>
            </form:label>
        </td>
        <td>
            <form:input path="password" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="email">
                <spring:message text="Email Address"/>
            </form:label>
        </td>
        <td>
            <form:input path="email" />
        </td>
    </tr>
    
    <tr>
        <td>
            <form:label path="pin">
                <spring:message text="Pin Code"/>
            </form:label>
        </td>
        <td>
            <form:input path="pin" />
        </td>
    </tr>
    
    
    <tr>
    	<td>
    		<form:label path="image">
    			<spring:message text="Upload Image"/>
    		</form:label>
    	</td>
    	<td>
    		<form:input path="image" type="file"/>
    	</td>
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${empty name}">
                <input type="submit" text="Upload Image"/>
            </c:if>
        </td>
    </tr>
</table>  
</form:form>       
 
  </body>
</html>