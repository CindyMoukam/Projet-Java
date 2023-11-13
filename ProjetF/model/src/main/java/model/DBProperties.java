package model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The Class DBProperties.
 *
 * @author Jean-Aymeric Diet
 */
public class DBProperties extends Properties {


	/** The Constant serialVersionUID. */
	private static final long		serialVersionUID			= 5289057445894568927L;

	/** The Constant PROPERTIES_FILE_NAME. */
	private final static String	PROPERTIES_FILE_NAME	= "model.properties";

	/** The url. */
	private  String		url				= "jdbc:postgresql://localhost:5432/javapetri?autoReconnect=true&useSSL=false&maxReconnects=10";

	/** The login. */

	private  String		login			= "postgres";

	/** The password. */
	private String		password		= "Mgm+02C";

	/**
	 * Instantiates a new DB properties.
	 */
	public DBProperties() {
		InputStream inputStream;

		inputStream = this.getClass().getClassLoader().getResourceAsStream(DBProperties.PROPERTIES_FILE_NAME);

		if (inputStream != null) {
			try {
				this.load(inputStream);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			this.setUrl(url);
			this.setLogin(login);
			this.setPassword(password);
		}
	}


	public String getProperty(){
		return this.url;

	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {

		return this.url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url
	 *          the new url
	 */
	private void setUrl(final String url) {
		this.url = url;
	}

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login
	 *          the new login
	 */
	private void setLogin(final String login) {

		this.login = login;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {

		return this.password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *          the new password
	 */
	private void setPassword(final String password) {

		this.password = password;
	}

}