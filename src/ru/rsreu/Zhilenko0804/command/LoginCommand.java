package ru.rsreu.Zhilenko0804.command;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.Zhilenko0804.dao.DAOFactory;
import ru.rsreu.Zhilenko0804.data.*;
import ru.rsreu.Zhilenko0804.logic.LoginLogic;
import ru.rsreu.Zhilenko0804.oracledb.OracleClientDAO;
import ru.rsreu.Zhilenko0804.resourcer.ConfigurationManager;
import ru.rsreu.Zhilenko0804.resourcer.MessageManager;
import ru.rsreu.Zhilenko0804.resourcer.ResourcerManager;

public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public Page execute(HttpServletRequest request) {
		Page page = new Page();
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		Client client;

		DAOFactory factory = (DAOFactory) request
				.getServletContext()
				.getAttribute(
						ResourcerManager
								.getProperty("servletContext.attribute.factory"));
		OracleClientDAO clientDAO = (OracleClientDAO) factory.getClientDAO();
		client = clientDAO.findClient(login, pass);
		if (client.getType() != null) {
			page = LoginLogic.checkLogin(client, request, clientDAO);
		} else {
			request.setAttribute("errorLoginPassMessage",
					MessageManager.getProperty("message.loginerror"));
			page.setUrl(ConfigurationManager.getProperty("path.page.login"));
			page.setType(TypeMethodEnum.FORWARD);
		}
		return page;
	}
}