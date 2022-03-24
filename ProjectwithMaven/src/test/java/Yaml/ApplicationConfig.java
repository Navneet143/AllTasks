package Yaml;

public class ApplicationConfig {
	public ApplicationConfig() {
	}

	private String author;
	private DatabaseConfig database;
	private String version;

	public ApplicationConfig(String author, DatabaseConfig database, String version) {
		this.author = author;
		this.database = database;
		this.version= version;
	}

    public String getAuthor() {
        return author;
    }
//    public void setAuthor(String author) {
//        this.author = author;
//    }
    public DatabaseConfig getDatabase() {
        return database;
    }
//    public void setDatabase(DatabaseConfig database) {
//        this.database = database;
//    }
    public String getVersion() {
        return version;
    }
	@Override
	public String toString() {
		return "\nAuthor: " + author + "\ndatabase: " + database +"\nVersion: "+version;
	}
}

class DatabaseConfig {
	private String driver;
	private Integer port;
	private String dbname;
	private String username;
	private String password;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "\n\tDriver: " + driver + "\n\tport: " + port + "\n\tdbname: " + dbname + "\n\tusername: " + username
				+ "\n\tpassword: " + password;
	}

}