package Test3;

import javax.swing.*;
import java.sql.*;

public class Model {
    Connection koneksi;
    Statement statement;
    ResultSet resultSet;

    private Object[][] data = new Object[50][8];

    public Object[][] getData() {
        read();
        return data;
    }

    public void read(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/praktikum", "root", "");
            statement = koneksi.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM mahasiswa");
            int p = 0;
            while (resultSet.next()){
                data[p][0] = resultSet.getString("nim");
                data[p][1] = resultSet.getString("nama");
                data[p][2] = resultSet.getString("kelamin");
                data[p][3] = resultSet.getString("jurusan");
                data[p][4] = resultSet.getString("alamat");
                p++;
            }
            statement.close();
            koneksi.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Driver tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Create(Object[][] data){
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/praktikum", "root", "");
            statement = koneksi.createStatement();
            statement.executeUpdate("INSERT INTO mahasiswa VALUES('"+data[0][0]+"','"+data[0][1]+"','"+data[0][2]+"','"+data[0][3]+"','"+data[0][4]+"')");
            statement.close();
            koneksi.close();
            JOptionPane.showMessageDialog(null,"Data berhasil disimpan", "Done", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Object[][] Find(int data){
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/praktikum", "root", "");
            statement = koneksi.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM mahasiswa WHERE nim = "+data+"");
            int p = 0;
            while (resultSet.next()){
                this.data[p][1] = resultSet.getString("nama");
                this.data[p][2] = resultSet.getString("alamat");
                this.data[p][3] = resultSet.getString("jurusan");
                this.data[p][4] = resultSet.getString("kelamin");
                p++;
            }
            statement.close();
            koneksi.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return this.data;
    }

    public Object[][] Update(Object[][] data, int nim){
        this.data = data;
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/praktikum", "root", "");
            statement = koneksi.createStatement();
            statement.executeUpdate("UPDATE mahasiswa SET nama='"+data[0][0]+"', alamat='"+data[0][1]+"', jurusan='"+data[0][2]+"', kelamin='"+data[0][3]+"' WHERE nim="+nim+"");
            statement.close();
            koneksi.close();
            JOptionPane.showMessageDialog(null,"Data berhasil diedit", "Done", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return this.data;
    }

    public void Delete(int data){
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/praktikum", "root", "");
            statement = koneksi.createStatement();
            statement.executeUpdate("DELETE FROM mahasiswa WHERE nim = "+data+"");
            statement.close();
            koneksi.close();
            JOptionPane.showMessageDialog(null,"Data berhasil dihapus", "Done", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void DeleteAll(){
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/praktikum", "root", "");
            statement = koneksi.createStatement();
            statement.executeUpdate("DELETE FROM mahasiswa");
            statement.close();
            koneksi.close();
            JOptionPane.showMessageDialog(null,"Data berhasil dihapus", "Done", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
