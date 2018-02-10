game.controller('gameCtrl', function($scope ,  $location , $window, $http, $timeout, $q, $filter) {
	$scope.contextpath = contextPath;
	
	$scope.search='';
	$scope.item = 'all';
	$scope.allGames=[];
	$scope.userName=userName;
	$scope.loading=true;
	$scope.pageSize = 10;
	$scope.offset=0;
	var canceller = null;
	
	$scope.fetchAllGames = function(){
		var res = $http.get(contextPath+'fetch-random/'+$scope.pageSize+'/'+$scope.offset);
		
		res.success(function(data) {
			
			$scope.message="Success";
			$scope.allGames = data;
			console.log($scope.allGames);
			$scope.loading = false;
			$('.ui.dimmer').removeClass("active");
			
		});
		res.error(function(data, status, headers, config) {
			$scope.loading = false;
			$('.ui.dimmer').removeClass("active");
			$scope.message="Error while fetching games";
		});
	};
	
	$scope.confirm= function(){
		
		$('.ui.basic.test.modal').modal('show');
	};
	
	
});