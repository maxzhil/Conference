package ru.rsreu.Zhilenko0804.command;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.Zhilenko0804.data.Page;

public interface ActionCommand {
	Page execute(HttpServletRequest request);
}