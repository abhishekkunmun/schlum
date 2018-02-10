<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">

</head>
<body>
	<c:url var="loginUrl" value="/authenticate" />
	<form action="${loginUrl}" method="post" class="form-horizontal">
		<div class="container">
			<div class="profile profile--open">
				
				<div class="profile__form">
				<h1>Login !</h1>
					<div class="profile__fields">
						<div class="field">
							<c:if test="${param.error != null}">
								<div id="error">
									<h3>Invalid User/Password</h3>
								</div>
							</c:if>
						</div>
						<div class="field">
							<input type="text" name="username" id="fieldUser" class="input"
								required="true" pattern=".*\S.*"> <label for="fieldUser"
								class="label">Username</label>
						</div>
						<div class="field">
							<input type="password" name="password" id="fieldPassword"
								class="input" required="true" pattern=".*\S.*"> <label
								for="fieldPassword" class="label">Password</label>
						</div>
						<div class="profile__footer">
							<button class="button raised blue" type="submit">
								<div class="center" fit="">LOGIN</div>

							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>

</html>