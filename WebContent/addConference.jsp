<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
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
			<h1 class="h1_text_main">Создание конференции</h1>
			<hr>
			<div class="form_addConference">
				<form name="viewForm" method="POST" action="FrontController">
					<input type="hidden" name="command" value="AddConferenceCommand" />
					<input type="hidden" name="idClient" value="${user.idClient}" />
					<div class="form_group">

						<div class="form_group_label">
							<p>Название:</p>
						</div>
						<div class="form_group_input">
							<input type="text" name="nameConference" value="" autofocus />
						</div>
					</div>
					<div class="form_group">

						<div class="form_group_label">
							<p>Дата проведения:</p>
						</div>
						<div class="form_group_input">
							<input type="date" name="date">
						</div>
					</div>
					<div class="form_group">
						<div class="form_group_label">
							<p>Город:</p>
						</div>
						<div class="form_group_input">
							<input type="text" name="city" value="" />
						</div>
					</div>
			</div>
			<div class="button_add">
				<input type="submit" value="Добавить" class="button" />
				<button type="button" class="button_cancel">
					<a href="viewModerator.jsp" style="color: white">Отмена</a>
				</button>
			</div>
			</form>
		</div>
	</div>
</body>
</html>