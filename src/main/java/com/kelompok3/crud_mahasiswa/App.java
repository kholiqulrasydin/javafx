package com.kelompok3.crud_mahasiswa;

import com.kelompok3.crud_mahasiswa.models.Mahasiswa;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;
//    public TableView<Mahasiswa> mahasiswaTable;
//    TableColumn<Mahasiswa, Integer> columnId;
//    TableColumn<Mahasiswa, String> columnName;
//    TableColumn<Mahasiswa, Integer> columnNim;
//    TableColumn<Mahasiswa, String> columnKelas;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("home"), 430, 640);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
