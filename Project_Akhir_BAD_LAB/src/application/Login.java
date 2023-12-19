package application;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login {
	
	//Scene
	Scene scene;
	// Panes
	BorderPane root;
	GridPane loginGridpane;
	// Menu Bars
    MenuBar menuBar;
    Menu menu;
    MenuItem loginMenuItem, registerMenuItem;
    // Login Scene
	Label labelLoginUsername, labelLoginPassword;
	TextField textfieldLoginUsername;
	PasswordField passwordFieldLogin;
	Button loginButton;
    // Replace username & passwords verification later
    String databaseUsername, databasePassword,databaseAccountType;
	Alert blankAlert, wrongPasswordAlert, invalidAlert;
	
	public void init() {
		// Panes
		root = new BorderPane();
		loginGridpane = new GridPane();
		
	    // Replace username & passwords verification later
	    databaseUsername = "Admin";
	    databasePassword = "Admin";
	    databaseAccountType = "Admin";
		
		// Initiate components
		labelLoginUsername = new Label("Username");
		labelLoginPassword = new Label("Password");
		textfieldLoginUsername = new TextField();;
		passwordFieldLogin = new PasswordField();;
		loginButton = new Button("Login");
		
		// Login page
		loginGridpane = new GridPane();
		loginGridpane.setPrefHeight(500);
		loginGridpane.setPrefWidth(750);
		loginGridpane.setVgap(10);
		loginGridpane.setHgap(10);
		loginGridpane.setAlignment(Pos.CENTER);
		loginGridpane.setPadding(new Insets(20, 20, 20, 20));
		GridPane.setMargin(loginGridpane, new Insets(20, 20, 20, 20));
		loginGridpane.add(labelLoginUsername, 0, 0);
		loginGridpane.add(textfieldLoginUsername, 0, 1);
		loginGridpane.add(labelLoginPassword, 0, 2);
		loginGridpane.add(passwordFieldLogin, 0, 3);
		loginGridpane.add(loginButton, 0, 4);
		textfieldLoginUsername.setPrefWidth(200);
		passwordFieldLogin.setPrefWidth(200);
		loginButton.setPrefWidth(100);
		
        // Menu Bar
		menuBar = new MenuBar();
		loginMenuItem = new MenuItem("Login");
		registerMenuItem = new MenuItem("Register");
		menu = new Menu("Menu");
        menu.getItems().addAll(loginMenuItem, registerMenuItem);
        menuBar.getMenus().add(menu);
		
        // Add panes to root
        root.setTop(menuBar);
        root.setCenter(loginGridpane);
        
		// Create scene
        scene = new Scene(root);
	}
	
	// Add modules behavior
	private void eventHandler(Stage stage) {
		// Menu Items
		loginMenuItem.setOnAction(e -> {
			// Nothing
		});
		registerMenuItem.setOnAction(e -> {
			// Fill Action Later
			stage.setScene(scene);
		});
		
		// Login Button
        loginButton.setOnAction(e -> {
        	// Obtain textfields data
            String username = textfieldLoginUsername.getText();
            String password = passwordFieldLogin.getText();
            // Alerts
    		blankAlert = new Alert(AlertType.WARNING, "Username and Password must be filled!");
    		wrongPasswordAlert = new Alert(AlertType.WARNING, "Wrong Username or Password!");
    		invalidAlert = new Alert(AlertType.ERROR, "Something unexpected occured!");
            
            if (username.isBlank() || password.isBlank()) {
				blankAlert.show();
			}
            else if (!username.equals(databaseUsername) || !username.equals(databasePassword)) {
            	wrongPasswordAlert.show();
			}
            else if (databaseAccountType.equals("User")) {
            	// Replace later
				System.out.println("User Stuff");
			}
            else if (databaseAccountType.equals("Admin")) {
            	// Replace later
				System.out.println("Admin Stuff");
			}
			else {
				// In case there are unexpected event
				invalidAlert.show();
			}
        });
	}
	
	public void show(Stage stage) {
		init();
		eventHandler(stage);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
        
        System.out.println("Show Login Page");
	}
}
