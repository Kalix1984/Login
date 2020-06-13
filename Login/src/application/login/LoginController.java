package application.login;

import java.util.List;

import application.db.User;
import application.db.UsersHandler;
import application.db.files.FileHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController implements Authentication{
	@FXML 
	private Label statusLabel;
	
	@FXML
	private TextField usernameField;
	
	@FXML 
	private TextField passwordField;
	
	private List<User> users;
	
	public LoginController() {
		UsersHandler usersHandler = new FileHandler("src/application/db/files/users.txt");
		users = usersHandler.generateUsersList();
	}

	public void Login(ActionEvent event) {
		if (isAccessGranted()) {
			statusLabel.setText("Beléphet");
		} else {
			statusLabel.setText("Belépés megtagadva!");
		}
	}

	@Override
	public boolean isAccessGranted() {
		for (User user : users) {
			if (user.isActive() && usernameField.getText().equals(user.getName()) && passwordField.getText().equals(user.getPassword())){
				return true;
			}
		}
		
		return false;
	}
	
	
}
