<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h1 class="h1_text_main">Просмотр докладов на конференции</h1>
			<hr>
			<div class="form_button_cancel">
				<button type="button" class="button_cancel"
					style="margin-left: 500px;">
					<a href="javascript:history.back()" style="color: white">Назад</a>
				</button>
			</div>
			<c:if test="${not empty reportsList}">
				<div class="table_viewReport">
					<table>
						<tr>
							<th colspan="2">Автор</th>
							<th>Название доклада</th>
						</tr>
						<c:forEach items="${reportsList}" var="request">
							<tr>
								<td>${request.client['name']}</td>
								<td>${request.client['lastName']}</td>
								<td>${request.nameReport}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:if>
			<c:if test="${empty reportsList}">Докладов нет</c:if>
		</div>
	</div>

</body>
</html>