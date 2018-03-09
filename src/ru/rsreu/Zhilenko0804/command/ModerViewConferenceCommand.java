package ru.rsreu.Zhilenko0804.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.Zhilenko0804.command.ActionCommand;
import ru.rsreu.Zhilenko0804.dao.DAOFactory;
import ru.rsreu.Zhilenko0804.data.*;
import ru.rsreu.Zhilenko0804.oracledb.OracleConferenceDAO;
import ru.rsreu.Zhilenko0804.resourcer.ConfigurationManager;
import ru.rsreu.Zhilenko0804.resourcer.ResourcerManager;

public class ModerViewConferenceCommand implements ActionCommand {

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
		int idDateTypeConference = Integer.parseInt(request
				.getParameter(ResourcerManager
						.getProperty("parameter.dateTypeConference")));
		int idModerator = Integer.parseInt(request
				.getParameter(ResourcerManager
						.getProperty("parameter.idModerator")));
		int typeCreator = Integer.parseInt(request
				.getParameter(ResourcerManager
						.getProperty("parameter.myConference")));
		List<Conference> conference = conferenceDAO.getConferenceModerator(
				idDateTypeConference, idModerator, typeCreator);

		request.getSession().setAttribute("conferenceList", conference);
		page.setUrl(ConfigurationManager.getProperty("path.page.viewModerator"));
		page.setType(TypeMethodEnum.FORWARD);
		return page;
	}
}
