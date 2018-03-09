package ru.rsreu.Zhilenko0804.dao;

import java.util.List;

import ru.rsreu.Zhilenko0804.data.Client;

/**
 * Client DAO
 * 
 * @author Maxim
 * 
 */
public interface ClientDAO {
	/**
	 * Login to the system. Change of status to online
	 * 
	 * @param idClient
	 *            - Client code.
	 */
	void logIn(int idClient);

	/**
	 * Sign Out. Status change offline.
	 * 
	 * @param idClient
	 *            - Client code.
	 */
	void logOut(int idClient);

	/**
	 * Input Verification
	 * 
	 * @param idClient
	 *            - Client code.
	 * @return flag -In the system or not.
	 */
	boolean isLogged(int idClient);

	/**
	 * Client search for authorization
	 * 
	 * @param login
	 *            - Login.
	 * 
	 * @param password
	 *            - Password.
	 * @return client - Found client.
	 */
	public Client findClient(String login, String password);

	/**
	 * Getting a list of all users
	 * 
	 * @return clients - List of all users.
	 */
	public List<Client> getAllClient();

	/**
	 * Delete client.
	 * 
	 * @param idClient
	 *            - Client code.
	 * @return flag- Successful or not
	 */
	public boolean deleteClient(int idClient);

	/**
	 * Adding a client to the database
	 * 
	 * @param client
	 *            - Client.
	 * @param idClientType
	 *            - Client type code.
	 * @return flag- Successful or not
	 */
	public boolean addClient(Client client, int idClientType);
}
