package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Date;

public class SewaLapanganFutsalApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sewa Lapangan Futsal");

        // Membuat layout GridPane
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);

        // Menambahkan elemen-elemen ke dalam GridPane
        Label labelNama = new Label("Isi Nama:");
        TextField namaTextField = new TextField();
        grid.add(labelNama, 0, 0);
        grid.add(namaTextField, 1, 0);
        
        Label labelNomorTelepon = new Label("Isi Nomor Telepon:");
        TextField nomorTeleponTextField = new TextField();
        grid.add(labelNomorTelepon, 0, 1);
        grid.add(nomorTeleponTextField, 1, 1);
        
        Label labelTanggal = new Label("Pilih Tanggal:");
        DatePicker datePicker = new DatePicker();
        grid.add(labelTanggal, 0, 2);
        grid.add(datePicker, 1, 2);

        Label labelJam = new Label("Pilih Jam:");
        TextField jamTextField = new TextField();
        grid.add(labelJam, 0, 3);
        grid.add(jamTextField, 1, 3);

        Button sewaButton = new Button("Sewa Lapangan");
        grid.add(sewaButton, 1, 4);

        // Menambahkan event handler untuk tombol sewa
        sewaButton.setOnAction(event -> {
            LocalDate tanggalSewa = datePicker.getValue();
            String jamSewa = jamTextField.getText();
            String nama = namaTextField.getText();
            String nomortelepon = nomorTeleponTextField.getText();
            Alert errorblank = new Alert(AlertType.ERROR, "Data yang dimasukkan kosong!");
            Alert confirmation = new Alert(AlertType.CONFIRMATION, "Anda: " + nama + " (" + nomortelepon + 
            		") telah berhasil menyewa lapangan futsal " + "untuk tanggal " + tanggalSewa + " " + jamSewa);
           if (tanggalSewa == null || jamSewa.isBlank() || nama.isBlank() || nomortelepon.isBlank()) {
        	   errorblank.show();
			}
			else{
				confirmation.show();
			}
        });

        // Membuat scene dan menambahkannya ke stage
        Scene scene = new Scene(grid, 500, 300);
        primaryStage.setScene(scene);

        // Menampilkan stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}