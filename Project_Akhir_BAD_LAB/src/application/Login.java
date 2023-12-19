package application;


import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login extends Pages{
	// Panes
	GridPane gridpane;
    // Login Scene
	Label labelEmail, labelPassword;
	TextField usernameField;
	PasswordField passwordField;
	Button loginButton;
	// Alerts
	Alert blankAlert, wrongPasswordAlert, invalidAlert;
    // Replace username & passwords verification later
    String databaseEmail, databasePassword, databaseAccountType;
	
	protected void init() {
	    // Replace username & passwords verification later
	    databaseEmail = "Admin";
	    databasePassword = "Admin";
	    databaseAccountType = "Admin";
		// Initiate components
		labelEmail = new Label("Email");
		labelPassword = new Label("Password");
		usernameField = new TextField();
			usernameField.setPrefWidth(200);
		passwordField = new PasswordField();
			passwordField.setPrefWidth(200);
		loginButton = new Button("Login");
			loginButton.setPrefWidth(100);
		gridpane = new GridPane();
			gridpane.setPrefSize(750, 500);
			gridpane.setVgap(10);
			gridpane.setHgap(10);
			gridpane.setAlignment(Pos.CENTER);
			gridpane.add(labelEmail, 0, 0);
			gridpane.add(usernameField, 0, 1);
			gridpane.add(labelPassword, 0, 2);
			gridpane.add(passwordField, 0, 3);
			gridpane.add(loginButton, 0, 4);
		newScene(gridpane);
	}
	
	// Add modules behavior
	protected void eventHandler(Stage stage) {
		// Menu Items
		loginMenuItem.setOnAction(e -> {
			// Nothing
		});
		registerMenuItem.setOnAction(e -> {
			Register register = new Register();
			register.show(stage);
		});
		
		// Login Button
        loginButton.setOnAction(e -> {
        	// Obtain textfields data
            String username = usernameField.getText();
            String password = passwordField.getText();
            // Alerts
    		blankAlert = new Alert(AlertType.WARNING, "Email and Password must be filled!");
    		wrongPasswordAlert = new Alert(AlertType.WARNING, "Wrong Email or Password!");
    		invalidAlert = new Alert(AlertType.ERROR, "Something unexpected occured!");
            
            if (username.isBlank() || password.isBlank()) {
				blankAlert.show();
			}
            else if (!username.equals(databaseEmail) || !username.equals(databasePassword)) {
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
		initLandingPage();
		init();
		eventHandler(stage);
		stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
	}
}
