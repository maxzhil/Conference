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

			<h1 class="h1_text_main">Просмотр конференций</h1>
			<hr>
			<div class="viewConference_par">
				${resultAddRequest}
				<form name="viewForm" method="POST" action="FrontController">
					<input type="hidden" name="command"
						value="UserViewConferenceCommand" /> <a>Просмотреть список</a> <select
						name="dateTypeConference">
						<option value="1">текущих</option>
						<option value="2">окончившихся</option>
					</select> <a>конференций.</a> <input type="submit" value="Просмотр"
						class="button" />

				</form>

			</div>

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
										value="VIEWREPORTSFROMCOMMAND" /> <input type="hidden"
										name="idConference" value="${conference.idConference}" /> <input
										type="submit" value="Просмотр" class="button_cancel" />
								</form>
							</td>
							<td>
								<form name="viewForm" method="POST" action="FrontController">
									<input type="hidden" name="command"
										value="AddRequestFormCommand" /> <input type="hidden"
										name="nameConference" value="${conference.nameConference}" />
									<input type="hidden" name="idConference"
										value="${conference.idConference}" /><input type="submit"
										value="Подать" class="button" />
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