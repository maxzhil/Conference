package ru.rsreu.Zhilenko0804.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.Zhilenko0804.command.ActionCommand;
import ru.rsreu.Zhilenko0804.dao.DAOFactory;
import ru.rsreu.Zhilenko0804.data.*;
import ru.rsreu.Zhilenko0804.oracledb.OracleClientDAO;
import ru.rsreu.Zhilenko0804.resourcer.ConfigurationManager;
import ru.rsreu.Zhilenko0804.resourcer.ResourcerManager;

public class DeleteUserCommand implements ActionCommand {

	@Override
	public Page execute(HttpServletRequest request) {
		Page page = new Page();

		DAOFactory factory = (DAOFactory) request
				.getServletContext()
				.getAttribute(
						ResourcerManager
								.getProperty("servletContext.attribute.factory"));
		OracleClientDAO clientDAO = (OracleClientDAO) factory.getClientDAO();

		int idClient = Integer.parseInt(request.getParameter(ResourcerManager
				.getProperty("parameter.idClient")));
		clientDAO.deleteClient(idClient);

		List<Client> users = clientDAO.getAllClient();

		request.getSession().setAttribute(
				ResourcerManager.getProperty("parameter.usersList"), users);
		page.setType(TypeMethodEnum.SENDREDIRECT);
		page.setUrl(ConfigurationManager.getProperty("path.page.viewUsers"));
		return page;
	}
}