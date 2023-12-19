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
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Register extends Pages{
	// Panes
	GridPane gridPane;
	// Register Scene
	HBox hbox;
	VBox registerVBox1, registerVBox2;
	Label labelUsername, labelPassword, labelConfirmPassword, labelAge, labelGender, labelNationality;
	TextField textfieldUsername;
	PasswordField passwordFieldRegister, confirmPasswordField;
	Spinner<Integer> ageSpinner;
	RadioButton maleRadioButton, femaleRadioButton;
	ComboBox<String> nationalityComboBox;
	Button registerButton;
	ToggleGroup genderToggle;
	
	protected void init() {
		// Panes
		root = new BorderPane();
		gridPane = new GridPane();
        // Set root size
        root.setPrefHeight(500);
        root.setPrefWidth(750);
		// Menu Bars
	    menuBar = new MenuBar();
	    menu = new Menu("Page");
	    loginMenuItem = new MenuItem("Login");
	    registerMenuItem = new MenuItem("Register");
        menu.getItems().addAll(loginMenuItem, registerMenuItem);
        menuBar.getMenus().addAll(menu);
	    
		// Register Scene
		hbox = new HBox();
			hbox.setPrefSize(300, 100);
			hbox.setSpacing(20);
			hbox.setAlignment(Pos.CENTER);
			hbox.setPadding(new Insets(20, 20, 20, 20));
		registerVBox1 = new VBox();
			labelUsername = new Label("Username");
			labelPassword = new Label("Password");
			labelConfirmPassword = new Label("Confirm Password"); 
			labelAge = new Label("Age");
			textfieldUsername = new TextField();
			passwordFieldRegister = new PasswordField();
			confirmPasswordField = new PasswordField();;
			ageSpinner = new Spinner<Integer>();
		registerVBox2 = new VBox();
			labelGender = new Label("Gender");
			maleRadioButton = new RadioButton("Male");
			femaleRadioButton = new RadioButton("Female");;
			labelNationality = new Label("Nationality");
			nationalityComboBox = new ComboBox<String>();
			registerButton = new Button("Register");
		
		// Put them together like lego idk
	    root.setTop(menuBar);
	    root.setCenter(hbox);
		registerVBox1.getChildren().addAll(labelUsername, textfieldUsername, labelPassword, passwordFieldRegister, 
				labelConfirmPassword, confirmPasswordField, labelAge, ageSpinner);
		registerVBox2.getChildren().addAll(labelGender, maleRadioButton, femaleRadioButton, nationalityComboBox, registerButton);
		hbox.getChildren().addAll(registerVBox1, registerVBox2);

        
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
        stage.setTitle("Register");
        stage.show();
	}
}
