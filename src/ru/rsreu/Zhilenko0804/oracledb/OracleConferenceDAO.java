package ru.rsreu.Zhilenko0804.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import ru.rsreu.Zhilenko0804.dao.ConferenceDAO;
import ru.rsreu.Zhilenko0804.data.Conference;
import ru.rsreu.Zhilenko0804.resourcer.SqlQueriesManager;

/**
 * Implementation of DAO for conference
 * 
 * @author Maxim
 * 
 */
public class OracleConferenceDAO implements ConferenceDAO {
	/** Code of current conferences */
	private static final int ID_ACTUAL_CONFERENCE = 1;
	/** Code of the creator of conferences */
	private static final int ID_CREATOR_CONFERENCE = 1;
	/** connection to the database */
	private Connection connection = null;

	/**
	 * Constructor
	 * 
	 * @param connection
	 *            - connection to the database.
	 * 
	 * */
	public OracleConferenceDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Getting a list of conferences
	 * 
	 * @param typeDateConference
	 *            - Conference Date Type.
	 * 
	 * 
	 * @return conferences- List of conferences.
	 * */
	@Override
	public List<Conference> getConference(int typeDateConference) {
		List<Conference> conferences = new ArrayList<Conference>();

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = connection.createStatement();
			if (typeDateConference == ID_ACTUAL_CONFERENCE) {
				rs = stmt.executeQuery(SqlQueriesManager
						.getProperty("sql.viewActualConference"));
			} else {
				rs = stmt.executeQuery(SqlQueriesManager
						.getProperty("sql.viewPastConference"));
			}

			while (rs.next()) {
				Conference conference = new Conference();
				buildConference(conference, rs);
				/*
				 * conference.setIdConference(rs.getInt("idConference"));
				 * conference.setNameConference(rs.getString("nameConference"));
				 * conference.setDate(rs.getTimestamp("dateconference"));
				 * conference.setCity(rs.getString("city"));
				 * conference.setCountReport(rs.getInt("reports"));
				 */
				conferences.add(conference);

			}
		} catch (SQLClientInfoException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return conferences;
	}

	/**
	 * Getting the list of moderator's conferences
	 * 
	 * @param typeDateConference
	 *            - Conference Date Type..
	 * @param idModerator
	 *            - Moderator code.
	 * @param typeCreator
	 *            - Type, defines the output of conferences of all moderators or
	 *            current moderator
	 * 
	 * @return conferences- list of conferences.
	 * */
	@Override
	public List<Conference> getConferenceModerator(int typeDateConference,
			int idModerator, int typeCreator) {
		List<Conference> conferences = new ArrayList<Conference>();
		PreparedStatement ps = null;

		ResultSet rs = null;

		try {

			if (typeDateConference == ID_ACTUAL_CONFERENCE
					&& typeCreator == ID_CREATOR_CONFERENCE) {
				ps = connection.prepareStatement(SqlQueriesManager
						.getProperty("sql.viewActualMyConference"));
				ps.setInt(1, idModerator);
				ps.executeQuery();
				rs = ps.executeQuery();
			} else if (typeDateConference != ID_ACTUAL_CONFERENCE
					&& typeCreator == ID_CREATOR_CONFERENCE) {
				ps = connection.prepareStatement(SqlQueriesManager
						.getProperty("sql.viewPastMyConference"));
				ps.setInt(1, idModerator);
				ps.executeQuery();
				rs = ps.executeQuery();
			} else if (typeDateConference == ID_ACTUAL_CONFERENCE
					&& typeCreator != ID_CREATOR_CONFERENCE) {
				ps = connection.prepareStatement(SqlQueriesManager
						.getProperty("sql.viewActualAllConference"));
				ps.executeQuery();
				rs = ps.executeQuery();

			} else if (typeDateConference != ID_ACTUAL_CONFERENCE
					&& typeCreator != ID_CREATOR_CONFERENCE) {
				ps = connection.prepareStatement(SqlQueriesManager
						.getProperty("sql.viewPastAllConference"));

				ps.executeQuery();
				rs = ps.executeQuery();
			}

			while (rs.next()) {
				Conference conference = new Conference();
				buildConference(conference, rs);
				/*
				 * conference.setIdConference(rs.getInt("idConference"));
				 * conference.setNameConference(rs.getString("nameConference"));
				 * conference.setDate(rs.getTimestamp("dateconference"));
				 * conference.setCity(rs.getString("city"));
				 * conference.setCountReport(rs.getInt("reports"));
				 */
				conferences.add(conference);

			}
		} catch (SQLClientInfoException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return conferences;
	}

	/**
	 * Delete conference
	 * 
	 * @param idConference
	 *            - Code conference.
	 * @param idClient
	 *            - To check whether the current moderator is the creator
	 *            conferences.
	 * @return flag- Successful or not.
	 */
	@Override
	public boolean deleteConference(int idConference, int idClient) {
		boolean flag = false;
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(SqlQueriesManager
					.getProperty("sql.deleteConference"));
			ps.setInt(1, idConference);
			ps.setInt(2, idClient);
			ps.executeUpdate();
			flag = true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * Adding a conference to the database
	 * 
	 * @param idClient
	 *            - Client code.
	 * 
	 * @param nameConference
	 *            - Name conference.
	 * @param date
	 *            - Date.
	 * @param city
	 *            - City.
	 * @return flag- Successful or not.
	 */
	@Override
	public boolean addConference(int idClient, String nameConference,
			String date, String city) {
		boolean flag = false;
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(SqlQueriesManager
					.getProperty("sql.createConference"));
			ps.setInt(1, idClient);
			ps.setString(2, nameConference);
			ps.setString(3, date);
			ps.setString(4, city);
			ps.executeUpdate();
			flag = true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * Build conference from database
	 * 
	 * @param conference
	 *            - Conference
	 * @param rs
	 *            - ResulSet
	 * @throws SQLException
	 */
	private void buildConference(Conference conference, ResultSet rs)
			throws SQLException {
		conference.setIdConference(rs.getInt("idConference"));
		conference.setNameConference(rs.getString("nameConference"));
		conference.setDate(rs.getTimestamp("dateconference"));
		conference.setCity(rs.getString("city"));
		conference.setCountReport(rs.getInt("reports"));
	}

}
