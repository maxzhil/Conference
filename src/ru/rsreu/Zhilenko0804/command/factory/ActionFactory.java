package ru.rsreu.Zhilenko0804.command.factory;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.Zhilenko0804.command.ActionCommand;
import ru.rsreu.Zhilenko0804.command.EmptyCommand;
import ru.rsreu.Zhilenko0804.command.Enum.CommandEnum;
import ru.rsreu.Zhilenko0804.resourcer.MessageManager;
import ru.rsreu.Zhilenko0804.resourcer.ResourcerManager;

public class ActionFactory {
	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommand();

		String action = request.getParameter(ResourcerManager
				.getProperty("parameter.command"));
		if (action == null || action.isEmpty()) {

			return current;
		}

		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());

			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute(
					ResourcerManager.getProperty("parameter.wrongAction"),
					action + MessageManager.getProperty("message.wrongaction"));
		}
		return current;
	}
}