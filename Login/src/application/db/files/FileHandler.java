package application.db.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.db.User;
import application.db.UsersHandler;

public class FileHandler implements UsersHandler{
	private String url;

	public FileHandler(String url) {
		this.url = url;
	}
	
	@Override
	public List<User> generateUsersList() {
		List<User> users = new ArrayList<>();

		try {
			File file = new File(url);
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] userData = line.split(";");
				users.add(new User(userData[0], userData[1], Boolean.parseBoolean(userData[2])));
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("File nem található!");
		}

		return users;
	}
}
