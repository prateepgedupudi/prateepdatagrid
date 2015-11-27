<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>SSO App</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<script type='text/javascript'
	src='http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.1/angular.min.js'></script>
</head>
<body>
	<div ng-app="myApp" ng-controller="testController">
		<div id="sample"></div>
		<table>
			<tr ng-repeat="d in details">
				<td>{{d.id}}</td>
				<td>{{d.item}}</td>
				<td>{{d.quality}}</td>
				<td>{{d.cost}}</td>
				<td>{{d.total}}</td>
			</tr>
		</table>
	</div>



	<script type='text/javascript'>
		//<![CDATA[ 
var app=angular.module("myApp",[]);
app.controller('testController',function SSOApp($scope, $http, $interval) {
	$scope.doRequest = function() {
		var url = "/prateepdatagrid/Prateep";
		$http.get(url).success(function(data) {
			console.log(data);
		});
	};
	$interval(function() {
		$scope.doRequest();
	}, 3000);
});
		
		//]]>
	</script>


</body>


</html>

