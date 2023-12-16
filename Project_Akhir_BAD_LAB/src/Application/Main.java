package Application;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	Stage stage;
	Scene scene;
	BorderPane root;
	
	public void initLogInScene() {
		
		// Initialize modules
		root = new BorderPane();
		Label labelUsername = new Label("Username");
		Label labelPassword = new Label("Password");
		TextField textfieldUsername = new TextField();
		PasswordField passwordfield = new PasswordField();
		Button loginButton = new Button("Login");
		
		// Login page
		GridPane gridpane = new GridPane();
		gridpane.setPrefHeight(500);
		gridpane.setPrefWidth(750);
		gridpane.setVgap(10);
		gridpane.setHgap(10);
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setPadding(new Insets(20, 20, 20, 20));
		GridPane.setMargin(gridpane, new Insets(20, 20, 20, 20));
		
		// Insert modules
		gridpane.add(labelUsername, 0, 1);
		gridpane.add(textfieldUsername, 0, 2);
		gridpane.add(labelPassword, 0, 3);
		gridpane.add(passwordfield, 0, 4);
		gridpane.add(loginButton, 0, 5);
		
		// Adjust modules width
		textfieldUsername.setPrefWidth(250);
		passwordfield.setPrefWidth(250);
		loginButton.setPrefWidth(100);
		
		// Add modules behavior
        loginButton.setOnAction(e -> {
        	// Obtain textfields data
            String username = textfieldUsername.getText();
            String password = passwordfield.getText();
            
            // Replace username & passwords verification later
            String databaseUsername = "Admin";
            String databasePassword = "Admin";
            String databaseAccountType = "Admin";
            
            // Alerts
            Alert blankAlert = new Alert(AlertType.WARNING, "Username and Password must be filled!");
            Alert wrongPasswordAlert = new Alert(AlertType.WARNING, "Wrong Username or Password!");
            Alert invalidAlert = new Alert(AlertType.ERROR, "Something unexpected occured!");
            
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
				// Handling unexpected event
				invalidAlert.show();
			}
        });
		
        // Menu Bar
        MenuBar menuBar = new MenuBar();
       	Menu menu = new Menu("Page");
        MenuItem login = new MenuItem("Login");
        MenuItem register = new MenuItem("Register");

        menu.getItems().addAll(login, register);
        menuBar.getMenus().addAll(menu);
        
        // Add pane to root
        root.setTop(menuBar);
        root.setCenter(gridpane);
        
		// Create scene
		scene = new Scene(root, 750, 500);
	}
	
    private Scene initRegister() {
        HBox vbox = new HBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20));

        Label email = new Label("Email");
        Label password = new Label ("Password");
        Label age = new Label("age");
        Label confirm = new Label("Confirm Password");
        
        TextField emailfield = new TextField();
        PasswordField passwordfield = new PasswordField();
        PasswordField confirmfield = new PasswordField();
        Spinner <Integer> umr = new Spinner<>(1,100,1);
        
        VBox kiri = new VBox();
        kiri.getChildren().addAll(email, emailfield, password, passwordfield, 
        		confirm, confirmfield, age, umr);
        kiri.setSpacing(5);
        
        Label gender = new Label("Gender");
        Label negara = new Label ("Nationality");
        
        Button regis = new Button ("Register");
        RadioButton cwo = new RadioButton("Male");
        RadioButton cwe = new RadioButton("Female");
        ToggleGroup genderr = new ToggleGroup();
        cwo.setToggleGroup(genderr);
        cwe.setToggleGroup(genderr);
        
        ComboBox negaraa = new ComboBox();
        ObservableList<String> ya = negaraa.getItems();
        ya.add("Indonesia");
        ya.add("Malaysia");
        ya.add("Nigeria");
        ya.add("Papua Nugini");
        ya.add("Inggris");
        ya.add("Amerika");
        ya.add("Jepang");
        ya.add("Korea");
        ya.add("Kamboja");
        ya.add("Chile");
        ya.add("Filipina");
        ya.add("China");
        ya.add("Singapura");
        
        VBox kanan = new VBox ();
        kanan.getChildren().addAll(gender, cwo,cwe , negara, negaraa, regis);
        kanan.setSpacing(5);
        
        Menu menu = new Menu("Page");
        MenuBar menuBar = new MenuBar();
        MenuItem login = new MenuItem("Login");
        MenuItem register = new MenuItem("Register");

        menu.getItems().addAll(login, register);
        menuBar.getMenus().addAll(menu);

        HBox utama = new HBox();
        utama.getChildren().addAll(kiri,kanan);
        utama.setAlignment(Pos.CENTER);
        utama.setSpacing(50);
        BorderPane bp = new BorderPane();
        bp.setTop(menuBar);
        bp.setCenter(utama);

        return new Scene(bp, 750, 500);
    }
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start(Stage stage) throws Exception {
		initLogInScene();
		stage.setScene(scene);
		stage.setTitle("Login");
		stage.show();
	}

}