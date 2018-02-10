game.controller('gameCtrl', function($scope ,  $location , $window, $http, $timeout, $q, $filter) {
	$scope.contextpath = contextPath;
	$scope.platforms = ["All","Wii","Android","Linux","PlayStation 3","PC","Nintendo DS","NeoGeo Pocket Color","PlayStation","Lynx","Saturn","Game Boy Color","Nintendo 64DD","iPad","PlayStation Portable","Wii U","iPhone","PlayStation 4","Game.Com","Xbox 360","PlayStation Vita","Macintosh","Dreamcast VMU","Arcade","Nintendo 64","Dreamcast","Nintendo 3DS","Game Boy","WonderSwan"];
	$scope.genres = ["All","Racing","Compilation","Fighting","Party","Sports, Simulation","Strategy","Platformer","Sports","Shooter","Flight, Action","Simulation, Adventure","Wrestling","Simulation","Card, Battle","Sports, Racing","Trivia","Virtual Pet","Action, Adventure","Action, Compilation","Action, Platformer","RPG, Editor","Sports, Action","Productivity","Fighting, Action","Strategy, RPG","Music, Editor","Puzzle","Music","Flight, Simulation","Racing, Action","Battle","Board","Sports, Editor","Educational, Puzzle","Hunting","Adventure","Other","Fighting, Compilation","Racing, Simulation","Action, RPG","Action","Puzzle, Action","RPG","Casino","Music, Action","Pinball","Puzzle, Word Game","Puzzle, Adventure","Shooter, RPG","Action, Simulation","Flight"];
	$scope.search='';
	$scope.searchTerm=null;
	$scope.message="Fetching Games";
	$scope.type = 'Title';
	$scope.type2 = null;
	$scope.activeElement = 'random';
	$scope.allGames=[];
	$scope.currentPage =1;
	$scope.resultSize = 0;
	$scope.userName=userName;
	$scope.loading=true;
	$scope.pageSize = 10;
	$scope.offset=0;
	$scope.platform=null;
	$scope.pagesCount=0;
	$scope.genre=null;
	var canceller = null;
	
	$scope.load = function(){
		$('.ui.dropdown')
		  .dropdown()
		;
	};
	$scope.load2 = function(){
		$timeout( function(){
			$('.ui.rating').rating();
        }, 1000 );
		
	}
	
	$scope.setPlatform = function(platform){
		$scope.platform=platform;
	}
	
	$scope.setGenre = function(genre){
		$scope.genre=genre;
	}
	$scope.setSearchTerm = function(searchTerm){
		$scope.searchTerm=searchTerm;
	}
	$scope.fetchGamesView = function(view){
		$scope.activeElement = view;
		$scope.allGames=[];
		$scope.resultSize = 0;
		if(view=='editorChoice')
			$scope.fetchGames(view,'nextOrPrevious');
		if(view=='random')
			$scope.fetchGames(view,'nextOrPrevious');
		
	}
	
	$scope.fetchGames = function(type,from){
		if(from!='nextOrPrevious'){
			$scope.currentPage = 1;
			$scope.type2 = type;
		}
		$scope.allGames=[];
		$scope.loading=true;
		$scope.resultSize = 0;
		console.log(type);
		if(type == 'Title')
			$scope.fetchGamesByTitle($scope.searchTerm, $scope.pageSize, $scope.offset);
		else if(type == 'Platform')
			$scope.fetchGamesByPlatform($scope.searchTerm,$scope.platform, $scope.pageSize, $scope.offset);
		else if(type == 'Genre')
			$scope.fetchGamesByGenre($scope.searchTerm,$scope.genre, $scope.pageSize, $scope.offset);
		else if(type == 'editorChoice')
			$scope.fetchECGames( $scope.pageSize, $scope.offset);
		else if(type == 'random')
			$scope.fetchAllGames( $scope.pageSize, $scope.offset);
	}
	$scope.fetchGamesByPlatform = function(searchTerm, platform, pageSize, offset){
		if(searchTerm==null || searchTerm=='')
			searchTerm="ALL";
		
		$scope.message="Please wait while we update the page";
		
		var res = $http.get(contextPath+'fetch-platform/'+platform+'/'+searchTerm+'/'+pageSize+'/'+offset);
		res.success(function(data) {
			$scope.message="Success";
			$scope.allGames = data.games;
			$scope.resultSize = data.count;
			console.log(data);
			$scope.loading = false;
			$scope.paginate();
			
			
		});
		res.error(function(data, status, headers, config) {
			$scope.loading = false;
			
			$scope.message="Error while fetching games";
		});
	};//End Platform
	
	$scope.fetchGamesByGenre = function(searchTerm, genre, pageSize, offset){
		if(searchTerm==null || searchTerm=='')
			searchTerm="ALL";
		
		$scope.message="Please wait while we update the page";
		
		var res = $http.get(contextPath+'fetch-genre/'+genre+'/'+searchTerm+'/'+pageSize+'/'+offset);
		res.success(function(data) {
			$scope.message="Success";
			$scope.allGames = data.games;
			$scope.resultSize = data.count;
			console.log(data);
			$scope.loading = false;
			$scope.paginate();
			
			
		});
		res.error(function(data, status, headers, config) {
			$scope.loading = false;
			
			$scope.message="Error while fetching games";
		});
	};//End Platform
	
	$scope.fetchGamesByTitle = function(title, pageSize, offset){
		
		$scope.message="Please wait while we update the page";
		var res = $http.get(contextPath+'fetch-all/'+title+'/'+pageSize+'/'+offset);
		res.success(function(data) {
			
			$scope.message="Success";
			$scope.allGames = data.games;
			$scope.resultSize = data.count;
			console.log(data);
			$scope.loading = false;
			$scope.paginate();
			
			
		});
		res.error(function(data, status, headers, config) {
			$scope.loading = false;
			
			$scope.message="Error while fetching games";
		});
	}
	
	$scope.fetchAllGames = function(){
		var res = $http.get(contextPath+'fetch-random/'+$scope.pageSize+'/'+$scope.offset);
		
		res.success(function(data) {
			
			$scope.message="Success";
			$scope.allGames = data.games;
			$scope.resultSize = data.count;
			console.log(data);
			$scope.loading = false;
			$scope.paginate();
			
			
			
		});
		res.error(function(data, status, headers, config) {
			$scope.loading = false;
			
			$scope.message="Error while fetching games";
		});
	};
	
	$scope.fetchECGames = function(){
		var res = $http.get(contextPath+'fetch-ec/'+$scope.pageSize+'/'+$scope.offset);
		
		res.success(function(data) {
			
			$scope.message="Success";
			$scope.allGames = data.games;
			$scope.resultSize = data.count;
			console.log(data);
			$scope.loading = false;
			$scope.paginate();
			
			
			
		});
		res.error(function(data, status, headers, config) {
			$scope.loading = false;
			
			$scope.message="Error while fetching games";
		});
	};
	
	$scope.confirm= function(){
		
		$('.ui.basic.test.modal').modal('show');
	};
	
	
	$scope.paginate = function(){
		$scope.pagesCount = Math.ceil($scope.resultSize /10);
		$scope.pageNumbers = [];
		
		var i = $scope.currentPage-2;
		if(i<1)
			i=1;
		if($scope.pagesCount-i<4)
			i=$scope.pagesCount-4;
		if(i<1)
			i=1;
		for(var k=0; i <=$scope.pagesCount && k<5; i++, k++)
		{
			$scope.pageNumbers.push(i);
			}
		
	};
	
	$scope.nextPage = function(){
		$scope.currentPage+=1;
		$scope.offset+=10;
		$scope.fetchGames($scope.type2,'nextOrPrevious');
	}
	
	$scope.prevPage = function(){
		$scope.currentPage-=1;
		$scope.offset-=10;
		if($scope.offset<0)
			$scope.offset=0;
		$scope.fetchGames($scope.type2,'nextOrPrevious');
	}
	
	$scope.loadPage = function(pageNumber){
		$scope.currentPage=pageNumber;
		$scope.offset=10*(pageNumber-1);
		$scope.fetchGames($scope.type2,'nextOrPrevious');
	}
	
	$scope.ret = function(number){
		return Math.round(number);
	}
	
	
});