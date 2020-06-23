package application.login;

import java.util.List;

import application.db.User;
import application.db.UsersHandler;
import application.db.files.FileHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController implements Authentication{
	@FXML 
	private Label alertMessage;
	
	@FXML
	private TextField userNameField;
	
	@FXML 
	private TextField passwordField;
	
	private List<User> users;
	
	public LoginController() {
		UsersHandler usersHandler = new FileHandler("src/application/db/files/users.txt");
		users = usersHandler.generateUsersList();
	}

	public void login(ActionEvent event) {
		if (isAccessGranted()) {
			System.out.println("Beléphet");
			alertMessage.setVisible(false);
			
		} else {
			System.out.println("Belépés megtagadva!");
			reset();
		}
	}
	
	public void reset() {
		alertMessage.setVisible(true);
		passwordField.setText("");
	}

	@Override
	public boolean isAccessGranted() {
		for (User user : users) {
			if (user.isActive() && userNameField.getText().equals(user.getName()) && passwordField.getText().equals(user.getPassword())){
				return true;
			}
		}
		
		return false;
	}
	
	
}
