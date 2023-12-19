package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

public class Register extends Pages{
	// Panes
	GridPane gridPane;
	// Register Scene
	HBox registerHBox;
	VBox registerVBox1, registerVBox2;
	Label labelRegisterUsername, labelRegisterPassword, labelRegisterConfirmPassword, labelAge, labelGender, labelNationality;
	TextField textfieldRegisterUsername;
	PasswordField passwordFieldRegister, passwordFieldConfirmRegister;
	Spinner<Integer> ageSpinner;
	RadioButton maleRadioButton, femaleRadioButton;
	ComboBox<String> nationalityComboBox;
	Button registerButton;
	
	protected void init() {
		// Panes
		root = new BorderPane();
		gridPane = new GridPane();
		
		// Menu Bars
	    menuBar = new MenuBar();
	    menu = new Menu("Page");
	    loginMenuItem = new MenuItem("Login");
	    registerMenuItem = new MenuItem("Register");
	    
	    // Fill Later
		loginMenuItem.setOnAction(e -> {
		});
		
		registerMenuItem.setOnAction(e -> {
		});
	    
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
		textfieldRegisterUsername = new TextField();
		passwordFieldRegister = new PasswordField();
		passwordFieldConfirmRegister = new PasswordField();;
		ageSpinner = new Spinner<Integer>();
		maleRadioButton = new RadioButton("Male");
		femaleRadioButton = new RadioButton("Female");;
		nationalityComboBox = new ComboBox<String>();
		registerButton = new Button("Register");
		
		// Register page
		registerHBox.setPrefHeight(100);
		registerHBox.setPrefWidth(300);
		registerHBox.setSpacing(20);
		registerHBox.setAlignment(Pos.CENTER);
		registerHBox.setPadding(new Insets(20, 20, 20, 20));
		HBox.setMargin(registerHBox, new Insets(20, 20, 20, 20));
		
		registerVBox1.getChildren().addAll(labelRegisterUsername, textfieldRegisterUsername, labelRegisterPassword, passwordFieldRegister, 
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
        scene = new Scene(root);
	}
	
	protected void eventHandler(Stage stage) {
		// Menu Items
		loginMenuItem.setOnAction(e -> {
			Login login = new Login();
			login.show(stage);
			// Nothing
		});
		registerMenuItem.setOnAction(e -> {
			// Fill Action Later
			stage.setScene(scene);
		});
		
	}
	
	public void show(Stage stage) {
		init();
		eventHandler(stage);
		stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
        
        System.out.println("Show Login Page");
	}
}
