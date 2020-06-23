package application.db;

public class User {
	private String name;
	private String password;
	private boolean isActive;
	
	public User(String name, String password, boolean isActive) {
		this.name = name;
		this.password = password;
		this.isActive = isActive;
	}

	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean isActive() {
		return isActive;
	}

	@Override
	public String toString() {
		return name + " - " + password + " - " + isActive;
	}
	
	
	
}
