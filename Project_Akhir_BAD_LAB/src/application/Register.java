package application;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Register extends Pages{
	// Register Scene
	HBox hbox;
	VBox vbox1, vbox2;
	Label labelEmail, labelPassword, labelConfirmPassword, labelAge, labelGender, labelNationality;
	TextField textfieldEmail;
	PasswordField passwordFieldRegister, confirmPasswordField;
	Spinner<Integer> ageSpinner;
	RadioButton maleRadioButton, femaleRadioButton;
	ComboBox<String> nationalityComboBox;
	ObservableList<String> countryList;
	Button registerButton;
	ToggleGroup genderToggle;
	Font font = new Font(15);
	
	protected void init() {
		
		// Register Scene
		vbox1 = new VBox();
			vbox1.setSpacing(8);
			labelEmail = new Label("Email");
				labelEmail.setFont(font);
			labelPassword = new Label("Password");
				labelPassword.setFont(font);
			labelConfirmPassword = new Label("Confirm Password"); 
				labelConfirmPassword.setFont(font);
			labelAge = new Label("Age");
				labelAge.setFont(font);
			textfieldEmail = new TextField();
			passwordFieldRegister = new PasswordField();
			confirmPasswordField = new PasswordField();;
			ageSpinner = new Spinner<Integer>(1,1,100);
				ageSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100));
				ageSpinner.getValueFactory();
				ageSpinner.setEditable(true);
			vbox1.getChildren().addAll(labelEmail, textfieldEmail, labelPassword, passwordFieldRegister, 
					labelConfirmPassword, confirmPasswordField, labelAge, ageSpinner);
		vbox2 = new VBox();
			vbox2.setSpacing(10);
			labelGender = new Label("Gender");
				labelGender.setFont(font);
			genderToggle = new ToggleGroup();
				maleRadioButton = new RadioButton("Male");
					maleRadioButton.setUserData("Male");
					maleRadioButton.setToggleGroup(genderToggle);
				femaleRadioButton = new RadioButton("Female");
					femaleRadioButton.setUserData("Female");
					femaleRadioButton.setToggleGroup(genderToggle);
				genderToggle.selectToggle(maleRadioButton);
			labelNationality = new Label("Nationality");
				labelNationality.setFont(font);
			nationalityComboBox = new ComboBox<String>();
				nationalityComboBox.setPrefWidth(100);
		        countryList = nationalityComboBox.getItems();
		        countryList.add("Indonesia");
		        countryList.add("Malaysia");
		        countryList.add("Nigeria");
		        countryList.add("Papua Nugini");
		        countryList.add("Inggris");
		        countryList.add("Amerika");
		        countryList.add("Jepang");
		        countryList.add("Korea");
		        countryList.add("Kamboja");
		        countryList.add("Chile");
		        countryList.add("Filipina");
		        countryList.add("China");
		        countryList.add("Singapura");
		        nationalityComboBox.setValue(countryList.get(0));
			registerButton = new Button("Register");
				registerButton.setPrefWidth(100);
			vbox2.getChildren().addAll(labelGender, maleRadioButton, femaleRadioButton, labelNationality, nationalityComboBox, registerButton);
		hbox = new HBox();
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
		});
		registerMenuItem.setOnAction(e -> {
			// Nothing
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
