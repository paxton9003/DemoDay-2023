/**

 * Access the previously created module 'movieapp'

 */

 

(function() {

	var myCafeApp = angular.module('myCafeApp');

 

	myCafeApp.controller('createController', function($scope, $http) {			

		

		$scope.foodTypes = ['Breakfast','Dessert','Drink'];
		$scope.vegan = [true, false];
		$scope.hasCaffeine = [true, false];

		

		$scope.createFoodItem = function() {

			$http.post("/cafeapp/webapi/food/", $scope.foodItem)

			.then(function(response) {				

				$scope.createStatus = 'create successful';

				$scope.disableCreate = true;

			}, function(response) {

				$scope.createStatus = 'error trying to create food item';	

				console.log('error http POST food items: ' + response.status);

			});

		}

		

		$scope.clear = function() {

			$scope.foodItem.menuName = '';

			$scope.foodItem.price = '';

			$scope.foodItem.foodType = '';
			
			$scope.foodItem.vegan = '';
			
			$scope.foodItem.hasCaffeine = '';

			$scope.disableCreate = false;

		}

		

	});

	

})()