package Test4;

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
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/dbcontact", "root", "");
            statement = koneksi.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM dbcontact");
            int p = 0;
            while (resultSet.next()){
                data[p][0] = resultSet.getString("nama");
                data[p][1] = resultSet.getString("hp");
                data[p][2] = resultSet.getString("umur");
                data[p][3] = resultSet.getString("email");
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
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/dbcontact", "root", "");
            statement = koneksi.createStatement();
            statement.executeUpdate("INSERT INTO dbcontact VALUES('"+data[0][0]+"','"+data[0][1]+"','"+data[0][2]+"','"+data[0][3]+"')");
            statement.close();
            koneksi.close();
            JOptionPane.showMessageDialog(null,"Data berhasil disimpan", "Done", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Object[][] Find(String data){
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/dbcontact", "root", "");
            statement = koneksi.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM dbcontact WHERE nama = '"+data+"'");
            int p = 0;
            while (resultSet.next()){
                this.data[p][0] = resultSet.getString("nama");
                this.data[p][1] = resultSet.getString("hp");
                this.data[p][2] = resultSet.getString("umur");
                this.data[p][3] = resultSet.getString("email");
                p++;
            }
            statement.close();
            koneksi.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return this.data;
    }

    public Object[][] Update(Object[][] data, String nama){
        this.data = data;
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/dbcontact", "root", "");
            statement = koneksi.createStatement();
            statement.executeUpdate("UPDATE dbcontact SET hp='"+data[0][1]+"', umur="+data[0][2]+", email='"+data[0][3]+"' WHERE nama='"+nama+"'");
            statement.close();
            koneksi.close();
            JOptionPane.showMessageDialog(null,"Data berhasil diedit", "Done", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return this.data;
    }

    public void Delete(String data){
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/dbcontact", "root", "");
            statement = koneksi.createStatement();
            statement.executeUpdate("DELETE FROM dbcontact WHERE nama = '"+data+"'");
            statement.close();
            koneksi.close();
            JOptionPane.showMessageDialog(null,"Data berhasil dihapus", "Done", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void DeleteAll(){
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/dbcontact", "root", "");
            statement = koneksi.createStatement();
            statement.executeUpdate("DELETE FROM dbcontact");
            statement.close();
            koneksi.close();
            JOptionPane.showMessageDialog(null,"Data berhasil dihapus", "Done", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
