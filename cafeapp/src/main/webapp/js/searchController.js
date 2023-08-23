/**
 * Access previously created module
 */
 (function(){
 let myCafeApp = angular.module('myCafeApp');
 
 myCafeApp.controller('searchController', function($scope, $http, $location){
	
	 $scope.getAllFoodItems = function() {

			$http.get("/cafeapp/webapi/food")

			.then(function(response) {

				$scope.foodItems = response.data;

				console.log('number of food items: ' + $scope.foodItems.length);

			}, function(response) {

				console.log('error http GET food items: ' + response.status);

			});

		}

		

		$scope.getAllFoodItems();
		
		$scope.goToUpdateView = function(foodItemId){
			console.log("food id: " + foodItemId);
			$location.path('/update/' + foodItemId);
		}
		
		
		$scope.goToMenuView = function(){
			$location.path('/menu/');
		}

			
	
 });
 
 })()