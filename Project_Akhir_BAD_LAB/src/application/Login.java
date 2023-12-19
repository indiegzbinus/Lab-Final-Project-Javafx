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

public class Login extends Pages{
	// Panes
	GridPane gridpane;
    // Login Scene
	Label labelLoginUsername, labelLoginPassword;
	TextField textfieldLoginUsername;
	PasswordField passwordFieldLogin;
	Button loginButton;
    // Replace username & passwords verification later
    String databaseUsername, databasePassword,databaseAccountType;
	Alert blankAlert, wrongPasswordAlert, invalidAlert;
	
	protected void init() {
		// Panes
		root = new BorderPane();
		gridpane = new GridPane();
		
	    // Replace username & passwords verification later
	    databaseUsername = "Admin";
	    databasePassword = "Admin";
	    databaseAccountType = "Admin";
		
		// Initiate components
		labelLoginUsername = new Label("Username");
		labelLoginPassword = new Label("Password");
		textfieldLoginUsername = new TextField();
		passwordFieldLogin = new PasswordField();
		loginButton = new Button("Login");
		
		// Login page
		gridpane = new GridPane();
		gridpane.setPrefHeight(500);
		gridpane.setPrefWidth(750);
		gridpane.setVgap(10);
		gridpane.setHgap(10);
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setPadding(new Insets(20, 20, 20, 20));
		GridPane.setMargin(gridpane, new Insets(20, 20, 20, 20));
		gridpane.add(labelLoginUsername, 0, 0);
		gridpane.add(textfieldLoginUsername, 0, 1);
		gridpane.add(labelLoginPassword, 0, 2);
		gridpane.add(passwordFieldLogin, 0, 3);
		gridpane.add(loginButton, 0, 4);
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
        root.setCenter(gridpane);
        
        // Set root size
        root.setPrefHeight(500);
        root.setPrefWidth(750);
        
		// Create scene
        scene = new Scene(root);
	}
	
	// Add modules behavior
	protected void eventHandler(Stage stage) {
		// Menu Items
		loginMenuItem.setOnAction(e -> {
			// Nothing
		});
		registerMenuItem.setOnAction(e -> {
			// Fill Action Later
			Register register = new Register();
			register.show(stage);
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
            else {
            	switch (databaseAccountType) {
				case "User":
					System.out.println("User Stuff");
					break;
				case "Admin":
					System.out.println("Admin Stuff");
					break;
				default:
					invalidAlert.show();
					break;
				}
            }
        });
	}
	
	public void show(Stage stage) {
		init();
		eventHandler(stage);
		stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
	}
}
