package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Register extends Pages{
	// Register Scene
	HBox hbox;
	VBox vbox1, vbox2;
	Label labelUsername, labelPassword, labelConfirmPassword, labelAge, labelGender, labelNationality;
	TextField textfieldUsername;
	PasswordField passwordFieldRegister, confirmPasswordField;
	Spinner<Integer> ageSpinner;
	RadioButton maleRadioButton, femaleRadioButton;
	ComboBox<String> nationalityComboBox;
	Button registerButton;
	ToggleGroup genderToggle;
	
	protected void init() {
		// Register Scene
		vbox1 = new VBox();
			vbox1.setSpacing(10);
			vbox1.setAlignment(Pos.CENTER_LEFT);
			labelUsername = new Label("Username");
			labelPassword = new Label("Password");
			labelConfirmPassword = new Label("Confirm Password"); 
			labelAge = new Label("Age");
			textfieldUsername = new TextField();
			passwordFieldRegister = new PasswordField();
			confirmPasswordField = new PasswordField();;
			ageSpinner = new Spinner<Integer>(1,1,100);
				ageSpinner.setEditable(true);
			vbox1.getChildren().addAll(labelUsername, textfieldUsername, labelPassword, passwordFieldRegister, 
					labelConfirmPassword, confirmPasswordField, labelAge, ageSpinner);
		vbox2 = new VBox();
			vbox2.setSpacing(10);
			vbox2.setAlignment(Pos.CENTER_LEFT);
			labelGender = new Label("Gender");
			genderToggle = new ToggleGroup();
				maleRadioButton = new RadioButton("Male");
					maleRadioButton.setUserData("Male");
					maleRadioButton.setToggleGroup(genderToggle);
				femaleRadioButton = new RadioButton("Female");
					femaleRadioButton.setUserData("Female");
					femaleRadioButton.setToggleGroup(genderToggle);
				genderToggle.selectToggle(maleRadioButton);
			labelNationality = new Label("Nationality");
			nationalityComboBox = new ComboBox<String>();
				nationalityComboBox.setPrefWidth(100);
			registerButton = new Button("Register");
				registerButton.setPrefWidth(100);
			vbox2.getChildren().addAll(labelGender, maleRadioButton, femaleRadioButton, nationalityComboBox, registerButton);
		hbox = new HBox();
			hbox.setPrefSize(750, 500);
			hbox.setSpacing(20);
			hbox.setAlignment(Pos.CENTER);
			hbox.setPadding(new Insets(20, 20, 20, 20));
			hbox.getChildren().addAll(vbox1, vbox2);

		// Create scene
		newScene(hbox);
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
		initLandingPage();
		init();
		eventHandler(stage);
		stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Register");
        stage.show();
	}
}
