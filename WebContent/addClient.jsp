<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Conference</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="reset.css">
</head>
<body>
	<fmt:setLocale value="ru-RU" />
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
			<h1 class="h1_text_main">Добавление клиента</h1>
			<hr>
			<form name="viewForm" method="POST" action="FrontController">
				<input type="hidden" name="command" value="AddUserCommand" />
				<div class="form_addClient">
					<div class="form_group">

						<div class="form_group_label">
							<p>Имя:</p>
						</div>
						<div class="form_group_input">
							<input type="text" name="name" value="" autofocus />
						</div>
					</div>
					<div class="form_group">

						<div class="form_group_label">
							<p>Фамилия:</p>
						</div>
						<div class="form_group_input">
							<input type="text" name="lastName" value="" />
						</div>
					</div>
					<div class="form_group">
						<div class="form_group_label">
							<p>Тип:</p>
						</div>
						<div class="form_group_input">
							<select name="clientType">
								<option value="2">Пользователь</option>
								<option value="3">Модератор</option>
							</select>
						</div>
					</div>
					<div class="form_group">
						<div class="form_group_label">
							<p>Логин:</p>
						</div>
						<div class="form_group_input">
							<input type="text" name="login" value="" />
						</div>
					</div>
					<div class="form_group">
						<div class="form_group_label">
							<p>Пароль:</p>
						</div>
						<div class="form_group_input">
							<input type="text" name="password" value="" />
						</div>
					</div>
				</div>
				<div class="button_add">
					<input type="submit" value="Добавить" class="button" />

					<button type="button" class="button_cancel">
						<a href="viewUsers.jsp" style="color: white">Отмена</a>
					</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>