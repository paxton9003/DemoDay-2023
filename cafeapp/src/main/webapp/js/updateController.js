/**
 * Access previously created module myCafeApp
 */
 (function(){
 let myCafeApp = angular.module('myCafeApp');
 
 myCafeApp.controller('updateController', function($scope, $http, $routeParams, $location){
	
	$scope.getFoodItemsById = function() {

			$http.get("/cafeapp/webapi/food/id/" + $routeParams.foodItemId)

			.then(function(response) {

				var foodItems = response.data;

				if (foodItems.length == 1) {

					$scope.foodItem = foodItems[0];

				} else {

					//TODO error message

				}				

			}, function(response) {

				console.log('error http GET food items by id: ' + response.status);

			});

		}

		$scope.getFoodItemsById();
		
		$scope.foodTypes = ['Dessert', 'Breakfast', 'Drink'];
		$scope.vegan = [true, false];
		$scope.caffeine = [true, false];
		
		
		
		$scope.updateFoodItem = function() {

			$http.put("/cafeapp/webapi/food/", $scope.foodItem)

			.then(function(response) {				

				$scope.updateStatus = 'update successful';			

			}, function(response) {

				$scope.updateStatus = 'error trying to update food item';	

				console.log('error http PUT food items: ' + response.status);

			});

		}
		
		$scope.deleteFoodItem = function() {

			$http.delete("/cafeapp/webapi/food/id/" + $scope.foodItem.id)

			.then(function(response) {				

				$scope.updateStatus = 'delete successful';	

				$scope.disableUpdate = true;

			}, function(response) {

				$scope.updateStatus = 'error trying to delete food item';	

				console.log('error http DELETE food item: ' + response.status);

			});

		}
		
		
		$scope.goToSearchView = function(){
			$location.path('/search')
		}
	
 });
 
 })()