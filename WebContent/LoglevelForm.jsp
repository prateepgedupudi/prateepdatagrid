<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Dynamic Log Level Change with SLF4J-LOG4J </title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<script type='text/javascript'
	src='http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.1/angular.min.js'></script>
</head>
<body>
	<div ng-app="myApp">
		<div ng-controller="LogLevelController">
		  <form name="myForm" action="LogLevel">
		    <label for="Package"> Package Select: </label>
		    <select name="Package" id="Package">
		      <option ng-repeat="option in data.availablePackageOptions" value="{{option.id}}">{{option.name}}</option>
		    </select>
		    <label for="Level"> Log Level Select: </label>
		    <select name="Level" id="Level" ng-model="data.repeatSelect" ng-change="getLogLevelData(data.repeatSelect)">
		      <option ng-repeat="option in data.availableOptions" value="{{option.id}}">{{option.name}}</option>
		    </select>
		    
		    <input type="submit" value="Submit">
		  </form>
		  <hr>
		  <tt>Log Level = {{data.repeatSelect}}</tt><br/>
		</div>
		
	</div>
	



	<script type='text/javascript'>
		//<![CDATA[ 
var app=angular.module("myApp",[]);
app.controller('LogLevelController', ['$scope', function($scope) {
	   $scope.data = {
			    repeatSelect: null,
			    availableOptions: [
			      {id: 'ALL', name: 'All'},
			      {id: 'INFO', name: 'Info'},
			      {id: 'DEBUG', name: 'Debug'},
			      {id: 'ERROR', name: 'Error'},
			      {id: 'TRACE', name: 'Trace'},
			      {id: 'WARN', name: 'Warn'},
			      {id: 'OFF', name: 'Off'}
			    ],
			    availablePackageOptions: [
  			      {id: 'com.prateep', name: 'com.prateep'},
  			      {id: 'com.prateep.util', name: 'com.prateep.util'}
  			    ]
			   };
	   
	   
}]);
		
		//]]>
	</script>


</body>


</html>

