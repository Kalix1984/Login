package application.login;

import java.io.IOException;
import java.util.List;

import application.db.User;
import application.db.UsersHandler;
import application.db.files.FileHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class LoginController implements Authentication{
	@FXML 
	private BorderPane rootPane;
	
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

	public void login(ActionEvent event) throws IOException {
		if (isAccessGranted()) {
			loadMain();
		} else {
			System.out.println("Belépés megtagadva!");
			reset();
		}
	}
	
	public void loadMain() throws IOException {
		Parent MainRoot = FXMLLoader.load(getClass().getResource("Main.fxml"));
		rootPane.getChildren().setAll(MainRoot);
		
	}
	
	private void reset() {
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
