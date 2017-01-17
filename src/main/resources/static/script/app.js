'use strict';

var app = angular.module("MyApp", []);

app.controller("produitController", 
	function($scope, $http){
			$scope.pageProduits = null;
			$scope.motCle="";
			$scope.pageCourante = 0;
			$scope.size = 5;
			$scope.pageMax = 0;
			
		$scope.chercher = function(numeroPage){
			$http.get("http://localhost:8080/chercher?mc="+$scope.motCle
					+"&page="+numeroPage+"&size="+$scope.size)
			.then(
				function(object){
					$scope.pageProduits = object.data;
					$scope.pageMax = $scope.pageProduits.totalPages-1;
					console.log(object.data);
				}, 
				function(err){
					console.log(err);
				}
			);
		}
		
		$scope.changerPage = function(value){
			
			var numeroPage = $scope.pageCourante + value;
			$scope.chercher(numeroPage);
		}
	});