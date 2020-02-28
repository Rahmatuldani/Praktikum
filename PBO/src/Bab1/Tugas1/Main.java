package Bab1.Tugas1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("No 1 : ");
        satu();

        System.out.println("\nNo 3 : ");
        tiga();
    }

    public static void satu() {
        int angka[] = new int[5];
        char nilai[] = {'C', 'D', 'B', 'A', 'E'};
        angka[0] = 5;
        angka[1] = 3;
        angka[2] = 7;
        angka[3] = 9;
        angka[4] = 2;
        int terkecil = 9;
        char nilaihuruf = 'x';

        for (int i = 0; i < 5; i++) {
            if (terkecil > angka[i]){
                terkecil = angka[i];
                nilaihuruf = nilai[i];
            }
        }
        System.out.println("Terkecil : " + terkecil);
        System.out.println("Nilai Huruf : " + nilaihuruf);
    }

    public static void tiga() {
        System.out.println("Masukan banyak urutan bintang : ");
        Scanner object = new Scanner(System.in);
        Integer banyak = object.nextInt();
        for (int i = 1; i <= banyak; i++){
            for (int j = banyak; j >= i; j--) {
                System.out.print(' ');
            }
            for (int k = 1; k <= i; k++){
                System.out.print('*');
            }
            for (int l = 1; l <= i - 1; l++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
