package ru.rsreu.Zhilenko0804.command;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.Zhilenko0804.command.ActionCommand;
import ru.rsreu.Zhilenko0804.dao.DAOFactory;
import ru.rsreu.Zhilenko0804.data.Page;
import ru.rsreu.Zhilenko0804.data.TypeMethodEnum;
import ru.rsreu.Zhilenko0804.oracledb.OracleRequestDAO;
import ru.rsreu.Zhilenko0804.resourcer.ConfigurationManager;
import ru.rsreu.Zhilenko0804.resourcer.ResourcerManager;

public class AddRequestCommand implements ActionCommand {

	@Override
	public Page execute(HttpServletRequest request) {
		Page page = new Page();
		DAOFactory factory = (DAOFactory) request
				.getServletContext()
				.getAttribute(
						ResourcerManager
								.getProperty("servletContext.attribute.factory"));
		OracleRequestDAO requestDAO = (OracleRequestDAO) factory
				.getRequestDAO();

		String nameReport = request.getParameter(ResourcerManager
				.getProperty("parameter.nameReport"));
		int idConference = Integer.parseInt(request
				.getParameter(ResourcerManager
						.getProperty("parameter.idConference")));
		int idClient = Integer.parseInt(request.getParameter(ResourcerManager
				.getProperty("parameter.idClient")));

		requestDAO.createRequest(idClient, nameReport, idConference);

		page.setUrl(ConfigurationManager
				.getProperty("path.page.viewConference"));
		page.setType(TypeMethodEnum.SENDREDIRECT);
		return page;
	}

}
