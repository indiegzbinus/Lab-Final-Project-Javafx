package application;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends Pages {
    private GridPane gridpane;
    private Label labelEmail, labelPassword;
    private TextField emailField;
    private PasswordField passwordField;
    private Button loginButton;
    private Alert blankAlert, wrongEmailPasswordAlert, invalidAlert;

    protected void init() {
        labelEmail = new Label("Email");
        labelPassword = new Label("Password");
        emailField = new TextField();
        emailField.setPrefWidth(200);
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
        gridpane.add(emailField, 0, 1);
        gridpane.add(labelPassword, 0, 2);
        gridpane.add(passwordField, 0, 3);
        gridpane.add(loginButton, 0, 4);
        newScene(gridpane);
    }

    protected void eventHandler(Stage stage) {
        loginMenuItem.setOnAction(e -> {
            // Nothing
        });

        registerMenuItem.setOnAction(e -> {
            Register register = new Register();
            register.show(stage);
        });

        loginButton.setOnAction(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();

            blankAlert = new Alert(Alert.AlertType.WARNING, "Email and Password must be filled!");
            wrongEmailPasswordAlert = new Alert(Alert.AlertType.WARNING, "Wrong Email or Password!");
            invalidAlert = new Alert(Alert.AlertType.ERROR, "Something unexpected occurred!");

            if (email.isBlank() || password.isBlank()) {
                blankAlert.show();
            } else if (isEmailUnique(email)) {
                wrongEmailPasswordAlert.show();
            } else if (!isPasswordCorrect(email, password)) {
                wrongEmailPasswordAlert.show();
            } else {
                switch (getAccountType(email, password)) {
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

    public String getAccountType(String email, String password) {
        String accountTypeQuery = String.format("SELECT UserRole FROM msuser WHERE UserEmail = '%s' AND UserPassword = '%s'", email, password);
        ResultSet accountTypeResultSet = connection.execQuery(accountTypeQuery);
        try {
            if (accountTypeResultSet.next()) {
                return accountTypeResultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Invalid";
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