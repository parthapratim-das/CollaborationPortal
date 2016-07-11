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
	
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700" rel="stylesheet" type="text/css" />
    <link href="resources/css/demo.css" rel="stylesheet" type="text/css" />
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
            <c:set var="img" value=<c:url value="/resources/images/diginxt.png"/>/>
            <a class="navbar-brand" href="home">
                <img src="https://www.news-pr.in/wp-content/uploads/diginxt_48232.jpg" height="70" width="250" alt="">
            </a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="Blog">Blog</a></li>
                <li><a href="ChatPage">Chat</a></li>
                <li><a href="#">Log Out</a></li>
            </ul>
        </div>
    </div>
</nav>

<!--  ========= Body ========= -->
<br><br><br><br><br>

<table class="span5 center-table">
<tr>
<td>
<div class="text-xs-center">
  <img src="resources/images/${user.uid}.jpg" class="img-circle" width="304" height="236" alt="...">
</div>
</td>
<td>

<div ng-controller="ChatCtrl" class="container">
      <form ng-submit="addMessage()" name="messageForm">
        <input type="text" placeholder="Compose a new message..." ng-model="message" />
        <div class="info">
          <span class="count" ng-bind="max - message.length" ng-class="{danger: message.length > max}">140</span>
          <button ng-disabled="message.length > max || message.length === 0">Send</button>
        </div>
      </form>
      <hr />
      <p ng-repeat="message in messages | orderBy:'time':true" class="message">
      	<span>{{message.username}}</span>
        <time>{{message.time | date:'HH:mm'}}</time>
        <span ng-class="{self: message.self}">{{message.message}}</span>
      </p>
    </div>

</td>
<tr>
<td><b><i>Hi, ${user.firstname}</i></b></td>
</tr>
</tr>
</table>
 
 
<script src="resources/libs/sockjs/sockjs.min.js" type="text/javascript"></script>
    <script src="resources/libs/stomp-websocket/lib/stomp.min.js" type="text/javascript"></script>
    <script src="resources/libs/angular/angular.min.js"></script>
    <script src="resources/libs/lodash/dist/lodash.min.js"></script>
    <script src="resources/js/app.js" type="text/javascript"></script>
    <script src="resources/js/controllers.js" type="text/javascript"></script>
    <script src="resources/js/services.js" type="text/javascript"></script>
 
  </body>
  

</html>