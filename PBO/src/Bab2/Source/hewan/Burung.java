package Bab3.Source.hewan;

public class Burung {
    public static final boolean bisaTerbang = true;
    public String nama = "";

    public Burung(String nama) {
        this.nama = nama;
        System.out.println("Nama Burung : " + nama);
    }

    public void simpanNama (String nama) {
        this.nama = nama;
    }

    public void hapusNama () {
        nama = "";
    }

    public String bacaNama () {
        return nama;
    }
}
