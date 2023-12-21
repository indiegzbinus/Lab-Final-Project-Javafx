package application;

import data.Product;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Home extends Pages {
	
	private Scene scene;
	
	private VBox detailsVBox;
	
	private TableView<Product> dataTable;
	private TableColumn<Product, String> nameColumn;
	private TableColumn<Product, String> brandColumn;
	private TableColumn<Product, Integer> stockColumn;
	private TableColumn<Product, Double> priceColumn;
	
	private ObservableList<Product> dataList;
	
    private Label nameLabel;
    private Label brandLabel;
    private Label stockLabel;
    private Label priceLabel;
    private Spinner<Integer> quantitySpinner;
    private Label totalPriceLabel;
    Label nama, brand, stock, price, totalprice;

    private Product selectedProduct;

    protected void init() {
    	dataTable = new TableView<>();
        dataTable.setMaxSize(300, 150);

        // Create columns for the TableView
        nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        brandColumn = new TableColumn<>("Brand");
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));

        stockColumn = new TableColumn<>("Stock");
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));

        priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Add columns to TableView
        dataTable.getColumns().addAll(nameColumn, brandColumn, stockColumn, priceColumn);

        // Simulated data for demonstration (Replace this with actual database retrieval)
        dataList = getProductFromProductbase();

        // Set data into the table
        dataTable.setItems(dataList);

        // Labels to display selected data details
        nameLabel = new Label();
        brandLabel = new Label();
        stockLabel = new Label();
        priceLabel = new Label();
        quantitySpinner = new Spinner<>(1, 100, 1);
        totalPriceLabel = new Label();

        nama = new Label("Product Name :");
        brand = new Label("Product Brand:");
        price = new Label("Price        :");
        totalprice = new Label("Total Price  :");
        detailsVBox = new VBox(
        		nama,
        		nameLabel,
        		brand,
                brandLabel,
                price,
                priceLabel,
                quantitySpinner,
                totalprice,
                totalPriceLabel
        );
        root.setCenter(detailsVBox);
    }

    // Simulated method to fetch data from the database (Replace with your database logic)
    private ObservableList<Product> getProductFromProductbase() {
        dataList = FXCollections.observableArrayList();
        // Add some sample data
        dataList.add(new Product("Product1", "Brand1", 10, 25.99));
        dataList.add(new Product("Product2", "Brand2", 15, 15.50));
		return dataList;
    }

	@Override
	protected void eventHandler(Stage stage) {
		// TODO Auto-generated method stub
        // View data details and calculate total price when a row is selected
        dataTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedProduct = newSelection;
                nameLabel.setText("" + newSelection.getName());
                brandLabel.setText("" + newSelection.getBrand());
                stockLabel.setText("" + newSelection.getStock());
                priceLabel.setText("" + newSelection.getPrice());

             // Calculate total price based on quantity
                IntegerProperty quantity = new SimpleIntegerProperty(quantitySpinner.getValue());
                double totalPrice = quantity.getValue() * newSelection.getPrice().doubleValue();
                totalPriceLabel.setText(String.format("%.2f", totalPrice));

                // Update total price label when spinner value changes
                quantitySpinner.valueProperty().addListener((obsQty, oldQty, newQty) -> {
                    double newTotalPrice = newQty.intValue() * newSelection.getPrice().doubleValue();
                    totalPriceLabel.setText(String.format("%.2f", newTotalPrice));
                });
            }
        });
	}

	@Override
	protected void show(Stage stage) {
		initUser();
		init();
		eventHandler(stage);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Home");
		stage.show();
	}
}