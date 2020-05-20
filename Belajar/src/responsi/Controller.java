package responsi;

import javax.swing.*;
import java.awt.event.*;

public class Controller extends WindowAdapter implements ActionListener {
    View view;
    Model model;
    Object[][] tiket;
    Object[][] kereta;
    Object[][] data = new Object[1][5];
    Object[][] isi;

    Controller(View view, Model model){
        this.view = view;
        this.model = model;

        tiket = model.all_tiket();
        view.jTable_tiket.setModel(new JTable(tiket,view.column_tiket).getModel());
        kereta = model.all_kereta();
        view.jTable_kereta.setModel(new JTable(kereta,view.column_kereta).getModel());

        view.tujuan = model.get_tujuan();
        view.kereta = model.get_kereta();

        view.bpenumpang.addActionListener(this);
        view.bkereta.addActionListener(this);
        view.btambah_tiket.addActionListener(this);
        view.bbatal_tiket.addActionListener(this);
        view.btambah_kereta.addActionListener(this);
        view.bedit_kereta.addActionListener(this);
        view.bhapus_kereta.addActionListener(this);
        view.bbatal_kereta.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == view.bpenumpang){
            view.getContentPane().removeAll();
            view.Penumpang();
        }
        if (actionEvent.getSource() == view.bkereta){
            view.getContentPane().removeAll();
            view.Kereta();
        }
        if (actionEvent.getSource() == view.btambah_tiket){
            data[0][0] = view.fnama_tiket.getText();
            data[0][1] = view.fjk_tiket.getSelectedItem();
            data[0][2] = view.ftujuan_tiket.getSelectedItem();
            data[0][3] = view.fkereta_tiket.getSelectedItem();
        }
        if (actionEvent.getSource() == view.bbatal_tiket){
            view.getContentPane().removeAll();
            view.MainView();
        }
        if (actionEvent.getSource() == view.btambah_kereta){
            String nama = view.fnama_kereta.getText().substring(0,3).toUpperCase();
            int num = model.data_kereta();

            data[0][0] = nama+num;
            data[0][1] = view.fnama_kereta.getText();
            data[0][2] = view.fkelas_kereta.getSelectedItem();
            data[0][3] = view.ftujuan_kereta.getText();
            isi = model.create_kereta(data);

            view.table_kereta.setRowCount(num);
            view.table_kereta.addRow(isi);
//            JOptionPane.showMessageDialog(null,num,"Controller",JOptionPane.ERROR_MESSAGE);
        }
        if (actionEvent.getSource() == view.bedit_kereta){
//            isi = view.jTable_kereta.getValueAt(view.jTable_kereta.getSelectedRow(),0);
        }
        if (actionEvent.getSource() == view.bhapus_kereta){
            String nama = view.table_kereta.getValueAt(0,0).toString();
            JOptionPane.showMessageDialog(null,nama,"Controller",JOptionPane.ERROR_MESSAGE);
            model.delete_kereta(nama);
            view.table_kereta.removeRow(view.jTable_kereta.getSelectedRow());
        }
        if (actionEvent.getSource() == view.bbatal_kereta){
            view.getContentPane().removeAll();
            view.MainView();
        }
    }
}
