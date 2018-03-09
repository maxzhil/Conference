package ru.rsreu.Zhilenko0804.FrontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.rsreu.Zhilenko0804.command.ActionCommand;
import ru.rsreu.Zhilenko0804.command.factory.ActionFactory;
import ru.rsreu.Zhilenko0804.data.Page;
import ru.rsreu.Zhilenko0804.data.TypeMethodEnum;
import ru.rsreu.Zhilenko0804.resourcer.ConfigurationManager;
import ru.rsreu.Zhilenko0804.resourcer.MessageManager;

/**
 * Controller
 * 
 * @author Maxim
 * 
 */
public class FrontController extends HttpServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Process Request.
	 * 
	 * @param request
	 * 
	 * @param response
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Page page = null;

		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);

		page = command.execute(request);

		if (page.getUrl() != null) {
			if (page.getType() == TypeMethodEnum.FORWARD) {
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(page.getUrl());

				dispatcher.forward(request, response);
			}
			if (page.getType() == TypeMethodEnum.SENDREDIRECT) {
				response.sendRedirect(request.getContextPath() + page.getUrl());
			}
		} else {

			page.setUrl(ConfigurationManager.getProperty("path.page.index"));
			request.getSession().setAttribute("nullPage",
					MessageManager.getProperty("message.nullpage"));
			response.sendRedirect(request.getContextPath() + page);

		}
	}
}
