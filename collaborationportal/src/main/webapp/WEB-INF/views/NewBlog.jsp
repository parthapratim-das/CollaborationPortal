<!DOCTYPE html>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en"> 
<head> 

	<meta charset="utf-8">   
	<title>Home</title>   
	<link href="/twitter-bootstrap/twitter-bootstrap-v2/docs/assets/css/bootstrap2.2.css" rel="stylesheet">  
	<link rel="stylesheet" href="demo.css">
	<link rel="stylesheet" href="footer-distributed.css">
	
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
	<script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
</head>  
<body>


	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="home">
                <img src="https://www.news-pr.in/wp-content/uploads/diginxt_48232.jpg" height="70" width="250" alt="">
            </a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            	<li class="active"><a href="backtoHomePage?userid=${param.userid}">Home</a></li>
            	<li><a href="/ChatPage">Chat</a></li>            	
            </ul>
            <ul class="nav navbar-nav navbar-right">
            	<li>
          			<a href="#">Welcome ${param.userid}</a>
          		</li>
          		<li>
          			<a href="logout">logout</a>
          		</li>
          	</ul>
         </div>
       </div>
     </nav>
         <br><br><br><br><br><br>
         
 <!-- ============== Table with population of data ================= -->        
       <table id="myTable" class="table table-striped" >  
        <thead>  
          <tr>  
            <th>Blog Number</th>  
            <th>Title</th>  
            <th>What You Have Written</th> 
            <th>When Posted</th>
            <th>Employee ID</th> 
            <th>Employee Name</th>
            <th>Details</th>
          </tr>  
        </thead>  
        <tbody>  
        <c:forEach items="${listfromtable}" var="element">
          <tr>  
            <td><%-- ${element.blogid}<br> --%><img src="resources/images/${element.user}.jpg" class="img-circle" width="70" height="50" alt="..."></td>  
            <td>${element.title}</td>  
            <td>${element.content}</td>  
            <td>${element.date}</td> 
           <td>${element.user}</td>
           <td>${element.username}</td>
          
           <td><a href="remove/${element.blogid}">Delete</a>|<a href="editproduct/${element.blogid}">Edit</a></td> 
          </tr>  
 	</c:forEach>
        </tbody>  
      </table>  
      
     <div class="container">
     		<a href="addnew?userid=${param.userid}"><b>Add New Blog</b></b></a>
     </div>


</body>  
<script>
$(document).ready(function(){
    $('#myTable').dataTable();
});
</script>

</body>
</html>