package ru.rsreu.Zhilenko0804.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.Zhilenko0804.command.ActionCommand;
import ru.rsreu.Zhilenko0804.dao.DAOFactory;
import ru.rsreu.Zhilenko0804.data.*;
import ru.rsreu.Zhilenko0804.oracledb.OracleClientDAO;
import ru.rsreu.Zhilenko0804.resourcer.ConfigurationManager;
import ru.rsreu.Zhilenko0804.resourcer.ResourcerManager;

public class ViewUsersCommand implements ActionCommand {

	@Override
	public Page execute(HttpServletRequest request) {
		Page page = new Page();
		DAOFactory factory = (DAOFactory) request
				.getServletContext()
				.getAttribute(
						ResourcerManager
								.getProperty("servletContext.attribute.factory"));

		OracleClientDAO clientDAO = (OracleClientDAO) factory.getClientDAO();

		List<Client> users = clientDAO.getAllClient();

		request.getSession().setAttribute("usersList", users);

		page.setUrl(ConfigurationManager.getProperty("path.page.viewUsers"));
		page.setType(TypeMethodEnum.FORWARD);
		return page;
	}

}
