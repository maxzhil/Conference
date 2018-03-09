<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			<h1 class="h1_text_main">Просмотр конференций</h1>
			<hr>
			<div class="button_add">
				<button type="button" class="button"
					style="float: right; margin-right: 15px;">
					<a href="addConference.jsp" style="color: white">Добавить</a>
				</button>
			</div>
			<div class="viewConference_par">
				<form name="viewForm" method="POST" action="FrontController">
					<input type="hidden" name="command"
						value="ModerViewConferenceCommand" /> <input type="hidden"
						name="idModerator" value="${user.idClient}" />
					<p>
						Просмотреть список <select name="dateTypeConference">
							<option value="1">текущих</option>
							<option value="2">окончившихся</option>
						</select> конференций.
					</p>
					<p>
						Просмотреть список <select name="myConference">
							<option value="1">моих</option>
							<option value="2">всех</option>
						</select> конференций.
					</p>
					<input type="submit" value="Просмотр" class="button" />
				</form>
			</div>
			${resultAddConference} ${resultDelete}
			<div class="table_viewConference">
				<table>
					<tr>
						<th>Название конференции</th>
						<th>Город</th>
						<th>Дата конференции</th>
						<th>Количество докладов</th>
					</tr>
					<c:forEach items="${conferenceList}" var="conference">
						<tr>
							<td>${conference.nameConference}</td>
							<td>${conference.city}</td>
							<td><fmt:formatDate value="${conference.date}" /></td>
							<td>${conference.countReport}</td>
							<td>
								<form name="viewForm" method="POST" action="FrontController">
									<input type="hidden" name="command"
										value="DELETECONFERENCECOMMAND" /> <input type="hidden"
										name="idConference" value="${conference.idConference}" /> <input
										type="hidden" name="idClient" value="${user.idClient}" /><input
										type="submit" value="Удалить" class="button_cancel" />
								</form>
							</td>
							<td>
								<form name="viewForm" method="POST" action="FrontController">
									<input type="hidden" name="command"
										value="VIEWREPORTSFROMCOMMAND" /> <input type="hidden"
										name="idConference" value="${conference.idConference}" /><input
										type="submit" value="Просмотр" class="button" />
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>