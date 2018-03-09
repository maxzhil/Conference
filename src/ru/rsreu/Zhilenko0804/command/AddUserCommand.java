package ru.rsreu.Zhilenko0804.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.Zhilenko0804.command.ActionCommand;
import ru.rsreu.Zhilenko0804.dao.DAOFactory;
import ru.rsreu.Zhilenko0804.data.*;
import ru.rsreu.Zhilenko0804.oracledb.OracleClientDAO;
import ru.rsreu.Zhilenko0804.resourcer.ConfigurationManager;
import ru.rsreu.Zhilenko0804.resourcer.ResourcerManager;

public class AddUserCommand implements ActionCommand {

	@Override
	public Page execute(HttpServletRequest request) {
		Page page = new Page();

		DAOFactory factory = (DAOFactory) request
				.getServletContext()
				.getAttribute(
						ResourcerManager
								.getProperty("servletContext.attribute.factory"));

		OracleClientDAO clientDAO = (OracleClientDAO) factory.getClientDAO();

		String name = request.getParameter(ResourcerManager
				.getProperty("parameter.name"));
		String lastName = request.getParameter(ResourcerManager
				.getProperty("parameter.lastName"));
		String login = request.getParameter(ResourcerManager
				.getProperty("parameter.login"));
		String password = request.getParameter(ResourcerManager
				.getProperty("parameter.password"));
		String clientType = request.getParameter(ResourcerManager
				.getProperty("parameter.clientType"));
		int idClientType = Integer.parseInt(clientType);

		Client client = new Client();
		client.setName(name);
		client.setLastName(lastName);
		client.setLogin(login);
		client.setPassword(password);
		clientDAO.addClient(client, idClientType);

		List<Client> users = clientDAO.getAllClient();

		request.getSession().setAttribute(
				ResourcerManager.getProperty("parameter.usersList"), users);
		page.setUrl(ConfigurationManager.getProperty("path.page.viewUsers"));
		page.setType(TypeMethodEnum.SENDREDIRECT);
		return page;
	}
}
