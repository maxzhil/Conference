<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
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
			<h1 class="h1_text_main">Подача заявки</h1>
			<hr>
			<form name="viewForm" method="POST" action="FrontController">
				<input type="hidden" name="command" value="AddRequestCommand" /> <input
					type="hidden" name="idConference" value="${idConference}" /> <input
					type="hidden" name="idClient" value="${user.idClient}" />
				<div class="form_addRequest">

					<div class="form_group">

						<div class="form_group_label">
							<p>Имя:</p>
						</div>
						<div class="form_group_input">
							<input type="text" name="name" value="${user.name}" autofocus
								disabled />
						</div>
					</div>
					<div class="form_group">
						<div class="form_group_label">
							<p>Название конференции:</p>
						</div>
						<div class="form_group_input">
							<input type="text" name="nameConference"
								value="${nameConference}" disabled />
						</div>
					</div>
					<div class="form_group">
						<div class="form_group_label">
							<p>Название доклада:</p>
						</div>
						<div class="form_group_input">
							<input type="text" name="nameReport" value="" />
						</div>
					</div>
				</div>
				<div class="button_add">
					<input type="submit" value="Подать" class="button" />
					<button type="button" class="button_cancel">
						<a href="viewConference.jsp" style="color: white">Отмена</a>
					</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>