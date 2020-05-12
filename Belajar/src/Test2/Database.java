package Test2;

import java.sql.*;

public class Database {
    public static void main(String[] args) {
        String[][] data = new String[10][5];
        int p = 0;

        try {
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/praktikum", "root", "");
            Statement query = koneksi.createStatement();
            ResultSet isi = query.executeQuery("SELECT * FROM mahasiswa");
            while (isi.next()) {
                data[p][0] = isi.getString("nim");
                data[p][1] = isi.getString("nama");
                data[p][2] = isi.getString("alamat");
                data[p][3] = isi.getString("jurusan");
                data[p][4] = isi.getString("kelamin");
                p++;
            }
            query.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            for (int i = 0; i < p; i++){
                System.out.println("\nNIM : " + data[i][0]);
                System.out.println("Nama : " + data[i][1]);
                System.out.println("Alamat : " + data[i][2]);
                System.out.println("Jurusan : " + data[i][3]);
                System.out.println("Jenis Kelamin : " + data[i][4]);
            }
        }
    }
}
