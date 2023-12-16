package Application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage stage1, stage2;

    public Scene initLogInScene() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Menu menu = new Menu("Page");
        MenuBar menuBar = new MenuBar();
        MenuItem login = new MenuItem("Login");
        MenuItem register = new MenuItem("Register");
        BorderPane bp = new BorderPane();

        menu.getItems().addAll(login, register);
        menuBar.getMenus().addAll(menu);

        Label lblUsername = new Label("Username:");
        Label lblPassword = new Label("Password:");
        TextField textField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");

        Alert errorAlert = new Alert(Alert.AlertType.WARNING);

        HBox usernameBox = new HBox(lblUsername, textField);
        usernameBox.setAlignment(Pos.CENTER);
        usernameBox.setSpacing(10);

        HBox passwordBox = new HBox(lblPassword, passwordField);
        passwordBox.setAlignment(Pos.CENTER);
        passwordBox.setSpacing(10);

        vbox.getChildren().addAll(usernameBox, passwordBox, loginButton);

        loginButton.setOnAction(e -> {
            String username = textField.getText();
            String password = passwordField.getText();

            if (username.isEmpty() || password.isEmpty()) {
                errorAlert.setContentText("Username or password must be filled");
                errorAlert.showAndWait();
            } else if (username.equals("User")) {
                user();
            } else if (username.equals("Admin")) {
                admin();
            } else {
                errorAlert.setContentText("Wrong Username or Password");
                errorAlert.showAndWait();
            }
        });

        textField.setMaxWidth(250);
        passwordField.setMaxWidth(250);

        bp.setTop(menuBar);
        bp.setCenter(vbox);

        register.setOnAction(e -> switchScene(stage1, createRegisPage()));

        return new Scene(bp, 750, 500);
    }

    private void admin() {
        // TODO: Add admin logic here
    }

    private void user() {
        // TODO: Add user logic here
    }

    private Scene createRegisPage() {
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

    public void switchScene(Stage stage, Scene scene) {
        stage.setScene(scene);
        stage.setTitle("Register");
        stage.show();
    }

    public void start(Stage stage) throws Exception {
        this.stage1 = stage;
        stage.setScene(initLogInScene());
        stage.setTitle("Login");
        stage.show();
    }
}
