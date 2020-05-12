/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tescrud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author sistem
 */
public class CFilm {

    MFilm mFilm;
    VFilm vFilm;

    public CFilm(MFilm mFilm, VFilm vFilm) {
        this.mFilm = mFilm;
        this.vFilm = vFilm;

        if (mFilm.getBykData() != 0) {
            String dataFilm[][] = mFilm.ReadFilm();
            vFilm.table.setModel((new JTable(dataFilm, vFilm.judult)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ada");
        }
        vFilm.create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vFilm.getJudul().equals("")
                        || vFilm.getTipe().equals("")
                        || vFilm.getEpisode().equals("")) {
                    JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
                } else {
                    String judul = vFilm.getJudul();
                    String tipe = vFilm.getTipe();
                    String episode = vFilm.getEpisode();
                    String genre = vFilm.getGenre();
                    String status = vFilm.getStatus();
                    String rating = vFilm.getRating();
                    mFilm.InsertFilm(judul, tipe, episode, genre, status, rating);
                    vFilm.tjudul.setText("");
                    vFilm.ttipe.setText("");
                    vFilm.tepisode.setText("");
                    vFilm.tgenre.setText("");
                    vFilm.cstatus.addItem(e);
                    vFilm.trating.setText("");

                    String dataFilm[][] = mFilm.ReadFilm();
                    vFilm.table.setModel(new JTable(dataFilm, vFilm.judult).getModel());
                }
            }
        });

        vFilm.update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean apa = true;
                if (apa == true) {
                    String judul = vFilm.getJudul();
                    String tipe = vFilm.getTipe();
                    String episode = vFilm.getEpisode();
                    String genre = vFilm.getGenre();
                    String status = vFilm.getStatus();
                    String rating = vFilm.getRating();
                    mFilm.UpdateFilm(0, judul, tipe, episode, genre, status, rating);
                    vFilm.tjudul.setText("");
                    vFilm.ttipe.setText("");
                    vFilm.tepisode.setText("");
                    vFilm.tgenre.setText("");
                    vFilm.cstatus.addItem(e);
                    vFilm.trating.setText("");

                    String dataFilm[][] = mFilm.ReadFilm();
                    vFilm.table.setModel(new JTable(dataFilm, vFilm.judult).getModel());
                }
            }}
        );
        
         vFilm.table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int i = vFilm.table.getSelectedRow();
                if (i > 0) {
                    vFilm.tjudul.setText(vFilm.model.getValueAt(i, 1).toString());
                    vFilm.ttipe.setText(vFilm.model.getValueAt(i, 2).toString());
                    vFilm.tepisode.setText(vFilm.model.getValueAt(i, 3).toString());
                    vFilm.tgenre.setText(vFilm.model.getValueAt(i, 4).toString());
                    vFilm.cstatus.addItem(vFilm.model.getValueAt(i, 5).toString());
                    vFilm.trating.setText(vFilm.model.getValueAt(i, 6).toString());
                }
            }
        });
        
 
    }
    
    
}
