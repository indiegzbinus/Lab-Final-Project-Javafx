package data;
import javafx.beans.property.*;

public class Product {
    private final StringProperty name;
    private final StringProperty brand;
    private final IntegerProperty stock;
    private final DoubleProperty price;

    public Product(String name, String brand, int stock, double price) {
        this.name = new SimpleStringProperty(name);
        this.brand = new SimpleStringProperty(brand);
        this.stock = new SimpleIntegerProperty(stock);
        this.price = new SimpleDoubleProperty(price);
    }

    // Getters and property methods for name, brand, stock, and price...

    // Define getters and property methods for brand and stock
    public String getBrand() {
        return brand.get();
    }

    public StringProperty getName() {
        return name;
    }

    public DoubleProperty getPrice() {
        return price;
    }

    public StringProperty brandProperty() {
        return brand;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public int getStock() {
        return stock.get();
    }

    public IntegerProperty stockProperty() {
        return stock;
    }

    public DoubleProperty priceProperty() {
        return price;
    }


    public void setStock(int stock) {
        this.stock.set(stock);
    }

}