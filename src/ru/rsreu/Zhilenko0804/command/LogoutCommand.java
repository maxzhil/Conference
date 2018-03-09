package ru.rsreu.Zhilenko0804.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ru.rsreu.Zhilenko0804.command.ActionCommand;
import ru.rsreu.Zhilenko0804.dao.DAOFactory;
import ru.rsreu.Zhilenko0804.data.*;
import ru.rsreu.Zhilenko0804.oracledb.OracleClientDAO;
import ru.rsreu.Zhilenko0804.resourcer.ConfigurationManager;
import ru.rsreu.Zhilenko0804.resourcer.ResourcerManager;

public class LogoutCommand implements ActionCommand {

	@Override
	public Page execute(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		Page page = new Page();
		DAOFactory factory = (DAOFactory) request
				.getServletContext()
				.getAttribute(
						ResourcerManager
								.getProperty("servletContext.attribute.factory"));
		OracleClientDAO clientDAO = (OracleClientDAO) factory.getClientDAO();
		Client client = (Client) session.getAttribute(ResourcerManager
				.getProperty("parameter.user"));

		if (clientDAO.isLogged(client.getIdClient())) {
			clientDAO.logOut(client.getIdClient());

		}

		request.getSession().invalidate();
		page.setType(TypeMethodEnum.SENDREDIRECT);
		page.setUrl(ConfigurationManager.getProperty("path.page.index"));
		return page;
	}
}