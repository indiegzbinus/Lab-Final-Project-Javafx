package application;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class Pages {
	//Scene
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
		        menu.getItems().addAll(manageProductMenuItem, viewHistoryMenuItem);
		        menuBar.getMenus().add(menu);
	}
	public void initAdmin() {
		root = new BorderPane();
		root.setPrefSize(750, 500);
		
	    menuBar = new MenuBar();
		    menu = new Menu("Page");
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
		root.setTop(menuBar);
		root.setCenter(pane);
        scene = new Scene(root);
	}
}
