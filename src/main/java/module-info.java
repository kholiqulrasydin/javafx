module com.kelompok3.crud_mahasiswa {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires mysql.connector.java;
    requires java.sql;

    opens com.kelompok3.crud_mahasiswa to javafx.fxml;
    exports com.kelompok3.crud_mahasiswa;
    exports com.kelompok3.crud_mahasiswa.models;
    opens com.kelompok3.crud_mahasiswa.models to javafx.fxml;
}