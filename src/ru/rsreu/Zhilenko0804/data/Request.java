package ru.rsreu.Zhilenko0804.data;

/**
 * Request
 * 
 * @author Maxim
 * 
 */
public class Request {
	private int idRequst;
	private Client client;
	private String nameReport;
	private Conference conference;

	/**
	 * Constructor
	 */
	public Request() {
	}

	public int getIdRequst() {
		return idRequst;
	}

	public void setIdRequst(int idRequst) {
		this.idRequst = idRequst;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(String name, String lastname) {
		this.client = new Client(name, lastname);
	}

	public String getNameReport() {
		return nameReport;
	}

	public void setnameReport(String nameReport) {
		this.nameReport = nameReport;
	}

	public Conference getConference() {
		return conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

}
