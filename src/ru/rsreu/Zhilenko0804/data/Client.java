package ru.rsreu.Zhilenko0804.data;

/**
 * Client
 * 
 * @author Maxim
 * 
 */
public class Client {
	private int idClient;
	private ClientType type;
	private String name;
	private String lastName;
	private String login;
	private String password;
	private String status;

	/** Constructor */
	public Client() {
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param lastName
	 */
	public Client(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;

	}

	/**
	 * Constructor
	 * 
	 * @param idClient
	 * @param type
	 * @param name
	 * @param lastName
	 * @param login
	 * @param password
	 * @param status
	 */
	public Client(int idClient, int type, String name, String lastName,
			String login, String password, String status) {
		this.idClient = idClient;
		this.type = new ClientType(type, name);
		this.name = name;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.status = status;
	}

	/**
	 * Constructor
	 * 
	 * @param idClient
	 * @param type
	 * @param name
	 * @param lastName
	 * @param login
	 * @param password
	 * @param status
	 */
	public Client(int idClient, String type, String name, String lastName,
			String login, String password, String status) {

		this.idClient = idClient;
		this.type = new ClientType(type);
		this.name = name;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.status = status;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ClientType getType() {
		return type;
	}

	public String getTypeString() {
		return type.toString();
	}

	public int getIdType() {
		return type.getIdClientType();
	}

	public void setType(String type) {
		this.type = new ClientType(type);
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", type=" + type + ", name="
				+ name + ", lastName=" + lastName + ", login=" + login
				+ ", password=" + password + ", status=" + status + "]";
	}

}
