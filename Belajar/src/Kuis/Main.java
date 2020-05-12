package Kuis;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char kembali = 'n';
        int tulis, coding, wawancara, pilihan, nim, data;
        do {
            int pilih;
            System.out.println("Form Penilaian Admin/Aslab");
            System.out.println("1. Admin");
            System.out.println("2. Aslab");
            System.out.println("Pilihan");
            pilih = input.nextInt();

            switch (pilih){
                case 1:
                    System.out.println("Masukan Penilaian untuk Admin");
                    System.out.println("Masukan banyak data");
                    data = input.nextInt();

                    try {
                    for (int i = 0; i < data; i++) {

                            System.out.println("Masukan NIM : ");
                            nim = input.nextInt();
                            System.out.println("Test Tulis : ");
                            tulis = input.nextInt();
                            System.out.println("Test Praktek Coding : ");
                            coding = input.nextInt();
                            System.out.println("Test Wawancara : ");
                            wawancara = input.nextInt();
                            System.out.println("Test Praktek Jaringan : ");
                            pilihan = input.nextInt();

                            new Test(tulis, coding, wawancara, pilihan, nim, "Admin");
                        }

                        System.out.println("Kembali? (y/n)");
                        kembali = input.next().charAt(0);
                    } catch (InputMismatchException e) {
                        System.out.println("Maaf data yang anda inputkan salah");
                    }
                    break;

                case 2:
                    System.out.println("Masukan Penilaian untuk Aslab");
                    System.out.println("Masukan banyak data");
                    data = input.nextInt();

                    try {
                    for (int i = 0; i < data; i++) {

                            System.out.println("Masukan NIM : ");
                            nim = input.nextInt();
                            System.out.println("Test Tulis : ");
                            tulis = input.nextInt();
                            System.out.println("Test Praktek Coding : ");
                            coding = input.nextInt();
                            System.out.println("Test Wawancara : ");
                            wawancara = input.nextInt();
                            System.out.println("Test Microteaching : ");
                            pilihan = input.nextInt();

                            new Test(tulis, coding, wawancara, pilihan, nim, "Aslab");
                        }

                        System.out.println("Kembali? (y/n)");
                        kembali = input.next().charAt(0);
                    } catch (InputMismatchException e) {
                        System.out.println("Maaf data yang anda inputkan salah");
                    }
                    break;

                default:
                    System.out.println("Pilihan salah, silahkan pilih lagi");
                    kembali = 'y';
                    break;
            }
        } while (kembali == 'y');
    }
}