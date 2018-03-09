package ru.rsreu.Zhilenko0804.oracledb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

import ru.rsreu.Zhilenko0804.dao.*;

/**
 * Implementation of DAO Factory
 * 
 * @author Maxim
 * 
 */
public class OracleDBDAOFactory extends DAOFactory {
	/** Factory instance */
	private static volatile OracleDBDAOFactory instance;
	/** Connection to the database */
	private Connection connection;

	/** Constructor */
	private OracleDBDAOFactory() {
	}

	/** Close connection */
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Get instance factory
	 * 
	 * @return factory
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static OracleDBDAOFactory getInstance()
			throws ClassNotFoundException, SQLException {
		OracleDBDAOFactory factory = instance;
		if (instance == null) {
			synchronized (OracleDBDAOFactory.class) {
				instance = factory = new OracleDBDAOFactory();
				factory.connected();
			}
		}
		return factory;
	}

	/**
	 * Connected
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void connected() throws ClassNotFoundException, SQLException {
		Locale.setDefault(Locale.ENGLISH);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "user1";
		String password = "user";
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		connection = DriverManager.getConnection(url, user, password);
		System.out.println("Connected to oracle DB!");
	}

	/** Get connection for dao client */
	@Override
	public ClientDAO getClientDAO() {
		return new OracleClientDAO(connection);
	}

	/** Get connection for dao conference */
	@Override
	public ConferenceDAO getConferenceDAO() {
		return new OracleConferenceDAO(connection);
	}

	/** Get connection for dao request */
	@Override
	public RequestDAO getRequestDAO() {
		return new OracleRequestDAO(connection);
	}
}
