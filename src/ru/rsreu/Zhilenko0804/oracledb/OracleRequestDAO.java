package ru.rsreu.Zhilenko0804.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.rsreu.Zhilenko0804.dao.RequestDAO;
import ru.rsreu.Zhilenko0804.data.Request;
import ru.rsreu.Zhilenko0804.resourcer.SqlQueriesManager;

/**
 * Implementation of DAO for request
 * 
 * @author Maxim
 * 
 */
public class OracleRequestDAO implements RequestDAO {
	/** Connection to the database */
	private Connection connection = null;

	/**
	 * Constructor
	 * 
	 * @param connection
	 *            - connection to the database.
	 * 
	 * */
	public OracleRequestDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Getting the list of reports from conferences
	 * 
	 * @param idConference
	 *            - Conference code.
	 * @return requests - List of requests.
	 */
	@Override
	public List<Request> getReportsFromConference(int idConference) {
		List<Request> requests = new ArrayList<Request>();
		try {
			PreparedStatement ps = connection
					.prepareStatement(SqlQueriesManager
							.getProperty("sql.viewReports"));
			ps.setInt(1, idConference);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Request request = new Request();
				request.setClient(rs.getString("Name"),
						rs.getString("LastName"));
				request.setnameReport(rs.getString("nameReport"));
				requests.add(request);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return requests;
	}

	/**
	 * Create request
	 * 
	 * @param idClient
	 *            - Client code.
	 * @param idConference
	 *            - Conference code.
	 * @param nameReport
	 *            - Name report.
	 * @return flag- Successful or not
	 */
	@Override
	public boolean createRequest(int idClient, String nameReport,
			int idConference) {
		boolean flag = false;
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(SqlQueriesManager
					.getProperty("sql.addRequest"));
			ps.setInt(1, idClient);
			ps.setString(2, nameReport);
			ps.setInt(3, idConference);

			ps.executeUpdate();
			flag = true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}

}
