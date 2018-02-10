<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en-US">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta Http-Equiv="Cache-Control" Content="no-cache">
		<meta Http-Equiv="Pragma" Content="no-cache">
		<meta Http-Equiv="Expires" Content="0">
		<title>Game List</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/semantic.min.css">
		
		<script	src="${pageContext.request.contextPath}/resources/js/lib/jquery.min.js"></script>
		
		<script>
			var contextPath='${pageContext.request.contextPath}/';
			var userName='abhishek';
		</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/angular.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/semantic.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/cm/app.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/cm/controllers/game.js"></script>
	</head>

	<body ng-app="game" ng-controller="gameCtrl" ng-cloak>
	<div id="sidebar"  class="ui left vertical menu sidebar inverted visible abhi">
	<a class = "item">
		<i class="huge home icon"></i>
		<h3>Game Library</h3>
	</a>
    <a class="item" ng-class="{'active':item=='all'}">
      All Games
      <i class="calendar icon"></i>
    </a>
    <a class="item" ng-class="{'active':item=='add'}" ng-click="addUI()">
      Search for Game
      <i class="add to calendar icon"></i>
    </a>
   
  </div>
  <div class="pusher">
   <div class="ui active dimmer">
    <div class="ui indeterminate text loader">Fetching Games</div>
  </div>
    <div ng-include="contextpath+'resources/views/gameView.html'"></div>	
  </div>
		
	</body>
</html>