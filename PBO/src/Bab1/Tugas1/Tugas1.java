package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float max = 0, min = 99, sum = 0;

        System.out.println("Nama : ");
        String nama = input.nextLine();

        System.out.println("Berapa nilai yang akan diinputkan? : ");
        int banyak = input.nextInt();
        float nilai[] = new float[banyak];

        for (int i = 0; i < banyak; i++) {
            System.out.println("Nilai ke-" + i + " : ");
            nilai[i] = input.nextFloat();
            sum = sum + nilai[i];

            if (min > nilai[i]){
                min = nilai[i];
            } else if (max < nilai[i]){
                max = nilai[i];
            }
        }

        float rata = sum / banyak;
        System.out.println("Nama : " + nama);
        System.out.println("Nilai Tertinggi : " + max);
        System.out.println("Nilai Terendah : " + min);
        System.out.println("Rata-rata Nilai : " + rata);
    }
}
