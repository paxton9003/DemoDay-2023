/**
 * Access previously created module
 */
 (function(){
 let myCafeApp = angular.module('myCafeApp');
 
 myCafeApp.controller('filterController', function($scope, $http){
	 
	 $scope.getVeganFoodItems = function() {

			$http.get("/cafeapp/webapi/food/vegan/true")

			.then(function(response) {

				$scope.foodVeganItems = response.data;

				console.log('number of food items: ' + $scope.foodVeganItems.length);

			}, function(response) {

				console.log('error http GET food items: ' + response.status);

			});

		}
		
		$scope.getVeganFoodItems();
		
		
		
		
		$scope.getDrinkFoodItems = function() {

			$http.get("/cafeapp/webapi/food/drink/")

			.then(function(response) {

				$scope.drinkItems = response.data;

				console.log('number of food items: ' + $scope.drinkItems.length);

			}, function(response) {

				console.log('error http GET food items: ' + response.status);

			});

		}
		
		$scope.getDrinkFoodItems();
		
		
		$scope.getDessertFoodItems = function() {

			$http.get("/cafeapp/webapi/food/dessert/")

			.then(function(response) {

				$scope.foodDessertItems = response.data;

				console.log('number of food items: ' + $scope.foodDessertItems.length);

			}, function(response) {

				console.log('error http GET food items: ' + response.status);

			});

		}
		
		$scope.getDessertFoodItems();
		
		
			
			$scope.getBreakfastFoodItems = function() {

			$http.get("/cafeapp/webapi/food/breakfast/")

			.then(function(response) {

				$scope.breakfastItems = response.data;

				console.log('number of food items: ' + $scope.breakfastItems.length);

			}, function(response) {

				console.log('error http GET food items: ' + response.status);

			});

		}
		
		$scope.getBreakfastFoodItems();
		
		
		
	
 });
 
 })()