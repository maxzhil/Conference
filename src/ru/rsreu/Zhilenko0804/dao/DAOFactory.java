package ru.rsreu.Zhilenko0804.dao;

/**
 * Implementation of DAO Factory
 * 
 * @author Maxim
 * 
 */
public abstract class DAOFactory {

	/** Close connection */
	public abstract void closeConnection();

	/** Get connection for dao client */
	public abstract ClientDAO getClientDAO();

	/** Get connection for dao conference */
	public abstract ConferenceDAO getConferenceDAO();

	/** Get connection for dao request */
	public abstract RequestDAO getRequestDAO();
}
