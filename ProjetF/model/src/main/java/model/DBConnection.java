package model;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class DBConnection.
 *
 * @author Jean-Aymeric Diet
 */
final class DBConnection {
	/** The instance. */
	private static DBConnection	INSTANCE	= null;




	/** The connection. */
	private Connection					connection;




	/**
	 * Instantiates a new DB connection.
	 */
	public DBConnection() {
		this.open();
	}

	/**
	 * Gets the single instance of DBConnection.
	 *
	 * @return single instance of DBConnection
	 */
	public static synchronized DBConnection getInstance() {
		if (DBConnection.INSTANCE == null) {
			DBConnection.INSTANCE = new DBConnection();
		}
		return DBConnection.INSTANCE;
	}

	/**
	 * Open.
	 *
	 * @return the boolean
	 */
	final DBProperties dbProperties = new DBProperties();
	public Boolean open() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getLogin(), dbProperties.getPassword());
		} catch (final ClassNotFoundException e) {

			e.printStackTrace();
			return false;
		} catch (final SQLException e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("Successfully Connected");
		return true;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return this.connection;
	}
}