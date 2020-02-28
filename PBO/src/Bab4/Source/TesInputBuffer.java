package Bab3.Source;

import java.io.*;

class Input {
    public static long bacaData() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long angka = 0;
        try {
            String input = br.readLine();
            angka = Long.parseLong(input);
        } catch (Exception e) {
            System.out.println("Input Salah. Inisialisasi dg nilai " + angka);
        } finally {
            return angka;
        }
    }
}

public class TesInputBuffer {
    public static void main(String[] args) {
        System.out.println("Masukan angka : ");
        long i = Input.bacaData();
        System.out.println("Angka yang anda masukan adalah " + i);
    }
}
