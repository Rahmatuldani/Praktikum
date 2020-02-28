package Bab8.Source;

import java.io.*;

class InfoFile {
    protected File berkas;
    private String nama = "";
    String address = "";

    public InfoFile() {
        BufferedReader streamText = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Masukan nama sebuah berkas : ");

        try {
            address = streamText.readLine();
        } catch (IOException i) {
            System.exit(0);
        };
        berkas = new File(address);
        cekBerkas();
    }

    public void cekBerkas() {
        if (!berkas.exists()) {
            System.out.println("Berkas tidak ditemukan");
            System.exit(0);
        } else
            nama = berkas.getName();

//        Kondisi
        if (berkas.isDirectory())
            System.out.println(nama + " merupakan direktori");
        else
            System.out.println(nama + " merupakan berkas biasa");

        if (berkas.isHidden())
            System.out.println(nama + " tersembunyi");
        else
            System.out.println(nama + " tidak disembunyikan");

        if (berkas.canRead())
            System.out.println(nama + " dapat dibaca");
        else
            System.out.println(nama + " tidak dapat dibaca");

        if (berkas.canWrite())
            System.out.println(nama + " dapat ditulis");
        else
            System.out.println(nama + " tidak dapat ditulis");
    }
}

public class CekInfoFile {
    public static void main(String[] args) {
        new InfoFile();
    }
}
