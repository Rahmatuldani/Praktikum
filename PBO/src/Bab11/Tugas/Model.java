package Bab11.Tugas;

import javax.swing.*;
import java.sql.*;

class Model {
    Object[][] data;
    private Listener listener;

    Statement statement;
    Connection connection;
    ResultSet resultSet;

    protected void fireOnChange(){
        if (listener != null){
            listener.onChange(this);
        }
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public Object[][] getData() {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/mvc","root","");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM barang");
            int p = 0;
            while (resultSet.next()){
                data[p][0] = resultSet.getString("id_barang");
                data[p][1] = resultSet.getString("nama_barang");
                data[p][2] = resultSet.getString("harga");
                data[p][3] = resultSet.getString("jumlah");
                data[p][4] = resultSet.getString("total");
                p++;
            }
//            statement.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }

    public void setData(Object[][] data) {
        this.data = data;
        fireOnChange();
        create(this.data);
    }

    private void create(Object[][] data){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/mvc","root","");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("INSERT INTO barang VALUES('"+data[0][0]+"','"+data[0][1]+"','"+data[0][2]+"','"+data[0][3]+"','"+data[0][4]+"')");
            statement.close();
            JOptionPane.showMessageDialog(null,"Data berhasil ditambah","Done",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void find(String id){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/mvc","root","");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM barang WHERE id_barang = '"+ id +"'");
            if (resultSet == null){
                JOptionPane.showMessageDialog(null,"Barang tidak ada","Error",JOptionPane.ERROR_MESSAGE);
            } else {

            }
            statement.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void update(Object[][] data){

    }

    public void deleteData(String id){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/mvc","root","");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM barang WHERE id_barang = '"+ id +"'");
            if (resultSet == null){
                JOptionPane.showMessageDialog(null,"Barang tidak ada","Error",JOptionPane.ERROR_MESSAGE);
            } else {
                statement.executeUpdate("DELETE FROM barang WHERE id_barang = '"+ id +"'");
            }
            statement.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}