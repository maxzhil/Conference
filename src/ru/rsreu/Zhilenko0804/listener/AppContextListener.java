package ru.rsreu.Zhilenko0804.listener;

import java.sql.SQLException;

import javax.servlet.*;

import ru.rsreu.Zhilenko0804.dao.DAOFactory;
import ru.rsreu.Zhilenko0804.oracledb.OracleDBDAOFactory;
import ru.rsreu.Zhilenko0804.resourcer.MessageManager;

public class AppContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext ctx = servletContextEvent.getServletContext();

		DAOFactory factory;

		try {
			factory = OracleDBDAOFactory.getInstance();
			ctx.setAttribute("factory", factory);
			System.out.println(MessageManager
					.getProperty("message.openConnection"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext ctx = servletContextEvent.getServletContext();
		DAOFactory factory = (DAOFactory) ctx.getAttribute("factory");
		factory.closeConnection();
		System.out.println(MessageManager
				.getProperty("message.closeConnection"));

	}

}
