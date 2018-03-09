package ru.rsreu.Zhilenko0804.command;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.Zhilenko0804.command.ActionCommand;
import ru.rsreu.Zhilenko0804.data.Page;
import ru.rsreu.Zhilenko0804.data.TypeMethodEnum;
import ru.rsreu.Zhilenko0804.resourcer.ConfigurationManager;
import ru.rsreu.Zhilenko0804.resourcer.ResourcerManager;

public class AddRequestFormCommand implements ActionCommand {
	@Override
	public Page execute(HttpServletRequest request) {
		Page page = new Page();

		String nameConference = request.getParameter(ResourcerManager
				.getProperty("parameter.nameConference"));
		String idConference = request.getParameter(ResourcerManager
				.getProperty("parameter.idConference"));
		request.getSession().setAttribute(
				ResourcerManager.getProperty("parameter.nameConference"),
				nameConference);
		request.getSession().setAttribute(
				ResourcerManager.getProperty("parameter.idConference"),
				idConference);
		page.setUrl(ConfigurationManager.getProperty("path.page.addRequest"));
		page.setType(TypeMethodEnum.FORWARD);
		return page;
	}
}