<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta name="description" content=".">
<meta name="keywords" content=".">
<title>Conference</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="reset.css">
</head>
<body>
	<div id="header">
		<div id="nameConference">Conference</div>
	</div>
	<div id="page_layout">
		<div class="aut">
			<form name="loginForm" method="POST" action="FrontController">
				<div id="loginForm">
					<input type="hidden" name="command" value="login" /> Login:<br />
					<input type="text" name="login" value="" autofocus /> <br />Password:<br />
					<input type="password" name="password" value="" /> <br />
					${errorLoginPassMessage} <br /> ${wrongAction} <br /> ${nullPage}
					<br /> <input type="submit" value="Log in" class="button" />
				</div>
			</form>
		</div>
		<div class="mainInfoAut">
			<div class="text_main">
				<h1 class="h1_text_main">Научная конференция</h1>
				<h2 class="h2_text_main">Возможности данного сайта:</h2>
				<div class="ul_list">
					<ul>
						<li>Создание конференций.</li>
						<li>Просмотр информации о конференциях.</li>
						<li>Подача заявок на участие в конференциях.</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>