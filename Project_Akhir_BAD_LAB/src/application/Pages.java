package application;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public abstract class Pages {
	//Scene
	Scene scene;
	// Panes
	BorderPane root;
	// Menu Bars
    MenuBar menuBar;
    Menu menu;
    MenuItem loginMenuItem, registerMenuItem;
    
	protected abstract void init();
	protected abstract void eventHandler(Stage stage);
	protected abstract void show(Stage stage);

}
