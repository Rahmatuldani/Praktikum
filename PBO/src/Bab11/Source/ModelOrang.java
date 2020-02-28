package Bab11.Source;

import javax.swing.*;

public class ModelOrang {
    private String namaDepan, namaTengah, namaBelakang;
    private ListenerOrang listenerOrang;

    protected void fireOnChange(){
        if (listenerOrang != null){
            listenerOrang.onChange(this);
        }
    }

    public ListenerOrang getOrangListener(){
        return listenerOrang;
    }

    public void setOrangListener(ListenerOrang listenerOrang){
        this.listenerOrang = listenerOrang;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
        fireOnChange();
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
        fireOnChange();
    }

    public String getNamaTengah() {
        return namaTengah;
    }

    public void setNamaTengah(String namaTengah) {
        this.namaTengah = namaTengah;
        fireOnChange();
    }

    public void resetForm(){
        setNamaBelakang("");
        setNamaTengah("");
        setNamaDepan("");
    }

    public void submitForm(ViewOrang viewOrang){
        JOptionPane.showMessageDialog(null, "Data     : " + viewOrang.getFnamadepan().getText() + " " + viewOrang.getFnamatengah().getText() + " " + viewOrang.getFnamabelakang().getText() + " sudah di submit");
    }
}
