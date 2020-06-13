package application.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
	@FXML 
	private Label statusLabel;
	
	@FXML
	private TextField usernameField;
	
	@FXML 
	private TextField passwordField;
	
	public void Login(ActionEvent event) {
		if (usernameField.getText().equals("user") && passwordField.getText().equals("pass")) {
			statusLabel.setText("Login success");
		} else {
			statusLabel.setText("Hibás felhasználó név vagy jelszó!");
		}
	}
	
	
}
