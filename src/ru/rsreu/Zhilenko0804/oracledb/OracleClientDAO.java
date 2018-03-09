package ru.rsreu.Zhilenko0804.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ru.rsreu.Zhilenko0804.dao.ClientDAO;
import ru.rsreu.Zhilenko0804.data.Client;
import ru.rsreu.Zhilenko0804.resourcer.SqlQueriesManager;

/**
 * Implementation of DAO for client
 * 
 * @author Maxim
 * 
 */
public class OracleClientDAO implements ClientDAO {
	/** connection to the database */
	private Connection connection = null;

	/**
	 * Constructor
	 * 
	 * @param connection
	 *            - connection to the database.
	 * 
	 * */
	public OracleClientDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Login to the system. Change of status to online
	 * 
	 * @param idClient
	 *            - Client code.
	 */
	@Override
	public void logIn(int idClient) {

		PreparedStatement ps = null;
		try {
			changeStatus(ps, idClient,
					SqlQueriesManager.getProperty("sql.logIn"));
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Sign Out. Status change offline.
	 * 
	 * @param idClient
	 *            - Client code.
	 */
	@Override
	public void logOut(int idClient) {

		PreparedStatement ps = null;
		try {
			changeStatus(ps, idClient,
					SqlQueriesManager.getProperty("sql.logOut"));
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Input Verification
	 * 
	 * @param idClient
	 *            - Client code.
	 * @return flag -In the system or not.
	 */
	@Override
	public boolean isLogged(int idClient) {
		boolean flag = false;
		String status = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(SqlQueriesManager
					.getProperty("sql.isLogged"));

			ps.setInt(1, idClient);
			rs = ps.executeQuery();
			while (rs.next()) {
				status = rs.getString("status");
			}
			if (!status.equals("online")) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	/**
	 * Client search for authorization
	 * 
	 * @param login
	 *            - Login.
	 * 
	 * @param password
	 *            - Password.
	 * @return client - Found client.
	 * */
	@Override
	public Client findClient(String login, String password) {
		Client client = new Client();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(SqlQueriesManager
					.getProperty("sql.findClientQueries"));

			ps.setString(1, login);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				buildClient(client, rs);
			}
		} catch (SQLClientInfoException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return client;
	}

	/**
	 * Getting a list of all users
	 * 
	 * @return clients - List of all users.
	 * */
	@Override
	public List<Client> getAllClient() {
		List<Client> clients = new ArrayList<Client>();

		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = connection.createStatement();
			rs = stmt.executeQuery(SqlQueriesManager
					.getProperty("sql.viewUserQueries"));
			while (rs.next()) {
				Client client = new Client();
				buildClient(client, rs);
				clients.add(client);
			}

		} catch (SQLClientInfoException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return clients;
	}

	/**
	 * Delete client.
	 * 
	 * @param idClient
	 *            - Client code.
	 * @return flag- Successful or not
	 */
	@Override
	public boolean deleteClient(int idClient) {

		boolean flag = false;
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(SqlQueriesManager
					.getProperty("sql.deleteUserQueries"));
			ps.setInt(1, idClient);
			ps.executeUpdate();
			flag = true;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return flag;
	}

	/**
	 * Adding a client to the database
	 * 
	 * @param client
	 *            - Client.
	 * @param idClientType
	 *            - Client type code.
	 * @return flag- Successful or not
	 */
	@Override
	public boolean addClient(Client client, int idClientType) {
		boolean flag = false;
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(SqlQueriesManager
					.getProperty("sql.addUserQueries"));
			ps.setInt(1, idClientType);
			ps.setString(2, client.getName());
			ps.setString(3, client.getLastName());
			ps.setString(4, client.getLogin());
			ps.setString(5, client.getPassword());
			ps.executeUpdate();
			flag = true;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return flag;
	}

	/**
	 * Build client from database
	 * 
	 * @param client
	 *            - Client
	 * @param rs
	 *            - ResulSet
	 * @throws SQLClientInfoException
	 * @throws SQLException
	 */
	private void buildClient(Client client, ResultSet rs) throws SQLException {
		client.setIdClient(rs.getInt("idClient"));
		client.setType(rs.getString("type"));
		client.setName(rs.getString("Name"));
		client.setLastName(rs.getString("LastName"));
		client.setLogin(rs.getString("Login"));
		client.setPassword(rs.getString("Password"));
		client.setStatus(rs.getString("Status"));

	}

	/**
	 * Change status
	 * 
	 * @param ps
	 *            -Prepared statement
	 * @param idClient
	 *            - Client code.
	 * @param sqlQuery
	 *            - sql query for change status.
	 * @throws SQLException
	 */
	private void changeStatus(PreparedStatement ps, int idClient,
			String sqlQuery) throws SQLException {
		ps = connection.prepareStatement(sqlQuery);
		ps.setInt(1, idClient);
		ps.executeUpdate();
	}
}
