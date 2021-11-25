package com.kelompok3.crud_mahasiswa;

import com.kelompok3.crud_mahasiswa.models.Mahasiswa;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddDataController implements Initializable {
    @FXML
    public TextField nama;
    @FXML
    public TextField nim;
    @FXML
    public TextField kelas;
    @FXML
    public Label label;
    @FXML
    public Button delete;
    @FXML
    public Button back;

    Mahasiswa mahasiswa;
    Stage stage;


    public Button secondaryButton;
    protected Scene scene;


    @FXML
    protected void switchToHome() throws IOException {
        if(this.mahasiswa != null){
            DataHelper.updateData(new Mahasiswa(this.mahasiswa.getId(), this.nama.getText(), this.nim.getText(), this.kelas.getText()));
        }
        if(this.mahasiswa == null && nama.getText().length() > 2 && nim.getText().length() > 2 && kelas.getText().length() > 2){
            DataHelper.createData(new Mahasiswa(0, nama.getText(), nim.getText(), kelas.getText()));
        }
        if(stage != null){
            stage.close();
        }
        App.setRoot("home");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(this.mahasiswa == null){
            delete.setVisible(false);
            delete.managedProperty().bind(delete.visibleProperty());
        }
    }

    void initData(Mahasiswa mahasiswa, Stage stage){
        this.mahasiswa = mahasiswa;
        nama.setText(mahasiswa.getNama());
        nim.setText(mahasiswa.getNim());
        kelas.setText(mahasiswa.getKelas());
        label.setText("Edit Data");
        delete.setVisible(true);
        delete.managedProperty().bind(delete.visibleProperty());
        this.stage = stage;
    }

    @FXML
    public void deleteData() throws IOException {
        DataHelper.deleteRow(this.mahasiswa);
        if(stage != null){
            stage.close();
        }
    }

    @FXML
    public void back() throws IOException {
        if(this.mahasiswa != null){
            stage.close();
        }else{
            App.setRoot("home");
        }
    }
}
