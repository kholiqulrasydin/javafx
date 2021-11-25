package com.kelompok3.crud_mahasiswa.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Mahasiswa {
    private SimpleIntegerProperty id;
    private SimpleStringProperty nama;
    private SimpleStringProperty nim;
    private SimpleStringProperty kelas;

    public Mahasiswa(int id, String nama, String nim, String kelas){
        this.id = new SimpleIntegerProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.nim = new SimpleStringProperty(nim);
        this.kelas = new SimpleStringProperty(kelas);
    }

    public int getId(){
        return this.id.get();
    }

    public String getNama(){
        return this.nama.get();
    }

    public String getNim(){
        return this.nim.get();
    }

    public String getKelas(){
        return this.kelas.get();
    }
}
