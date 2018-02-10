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
	
  
    <div ng-include="contextpath+'resources/views/gameView.html'"></div>	
  
	<div class="ui page dimmer" ng-class="{'active':loading}">
  <div class="content">
  <div class="ui large text loader">Fetching Games</div>
    
  </div>
</div>	
<style>
body{
	background: #6c8eab !important;
}
</style>
	</body>
</html>