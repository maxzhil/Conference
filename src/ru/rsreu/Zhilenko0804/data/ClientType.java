package ru.rsreu.Zhilenko0804.data;

/**
 * Client type
 * 
 * @author Maxim
 * 
 */
public class ClientType {
	private int idClientType;
	private String type;

	/**
	 * Constructor
	 * 
	 * @param type
	 */
	public ClientType(String type) {
		this.type = type;
	}

	/**
	 * Constructor
	 * 
	 * @param idClientType
	 * @param type
	 */
	public ClientType(int idClientType, String type) {
		this.idClientType = idClientType;
		this.type = type;
	}

	public int getIdClientType() {
		return idClientType;
	}

	public void setIdClientType(int idClientType) {
		this.idClientType = idClientType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}

}
