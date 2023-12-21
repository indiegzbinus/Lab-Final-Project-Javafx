package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class Pages {
	// Connection
	Connection connection;
	
	// Scene
	Scene scene;
	// Panes
	BorderPane root;
	// Menu Bars
    MenuBar menuBar;
    Menu menu;
    MenuItem loginMenuItem, registerMenuItem, homeMenuItem, cartMenuItem, historyMenuItem, logoutMenuItem, manageProductMenuItem, viewHistoryMenuItem;
    
	public void initLandingPage() {
		root = new BorderPane();
		root.setPrefSize(750, 500);
		
	    menuBar = new MenuBar();
		menu = new Menu("Page");
		loginMenuItem = new MenuItem("Login");
		registerMenuItem = new MenuItem("Register");
		menu.getItems().addAll(loginMenuItem, registerMenuItem);
		menuBar.getMenus().add(menu);
	}

	public void initUser() {
		root = new BorderPane();
		root.setPrefSize(750, 500);

		menuBar = new MenuBar();
		menu = new Menu("Page");

		homeMenuItem = new MenuItem("Home");
		cartMenuItem = new MenuItem("Cart");
		historyMenuItem = new MenuItem("History");
		logoutMenuItem = new MenuItem("Logout");
		menu.getItems().addAll(homeMenuItem, cartMenuItem, historyMenuItem, logoutMenuItem);

		menuBar.getMenus().add(menu);
	}

	public void initAdmin() {
		root = new BorderPane();
		root.setPrefSize(750, 500);
		
	    menuBar = new MenuBar();
	    menu = new Menu("Admin");
	    manageProductMenuItem = new MenuItem("Manage Product");
	    viewHistoryMenuItem = new MenuItem("View History");
	    logoutMenuItem = new MenuItem("Logout");
	    menu.getItems().addAll(manageProductMenuItem, viewHistoryMenuItem, logoutMenuItem);
	    menuBar.getMenus().add(menu);
	}

	protected abstract void init();
	protected abstract void eventHandler(Stage stage);
	protected abstract void show(Stage stage);

	public void newScene(Pane pane) {
		connection = Connection.getInstance();
		root.setTop(menuBar);
		root.setCenter(pane);
		scene = new Scene(root);
	}

	public boolean isEmailUnique(String email) {
		String getEmailQuery = String.format("SELECT UserEmail FROM msuser WHERE UserEmail = '%s';", email);
		ResultSet uniqueEmailResultSet = connection.execQuery(getEmailQuery);
		try {
			return !uniqueEmailResultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean isPasswordCorrect(String email, String password) {
		String getPasswordQuery = String.format("SELECT UserEmail FROM msuser WHERE UserEmail = '%s' AND UserPassword = '%s';", email, password);
		ResultSet exactDataResults = connection.execQuery(getPasswordQuery);
		try {
			return exactDataResults.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}