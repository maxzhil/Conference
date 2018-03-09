package ru.rsreu.Zhilenko0804.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ru.rsreu.Zhilenko0804.data.Client;
import ru.rsreu.Zhilenko0804.data.Page;
import ru.rsreu.Zhilenko0804.data.TypeMethodEnum;
import ru.rsreu.Zhilenko0804.data.UserType;
import ru.rsreu.Zhilenko0804.oracledb.OracleClientDAO;
import ru.rsreu.Zhilenko0804.resourcer.ConfigurationManager;

public class LoginLogic {

	public static Page checkLogin(Client client, HttpServletRequest request,
			OracleClientDAO clientDAO) {
		Page page = new Page();
		if (client.getTypeString().toUpperCase()
				.equals(UserType.MODERATOR.toString())) {

			HttpSession session = request.getSession();
			session.setAttribute("user", client);
			clientDAO.logIn(client.getIdClient());

			page.setUrl(ConfigurationManager
					.getProperty("path.page.viewModerator"));
			page.setType(TypeMethodEnum.SENDREDIRECT);

		} else if (client.getTypeString().toUpperCase()
				.equals(UserType.ADMIN.toString())) {

			HttpSession session = request.getSession();
			session.setAttribute("user", client);
			clientDAO.logIn(client.getIdClient());

			page.setType(TypeMethodEnum.SENDREDIRECT);
			page.setUrl(ConfigurationManager.getProperty("path.page.viewUsers"));
		} else if (client.getTypeString().toUpperCase()
				.equals(UserType.USER.toString())) {

			HttpSession session = request.getSession();
			session.setAttribute("user", client);
			clientDAO.logIn(client.getIdClient());

			page.setUrl(ConfigurationManager
					.getProperty("path.page.viewConference"));
			page.setType(TypeMethodEnum.SENDREDIRECT);

		}
		return page;
	}
}