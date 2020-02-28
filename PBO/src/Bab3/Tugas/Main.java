package Bab3.Tugas;

import Bab3.Tugas.bangundatar.BangunDatar;
import Bab3.Tugas.bangundatar.Lingkaran;
import Bab3.Tugas.bangundatar.Persegi;
import Bab3.Tugas.bangundatar.PersegiPanjang;
import Bab3.Tugas.bangunruang.*;

import java.util.*;

public abstract class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char kembali = 'n';
        int pilih;

        do {
            System.out.println("===== Menu ======");
            System.out.println("1. Bangun Datar");
            System.out.println("2. Bangun Ruang");
            System.out.println("Pilih : ");
            pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    int pilih1;
                        System.out.println("===== Menu ======");
                        System.out.println("1. Persegi");
                        System.out.println("2. Persegi Panjang");
                        System.out.println("3. Lingkaran");
                        System.out.println("Pilih : ");
                        pilih1 = input.nextInt();

                        switch (pilih1) {
                            case 1:
                                System.out.println("Masukan panjang sisi : ");
                                BangunDatar p = new Persegi(input.nextDouble());
                                System.out.println("Luas Persegi : " + p.Luas());
                                System.out.println("Keliling Persegi : " + p.Keliling());
                                System.out.println("\nKembali? : ");
                                kembali = input.next().charAt(0);
                                break;

                            case 2:
                                System.out.println("Masukan panjang : ");
                                double panjang = input.nextDouble();
                                System.out.println("Masukan lebar : ");
                                double lebar = input.nextDouble();
                                BangunDatar pp = new PersegiPanjang(panjang,lebar);
                                System.out.println("Luas Persegi Panjang : " + pp.Luas());
                                System.out.println("Keliling Persegi Panjang : " + pp.Keliling());
                                System.out.println("\nKembali? : ");
                                kembali = input.next().charAt(0);
                                break;

                            case 3:
                                System.out.println("Masukan panjang jari-jari : ");
                                BangunDatar lingkaran = new Lingkaran(input.nextDouble());
                                System.out.println("Luas Lingkaran : " + lingkaran.Luas());
                                System.out.println("Keliling Lingkaran : " + lingkaran.Keliling());
                                System.out.println("\nKembali? : ");
                                kembali = input.next().charAt(0);
                                break;

                            default:
                                System.out.println("Pilihan yang diinputkan salah!");
                                kembali = 'y';
                                break;
                        }
                    break;

                case 2:
                    int pilih2;
                        System.out.println("===== Menu ======");
                        System.out.println("1. Kubus");
                        System.out.println("2. Balok");
                        System.out.println("3. Limas Persegi");
                        System.out.println("4. Tabung");
                        System.out.println("5. Bola");
                        System.out.println("6. Kerucut");
                        System.out.println("Pilih : ");
                        pilih2 = input.nextInt();

                        switch (pilih2) {
                            case 1:
                                System.out.println("Masukan panjang sisi : ");
                                BangunRuang kubus = new Kubus(input.nextDouble());
                                System.out.println("Luas Kubus : " + kubus.Luas());
                                System.out.println("Volume Kubus : " + kubus.Volume());
                                System.out.println("\nKembali? : ");
                                kembali = input.next().charAt(0);
                                break;

                            case 2:
                                System.out.println("Masukan panjang : ");
                                double panjang = input.nextDouble();
                                System.out.println("Masukan lebar : ");
                                double lebar = input.nextDouble();
                                System.out.println("Masukan tinggi : ");
                                double tinggi = input.nextDouble();
                                BangunRuang balok = new Balok(panjang,lebar,tinggi);
                                System.out.println("Luas Balok : " + balok.Luas());
                                System.out.println("Volume Balok : " + balok.Volume());
                                System.out.println("\nKembali? : ");
                                kembali = input.next().charAt(0);
                                break;

                            case 3:
                                System.out.println("Masukan sisi : ");
                                double sisi = input.nextDouble();
                                System.out.println("Masukan tinggi : ");
                                double ltinggi = input.nextDouble();
                                BangunRuang lpersegi = new LimasPersegi(sisi,ltinggi);
                                System.out.println("Luas Limas Persegi : " + lpersegi.Luas());
                                System.out.println("Volume Limas Persegi : " + lpersegi.Volume());
                                System.out.println("\nKembali? : ");
                                kembali = input.next().charAt(0);
                                break;

                            case 4:
                                System.out.println("Masukan jari-jari : ");
                                double jari = input.nextDouble();
                                System.out.println("Masukan tinggi : ");
                                double ttinggi = input.nextDouble();
                                BangunRuang tabung = new Tabung(jari,ttinggi);
                                System.out.println("Luas Tabung : " + tabung.Luas());
                                System.out.println("Volume Tabung : " + tabung.Volume());
                                System.out.println("\nKembali? : ");
                                kembali = input.next().charAt(0);
                                break;

                            case 5:
                                System.out.println("Masukan jari-jari : ");
                                BangunRuang bola = new Bola(input.nextDouble());
                                System.out.println("Luas Bola : " + bola.Luas());
                                System.out.println("Volume Bola : " + bola.Volume());
                                System.out.println("\nKembali? : ");
                                kembali = input.next().charAt(0);
                                break;

                            case 6:
                                System.out.println("Masukan jari-jari : ");
                                double kjari = input.nextDouble();
                                System.out.println("Masukan tinggi : ");
                                double ktinggi = input.nextDouble();
                                BangunRuang kerucut = new Kerucut(kjari,ktinggi);
                                System.out.println("Luas Tabung : " + kerucut.Luas());
                                System.out.println("Volume Tabung : " + kerucut.Volume());
                                System.out.println("\nKembali? : ");
                                kembali = input.next().charAt(0);
                                break;

                            default:
                                System.out.println("Pilihan yang diinputkan salah!");
                                kembali = 'y';
                                break;
                        }
                    break;

                default:
                    System.out.println("Pilihan yang diinputkan salah!");
                    kembali = 'y';
                    break;
            }
        } while (kembali == 'y' || kembali == 'Y');
    }
}
