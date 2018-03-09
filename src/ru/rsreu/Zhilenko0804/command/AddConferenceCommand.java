package ru.rsreu.Zhilenko0804.command;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.Zhilenko0804.command.ActionCommand;
import ru.rsreu.Zhilenko0804.dao.DAOFactory;
import ru.rsreu.Zhilenko0804.data.*;
import ru.rsreu.Zhilenko0804.oracledb.OracleConferenceDAO;
import ru.rsreu.Zhilenko0804.resourcer.ConfigurationManager;
import ru.rsreu.Zhilenko0804.resourcer.ResourcerManager;

public class AddConferenceCommand implements ActionCommand {

	@Override
	public Page execute(HttpServletRequest request) {
		Page page = new Page();
		DAOFactory factory = (DAOFactory) request
				.getServletContext()
				.getAttribute(
						ResourcerManager
								.getProperty("servletContext.attribute.factory"));

		OracleConferenceDAO conferenceDAO = (OracleConferenceDAO) factory
				.getConferenceDAO();
		int idClient = Integer.parseInt(request.getParameter(ResourcerManager
				.getProperty("parameter.idClient")));

		String nameConference = request.getParameter(ResourcerManager
				.getProperty("parameter.nameConference"));
		String city = request.getParameter(ResourcerManager
				.getProperty("parameter.city"));
		String date = request.getParameter(ResourcerManager
				.getProperty("parameter.date"));

		conferenceDAO.addConference(idClient, nameConference, date, city);

		page.setType(TypeMethodEnum.SENDREDIRECT);
		page.setUrl(ConfigurationManager.getProperty("path.page.viewModerator"));
		return page;
	}

}
