package Application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	
	Stage stage;
	
	public Scene initLogInScene() {

		Label labelUsername = new Label("Username:");
		Label labelPassword = new Label("Password:");
		TextField textfieldUsername = new TextField();
		PasswordField passwordfield = new PasswordField();
		Button loginButton = new Button("Login");
		
		GridPane gridpane = new GridPane();
		gridpane.setVgap(10);
		gridpane.setHgap(10);
		gridpane.setMinHeight(500);
		gridpane.setMinWidth(500);
		gridpane.add(labelUsername, 0, 1);
		gridpane.add(textfieldUsername, 0, 2);
		gridpane.add(labelPassword, 0, 3);
		gridpane.add(passwordfield, 0, 4);
		gridpane.add(loginButton, 0, 5);
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setPadding(new Insets(20, 20, 20, 20));
		GridPane.setMargin(gridpane, new Insets(20, 20, 20, 20));

		textfieldUsername.setMinWidth(250);
		passwordfield.setMinWidth(250);
		loginButton.setMinWidth(100);

		Scene scene = new Scene(gridpane, 750, 550);
		
		return scene;
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start(Stage stage) throws Exception {
		stage.setScene(initLogInScene());
		stage.setTitle("Login");
		stage.show();
	}

}
