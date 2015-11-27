var myApp=angular.module('myApp',[]);

myApp.controller('DataCtrl',function($scope,$http){
	$http.get('/prateepdatagrid/Prateep?start=0&count=25').success(function(data){
		//console.log(data);
		$scope.total=data.numRows;
		$scope.items=data.items;
		
	});
} );