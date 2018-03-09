package ru.rsreu.Zhilenko0804.command;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.Zhilenko0804.command.ActionCommand;
import ru.rsreu.Zhilenko0804.data.*;
import ru.rsreu.Zhilenko0804.resourcer.ConfigurationManager;

public class EmptyCommand implements ActionCommand {

	public Page execute(HttpServletRequest request) {
		Page page = new Page();
		page.setType(TypeMethodEnum.FORWARD);
		page.setUrl(ConfigurationManager.getProperty("path.page.login"));
		return page;
	}
}
