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
		  <form name="myForm">
		    <label for="repeatSelect"> Log Level Select: </label>
		    <select name="repeatSelect" id="repeatSelect" ng-model="data.repeatSelect" ng-change="getLogLevelData(data.repeatSelect)">
		      <option ng-repeat="option in data.availableOptions" value="{{option.id}}">{{option.name}}</option>
		    </select>
		  </form>
		  <hr>
		  <tt>Log Level = {{data.repeatSelect}}</tt><br/>
		  <tt>{{responseData}}</tt><br/>
		</div>
		
	</div>
	



	<script type='text/javascript'>
		//<![CDATA[ 
var app=angular.module("myApp",[]);
app.controller('LogLevelController', ['$scope', function($scope,LogLevelDataService) {
	   $scope.data = {
			    repeatSelect: null,
			    availableOptions: [
			      {id: 'ALL', name: 'All'},
			      {id: 'INFO', name: 'Info'},
			      {id: 'DEBUG', name: 'Debug'},
			      {id: 'ERROR', name: 'Error'},
			      {id: 'TRACE', name: 'Trace'},
			      {id: 'WARN', name: 'Warn'}
			    ],
			   };
	   
	   
}]);
app.factory('LogLevelDataService', function ($http) {
    return {
        getLogLevelData: function (level, callback) {
            var params = {
                Level: level
            }

            return $http({
                url: '/prateepdatagrid/Loglevel',
                method: 'GET',
                params: params
            }).success(callback);
        }
    };
});
app.controller('testController',function SSOApp($scope, $http, $interval) {
	$scope.doRequest = function() {
		var url = "/prateepdatagrid/Prateep";
		$http.get(url).success(function(data) {
			console.log(data);
		});
	};
	
});
		
		//]]>
	</script>


</body>


</html>

