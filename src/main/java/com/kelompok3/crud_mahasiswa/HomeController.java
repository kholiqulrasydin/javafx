package com.kelompok3.crud_mahasiswa;

import com.kelompok3.crud_mahasiswa.models.Mahasiswa;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    public Button primaryButton;
    @FXML
    public TableView<Mahasiswa> mahasiswaTable;

    TableColumn<Mahasiswa, Integer> columnId = new TableColumn<>("ID");
    TableColumn<Mahasiswa, String> columnName = new TableColumn<>("NAMA");
    TableColumn<Mahasiswa, String> columnNim = new TableColumn<>("NIM");
    TableColumn<Mahasiswa, String> columnKelas = new TableColumn<>("KELAS");

    @FXML
    protected void addData() throws IOException {
        App.setRoot("form");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Mahasiswa> data = DataHelper.dataMahasiswa();
        mahasiswaTable.getColumns().addAll(columnId, columnName, columnNim, columnKelas);

        columnId.setCellValueFactory(new PropertyValueFactory<Mahasiswa, Integer>("id"));

        columnName.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nama"));

        columnNim.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nim"));

        columnKelas.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("kelas"));
        System.out.println(data.get(0).getKelas());
        mahasiswaTable.setItems(data);

        mahasiswaTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                mahasiswaTable.getSelectionModel().clearSelection();
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "form.fxml"
                        )
                );

                Stage stage = new Stage(StageStyle.DECORATED);
                try {
                    stage.setScene(
                            new Scene(loader.load())
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }

                AddDataController controller = loader.getController();
                controller.initData(newSelection, stage);

                stage.show();
            }
        });
    }
}
