package ru.rsreu.Zhilenko0804.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.Zhilenko0804.command.ActionCommand;
import ru.rsreu.Zhilenko0804.dao.DAOFactory;
import ru.rsreu.Zhilenko0804.data.*;
import ru.rsreu.Zhilenko0804.oracledb.OracleRequestDAO;
import ru.rsreu.Zhilenko0804.resourcer.ConfigurationManager;
import ru.rsreu.Zhilenko0804.resourcer.ResourcerManager;

public class ViewReportsFromConferenceCommand implements ActionCommand {

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

		int idConference = Integer.parseInt(request
				.getParameter(ResourcerManager
						.getProperty("parameter.idConference")));
		List<Request> reports = requestDAO
				.getReportsFromConference(idConference);

		request.getSession().setAttribute("reportsList", reports);

		page.setUrl(ConfigurationManager.getProperty("path.page.viewReport"));
		page.setType(TypeMethodEnum.FORWARD);
		return page;
	}

}
