package ru.rsreu.Zhilenko0804.data;

/**
 * Page
 * 
 * @author Maxim
 * 
 */
public class Page {

	private String url;
	private TypeMethodEnum type;

	/**
	 * Constructor
	 */
	public Page() {
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TypeMethodEnum getType() {
		return type;
	}

	public void setType(TypeMethodEnum type) {
		this.type = type;
	}

}
