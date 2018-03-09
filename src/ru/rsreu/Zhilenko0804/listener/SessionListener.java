package ru.rsreu.Zhilenko0804.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import ru.rsreu.Zhilenko0804.dao.DAOFactory;
import ru.rsreu.Zhilenko0804.data.Client;
import ru.rsreu.Zhilenko0804.oracledb.OracleClientDAO;
import ru.rsreu.Zhilenko0804.resourcer.ResourcerManager;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {

		HttpSession session = arg0.getSession();
		DAOFactory factory = (DAOFactory) session
				.getServletContext()
				.getAttribute(
						ResourcerManager
								.getProperty("servletContext.attribute.factory"));

		OracleClientDAO clientDAO = (OracleClientDAO) factory.getClientDAO();
		if (null != (Client) session.getAttribute("user")) {
			int idClient = ((Client) session.getAttribute("user"))
					.getIdClient();
			if (clientDAO.isLogged(idClient)) {
				clientDAO.logOut(idClient);
			}
		}

	}
}
