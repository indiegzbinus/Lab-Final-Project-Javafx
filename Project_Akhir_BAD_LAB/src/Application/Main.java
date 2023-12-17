package Application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	Stage window;
	Scene loginScene, registerScene;
	
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
	
	// Register Scene
	HBox registerHBox;
	VBox registerVBox1, registerVBox2;
	Label labelRegisterUsername, labelRegisterPassword, labelRegisterConfirmPassword, labelAge, labelGender, labelNationality;
	TextField textfieldLoginRegister;
	PasswordField passwordFieldRegister, passwordFieldConfirmRegister;
	Spinner<Integer> ageSpinner;
	RadioButton maleRadioButton, femaleRadioButton;
	ComboBox<String> nationalityComboBox;
	Button registerButton;
	
	public void init() {
		// Panes
		root = new BorderPane();
		loginGridpane = new GridPane();
		
		// Menu Bars
	    menuBar = new MenuBar();
	    menu = new Menu("Page");
	    loginMenuItem = new MenuItem("Login");
	    registerMenuItem = new MenuItem("Register");
		
	    // Login Scene
		labelLoginUsername = new Label("Username");
		labelLoginPassword = new Label("Password");
		textfieldLoginUsername = new TextField();;
		passwordFieldLogin = new PasswordField();;
		loginButton = new Button("Login");
	    // Replace username & passwords verification later
	    databaseUsername = "Admin";
	    databasePassword = "Admin";
	    databaseAccountType = "Admin";

		// Register Scene
		registerHBox = new HBox();
		registerVBox1 = new VBox();
		registerVBox2 = new VBox();
		labelRegisterUsername = new Label("Username");
		labelRegisterPassword = new Label("Password");
		labelRegisterConfirmPassword = new Label("Confirm Password"); 
		labelAge = new Label("Age");
		labelGender = new Label("Gender");
		labelNationality = new Label("Nationality");
		textfieldLoginRegister = new TextField();
		passwordFieldRegister = new PasswordField();
		passwordFieldConfirmRegister = new PasswordField();;
		ageSpinner = new Spinner<Integer>();
		maleRadioButton = new RadioButton("Male");
		femaleRadioButton = new RadioButton("Female");;
		nationalityComboBox = new ComboBox<String>();
		registerButton = new Button("Register");
		
		// Menu Button Event
		loginMenuItem.setOnAction(e -> {
			LogIn();
			window.setScene(loginScene);
			window.show();
		});
		
		registerButton.setOnAction(e -> {
			Register();
			window.setScene(registerScene);
			window.show();
		});
		
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
		
		// Register page
		registerHBox.setPrefHeight(100);
		registerHBox.setPrefWidth(300);
		registerHBox.setSpacing(20);
		registerHBox.setAlignment(Pos.CENTER);
		registerHBox.setPadding(new Insets(20, 20, 20, 20));
		HBox.setMargin(registerHBox, new Insets(20, 20, 20, 20));
	}
	
	private void LogIn() {
		// Add modules behavior
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
        
        // Menu Bar
        menu.getItems().addAll(loginMenuItem, registerMenuItem);
        menuBar.getMenus().addAll(menu);
        
        // Add panes to root
        root.setTop(menuBar);
        root.setCenter(loginGridpane);
        
		// Create scene
        loginScene = new Scene(root);
        window.setTitle("Login");
	}
	
	private void Register() {
		registerVBox1.getChildren().addAll(labelRegisterUsername, textfieldLoginUsername, labelRegisterPassword, passwordFieldRegister, 
				labelRegisterConfirmPassword, passwordFieldConfirmRegister, labelAge, ageSpinner);
		registerVBox2.getChildren().addAll(labelGender, maleRadioButton, femaleRadioButton, nationalityComboBox, registerButton);
		
		registerHBox.getChildren().addAll(registerVBox1, registerVBox2);
		
        // Menu Bar
        menu.getItems().addAll(loginMenuItem, registerMenuItem);
        menuBar.getMenus().addAll(menu);
		
        // Add panes to root
        root.setTop(menuBar);
        root.setCenter(registerHBox);
        
        // Create scene
        registerScene = new Scene(root);
        window.setTitle("Register");
	}

	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start(Stage stage) throws Exception {
		window = stage;
		init();
		LogIn();
		stage.setResizable(false);
		stage.setScene(loginScene);
		stage.setTitle("Login");
		stage.show();
	}
}

//private Scene Register() {
//HBox vbox = new HBox();
//vbox.setSpacing(10);
//vbox.setPadding(new Insets(20));
//
//TextField emailfield = new TextField();
//PasswordField passwordfield = new PasswordField();
//PasswordField confirmfield = new PasswordField();
//Spinner <Integer> umr = new Spinner<>(1,100,1);
//
//VBox kiri = new VBox();
//kiri.getChildren().addAll(email, emailfield, password, passwordfield, 
//		confirm, confirmfield, age, umr);
//kiri.setSpacing(5);
//
//Label gender = new Label("Gender");
//Label negara = new Label ("Nationality");
//
//Button regis = new Button ("Register");
//RadioButton cwo = new RadioButton("Male");
//RadioButton cwe = new RadioButton("Female");
//ToggleGroup genderr = new ToggleGroup();
//cwo.setToggleGroup(genderr);
//cwe.setToggleGroup(genderr);
//
//ComboBox negaraa = new ComboBox();
//ObservableList<String> ya = negaraa.getItems();
//ya.add("Indonesia");
//ya.add("Malaysia");
//ya.add("Nigeria");
//ya.add("Papua Nugini");
//ya.add("Inggris");
//ya.add("Amerika");
//ya.add("Jepang");
//ya.add("Korea");
//ya.add("Kamboja");
//ya.add("Chile");
//ya.add("Filipina");
//ya.add("China");
//ya.add("Singapura");
//
//VBox kanan = new VBox ();
//kanan.getChildren().addAll(gender, cwo,cwe , negara, negaraa, regis);
//kanan.setSpacing(5);
//
//Menu menu = new Menu("Page");
//MenuBar menuBar = new MenuBar();
//MenuItem login = new MenuItem("Login");
//MenuItem register = new MenuItem("Register");
//
//menu.getItems().addAll(login, register);
//menuBar.getMenus().addAll(menu);
//
//HBox utama = new HBox();
//utama.getChildren().addAll(kiri,kanan);
//utama.setAlignment(Pos.CENTER);
//utama.setSpacing(50);
//BorderPane bp = new BorderPane();
//bp.setTop(menuBar);
//bp.setCenter(utama);
//
//return new Scene(bp, 750, 500);
//}