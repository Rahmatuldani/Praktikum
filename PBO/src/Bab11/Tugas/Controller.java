package Bab11.Tugas;

import javax.swing.*;

class Controller {
    private Object[][] data;
    private Model model = new Model();

    public void setModel(Model model) {
        this.model = model;
    }

    public void create(View view){
        data[0][0] = view.getFid().getText();
        data[0][1] = view.getFnama().getText();
        data[0][2] = view.getFharga().getText();
        data[0][3] = view.getFjumlah().getText();
        data[0][4] = Integer.parseInt(view.getFharga().getText())*Integer.parseInt(view.getFjumlah().getText());

        if (data[0][0].equals("")){
            JOptionPane.showMessageDialog(view,"ID barang harus diisi","Error",JOptionPane.ERROR_MESSAGE);
        } else if (data[0][1].equals("")){
            JOptionPane.showMessageDialog(view,"Nama barang harus diisi","Error",JOptionPane.ERROR_MESSAGE);
        } else if (data[0][2].equals("")){
            JOptionPane.showMessageDialog(view,"Harga barang harus diisi","Error",JOptionPane.ERROR_MESSAGE);
        } else if (data[0][3].equals("")){
            JOptionPane.showMessageDialog(view,"Jumlah barang harus diisi","Error",JOptionPane.ERROR_MESSAGE);
        } else {
            model.setData(data);
        }
    }

    public Object[][] read(){
        this.data = model.getData();
        return data;
    }

    public Object[][] getData() {
        return data;
    }
}