"use strict";

/**
 * Intercation avec les services REST
 */
var produitService = angular.module('produitService', [ 'ngResource' ]);

produitService.factory('produitService', [ '$resource','$http', function($resource,$http) {
    var service = {
	    updateProduit: function(produit){
			console.log(" °°°°°°°° mettre a jour un produit °°°°°°°°");

			
			// A changer une fois la partie login changer - recupération par username et non pas par mail
			var produitDto= {'id':produit.id, 'description':produit.description, 'prix':produit.prix, 'quantite': produit.quantite};

			return $http.put('http://localhost:8080/produits', produitDto)
			.success(function(data){
			    console.log("****** Mise a jour du produit OK ! *******");
			})
			.error(function(data){
			    console.log("*** /!\ /!\ /!\ ERROR : Mise a jour du produit KO ! /!\ /!\ /!\***");
			    console.log(data);
			})
	    },
	    getAllProduits : function(){
	    	console.log("getAllProduits !");
			return $resource('/produits', {}, {
			    query : {
				method : 'GET', isArray:true,
			    }
			});
	    },
		getProduits: function(){
			$http.get("http://localhost:8080/produits")
			.then(
				function(object){
					return object.data;
				}, 
				function(err){
					console.log(err);
				}
			)
		 }
   };
   return service;

} ]);
