<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Conference</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="reset.css">
</head>
<body>
	<div id="header">
		<div id="nameConference">Conference</div>
		<form name="viewForm" method="POST" action="FrontController">
			<input type="hidden" name="command" value="LOGOUT" />
			<div class="dropdown">
				<input type="submit" value="Выйти" class="dropbtn" />
			</div>
		</form>
		<div id="nameUser">${user.name}</div>
	</div>
	<div id="page_layout">
		<div class="mainInfo">
			<h1 class="h1_text_main">Список пользователей</h1>
			<hr>
			<div class="button_add">
				<form name="viewForm" method="POST" action="FrontController"
					style="margin-left: 350px">
					<input type="hidden" name="command" value="ViewUsersCommand" /> <input
						type="submit" value="Просмотр" class="button" />
				</form>

				<button type="button" class="button"
					style="margin-left: 350px; margin-top: 3px">
					<a href="addClient.jsp" style="color: white">Добавить</a>
				</button>
			</div>
			${resultAdd} ${resultDelete}
			<div class="table_viewReport">
				<table>
					<tr>
						<th>Имя</th>
						<th>Фамилия</th>
						<th>Тип</th>
						<th>Логин</th>
						<th>Пароль</th>
						<th>Статус</th>
					</tr>

					<c:forEach items="${usersList}" var="user">
						<form name="viewForm" method="POST" action="FrontController">
							<input type="hidden" name="command" value="DeleteUserCommand" />
							<input type="hidden" name="idClient" value="${user.idClient}" />
							<tr>
								<td>${user.name}</td>
								<td>${user.lastName}</td>
								<td>${user.type}</td>
								<td>${user.login}</td>
								<td>${user.password}</td>
								<td>${user.status}</td>

								<td><input type="submit" value="Удалить"
									class="button_cancel" /></td>
							</tr>
						</form>
					</c:forEach>

				</table>
			</div>

		</div>
	</div>
</body>
</html>