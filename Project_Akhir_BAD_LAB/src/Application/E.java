package Application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class E extends Application {

    // Declare the components as fields
    private Button closeButton;
    private Label emailLabel;
    private TextField emailField;
    private Label passwordLabel;
    private PasswordField passwordField;
    private Button loginButton;

    @Override
    public void init() throws Exception {

        emailLabel = new Label("Email");
        emailField = new TextField();

        passwordLabel = new Label("Password");
        passwordField = new PasswordField();

        loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            // TODO: Add your login logic here
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the login page
        VBox loginPage = new VBox();
        loginPage.setPadding(new Insets(20, 20, 20, 20));
        loginPage.setSpacing(10);
        // Change the alignment of the login page to top left
        loginPage.setAlignment(Pos.TOP_LEFT);

        // Set the preferred width of the email and password fields to match the login button
        emailField.setPrefWidth(loginButton.getWidth());
        passwordField.setPrefWidth(loginButton.getWidth());

        // Add the email, password and login components to the login page
        loginPage.getChildren().addAll(emailLabel, emailField, passwordLabel, passwordField, loginButton);

        // Create the border pane and add the title bar and login page
        BorderPane root = new BorderPane();
        root.setCenter(loginPage);

        // Create the scene and set the stage
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
