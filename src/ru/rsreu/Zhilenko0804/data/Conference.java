package ru.rsreu.Zhilenko0804.data;

import java.sql.Timestamp;

/**
 * Conference
 * 
 * @author Maxim
 * 
 */
public class Conference {

	private int idConference;
	private Client client;
	private String nameConference;
	private Timestamp date;
	private String city;
	private int countReport;

	/**
	 * Constructor
	 */
	public Conference() {
	}

	public int getCountReport() {
		return countReport;
	}

	public void setCountReport(int countReport) {
		this.countReport = countReport;
	}

	public int getIdConference() {
		return idConference;
	}

	public void setIdConference(int idConference) {
		this.idConference = idConference;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getNameConference() {
		return nameConference;
	}

	public void setNameConference(String nameConference) {
		this.nameConference = nameConference;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp timestamp) {
		this.date = timestamp;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Conference [idConference=" + idConference + ", client="
				+ client + ", nameConference=" + nameConference + ", date="
				+ date + ", city=" + city + "]";
	}

}
