package com.kelompok3.crud_mahasiswa;

import com.kelompok3.crud_mahasiswa.models.Mahasiswa;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author kholiqul
 */
public class DataHelper {

    public static Connection getConnection(){
        Connection mysqlConnection;
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String database = "crud";
            String username = "userlogical";
            String password = "greatly";
            String mysqlUrl = "jdbc:mysql://localhost:3306/"+ database +"?user="+ username +"&password="+ password;
            mysqlConnection = (Connection) DriverManager.getConnection(mysqlUrl);
            System.out.println("Connection successfully");
            return mysqlConnection;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    static ObservableList<Mahasiswa> dataMahasiswa(){
        ObservableList<Mahasiswa> mahasiswaList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM mahasiswa";
        Statement st;
        java.sql.ResultSet rs;

        try{
            assert conn != null;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Mahasiswa mahasiswa;
            while(rs.next()){
                mahasiswa = new Mahasiswa(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("nim"),
                        rs.getString("kelas")
                );
                mahasiswaList.add(mahasiswa);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return mahasiswaList;
    }


    public static void updateData(Mahasiswa mahasiswa){
        System.out.println(mahasiswa.getId());
//        String result = "";
        Connection conn = getConnection();
        String query = "UPDATE mahasiswa SET nama='"+mahasiswa.getNama()+"', nim='"+mahasiswa.getNim()+"', kelas='"+mahasiswa.getKelas()+"' WHERE id="+mahasiswa.getId()+";";
        Statement stmt = null;

        try {
            assert conn != null;
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            // Now do something with the ResultSet ....
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ignored) { } // ignore

                stmt = null;
            }
        }

    }

    public static void createData(Mahasiswa mahasiswa){
        System.out.println(mahasiswa.getNama());
//        String result = "";
        Connection conn = getConnection();
        String query = "INSERT INTO mahasiswa(nama, nim, kelas) values('"+mahasiswa.getNama()+"', '"+mahasiswa.getNim()+"', '"+mahasiswa.getKelas()+"');";
        Statement st;

        try{
            assert conn != null;
            st = conn.createStatement();
            st.executeUpdate(query);

        }catch(Exception ex){
            ex.printStackTrace();
        }

//        return result;
    }

    public static void deleteRow(Mahasiswa mahasiswa){
        Connection conn = getConnection();
        String query = "DELETE FROM mahasiswa WHERE id="+mahasiswa.getId()+";";
        Statement st;
        ResultSet rs;

        try{
            assert conn != null;
            st = conn.createStatement();
            st.executeUpdate(query);
//            rs.getBoolean(0);

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }


}
