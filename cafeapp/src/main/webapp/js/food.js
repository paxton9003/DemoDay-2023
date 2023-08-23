/**
 * Creates a new module named "myCafeApp"
 * All controllers will be here
 */

 (function(){
 let myCafeApp = angular.module('myCafeApp', ['ngRoute']);
 
 myCafeApp.config(function($routeProvider) {			

	  $routeProvider

	  .when("/search", {

	    templateUrl : "search.html",
	    controller : "searchController"

	  })

	  .when("/create", {

	    templateUrl : "create.html",
	    controller : "createController"

	  })
	 
	  .when("/update/:foodItemId", {

	    templateUrl : "update.html",
	    controller : "updateController"

	  })

	  .when("/resume", {

	    templateUrl : "resume.html"

	  })
	  
	   .when("/menu", {

	    templateUrl : "menu.html",
	    controller : "filterController"

	  })
	  
	  .when("/stack", {

	    templateUrl : "stack.html",

	  })

	  .otherwise({

		 templateUrl : "main.html",
		 controller : "searchController"

	  });			

	})
})()