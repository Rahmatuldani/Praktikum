package responsi;

import javax.swing.*;
import java.sql.*;

public class Model {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    Object[][] tiket = new Object[data_tiket()][5];
    Object[][] kereta = new Object[data_kereta()][5];

    Model(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/responsi_pbo","root","");
            connection.close();
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error Class Model",JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error SQL Model",JOptionPane.ERROR_MESSAGE);
        }
    }

    public Object[][] all_tiket(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/responsi_pbo","root","");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM penumpang JOIN kereta ON penumpang.id_kereta = kereta.id_kereta");
            int i = 0;
            while (resultSet.next()){
                tiket[i][0] = resultSet.getString("nama_penumpang");
                tiket[i][1] = resultSet.getString("jenis_kelamin");
                tiket[i][2] = resultSet.getString("tujuan_kereta");
                tiket[i][3] = resultSet.getString("nama_kereta");
                i++;
            }
            statement.close();
            connection.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error SQL Model",JOptionPane.ERROR_MESSAGE);
        }
        return tiket;
    }

    public Object[][] all_kereta(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/responsi_pbo","root","");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM kereta");
            int i = 0;
            while (resultSet.next()){
                kereta[i][0] = resultSet.getString("id_kereta");
                kereta[i][1] = resultSet.getString("nama_kereta");
                kereta[i][2] = resultSet.getString("kelas_kereta");
                kereta[i][3] = resultSet.getString("tujuan_kereta");
                i++;
            }
            statement.close();
            connection.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error SQL Model",JOptionPane.ERROR_MESSAGE);
        }
        return kereta;
    }

    public Object[][] create_kereta(Object[][] data){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/responsi_pbo","root","");
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO kereta VALUES('"+ data[0][0] +"','"+ data[0][1] +"','"+ data[0][2] +"','"+ data[0][3] +"')");
            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null,"Berhasil ditambah","Done",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error SQL Model",JOptionPane.ERROR_MESSAGE);
        }
        
        return data;
    }

    public void delete_kereta(String nama){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/responsi_pbo","root","");
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM kereta WHERE id_kereta = '"+ nama +"'");
            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null,"Berhasil dihapus","Done",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error SQL Model",JOptionPane.ERROR_MESSAGE);
        }
    }

    public int data_tiket(){
        int a = 0;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/responsi_pbo","root","");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM penumpang");
            while (resultSet.next()){
                a++;
            }
            statement.close();
            connection.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error SQL Model",JOptionPane.ERROR_MESSAGE);
        }
        return a;
    }

    public String[] get_tujuan(){
        String[] nama = new String[data_kereta()];
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/responsi_pbo","root","");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM kereta GROUP BY tujuan_kereta");
            int a = 0;
            while (resultSet.next()){
                nama[a] = resultSet.getString("tujuan_kereta");
                a++;
            }
            statement.close();
            connection.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error SQL Model",JOptionPane.ERROR_MESSAGE);
        }

        return nama;
    }

    public String[] get_kereta(){
        String[] nama = new String[data_kereta()];
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/responsi_pbo","root","");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM kereta GROUP BY nama_kereta");
            int a = 0;
            while (resultSet.next()){
                nama[a] = resultSet.getString("nama_kereta");
                a++;
            }
            statement.close();
            connection.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error SQL Model",JOptionPane.ERROR_MESSAGE);
        }

        return nama;
    }

    public int data_kereta(){
        int a = 0;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/responsi_pbo","root","");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM kereta");
            while (resultSet.next()){
                a++;
            }
            statement.close();
            connection.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error SQL Model",JOptionPane.ERROR_MESSAGE);
        }
        return a;
    }
}
