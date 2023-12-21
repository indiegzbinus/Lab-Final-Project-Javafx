package application;

import data.User;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Register extends Pages{
	// Register Scene
	FlowPane flowPane;
	VBox vbox1, vbox2;
	Label labelEmail, labelPassword, labelConfirmPassword, labelAge, labelGender, labelNationality;
	TextField textfieldEmail;
	PasswordField passwordField, confirmPasswordField;
	Spinner<Integer> ageSpinner;
	RadioButton maleRadioButton, femaleRadioButton;
	ComboBox<String> nationalityComboBox;
	ObservableList<String> countryList;
	Button registerButton;
	ToggleGroup genderToggle;
	Font font;
	
	protected void init() {
		// Font
		Font font = new Font(15);
		// Register Scene
		vbox1 = new VBox();
			vbox1.setAlignment(Pos.BASELINE_LEFT);
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
			passwordField = new PasswordField();
			confirmPasswordField = new PasswordField();;
			ageSpinner = new Spinner<Integer>(1,1,100);
				ageSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100));
				ageSpinner.getValueFactory();
				ageSpinner.setEditable(true);
			vbox1.getChildren().addAll(labelEmail, textfieldEmail, labelPassword, passwordField, 
					labelConfirmPassword, confirmPasswordField, labelAge, ageSpinner);
		vbox2 = new VBox();
			vbox2.setAlignment(Pos.BASELINE_LEFT);
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
		flowPane = new FlowPane();
			flowPane.setHgap(20);
			flowPane.setAlignment(Pos.CENTER);
			flowPane.getChildren().addAll(vbox1, vbox2);
		// Create scene
		newScene(flowPane);
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
		
		// Register button verification
		registerButton.setOnAction(e -> {
			String email, password, confirmPassword, gender, nationality;
			Integer age;
			email = textfieldEmail.getText();
			password = passwordField.getText();
			confirmPassword = confirmPasswordField.getText();
			age = ageSpinner.getValue();
			gender = genderToggle.getSelectedToggle().getUserData().toString();
			nationality = nationalityComboBox.getValue();
			
			if (!email.endsWith("@gmail.com")) {
				Alert notGmailAlert = new Alert(AlertType.WARNING, "Email must ends with ‘@gmail.com’.");
				notGmailAlert.show();
			} else if (!isEmailUnique(email)) {
				Alert uniqueEmailAlert = new Alert(AlertType.WARNING, "Email must be unique");
				uniqueEmailAlert.show();
			} else if (password.length()<6) {
				Alert passwordLengthAlert = new Alert(AlertType.WARNING, "Password must contain minimum 6 characters");
				passwordLengthAlert.show();
			} else if (!password.equals(confirmPassword)) {
				Alert confirmPasswordAlert = new Alert(AlertType.WARNING, "Confirm Password must be the same as Password.");
				confirmPasswordAlert.show();
			} else if (age < 1) {
				Alert ageAlert = new Alert(AlertType.WARNING, "Age must be greater than 0");
				ageAlert.show();
			} else if (gender == null) {
				Alert genderAlert = new Alert(AlertType.WARNING, "Gender must be selected");
				genderAlert.show();
			} else if (nationality == null) {
				Alert nationalityAlert = new Alert(AlertType.WARNING, "Nationality must be selected");
				nationalityAlert.show();
			} else {
				System.out.println("Aman, masukkan data user :thumbs_up:");
				User newUser = new User(email, password, gender, nationality, age);
				newUser.registerUserData();
			}
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
